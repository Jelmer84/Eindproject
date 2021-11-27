package nl.belastingdienst.Eindproject.service.Impl;

import nl.belastingdienst.Eindproject.domain.*;
import nl.belastingdienst.Eindproject.dto.RepairDto;
import nl.belastingdienst.Eindproject.repository.*;
import nl.belastingdienst.Eindproject.service.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    RepairRepository repository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RepairPartItemRepository partItemRepository;

    @Autowired
    RepairServiceItemRepository serviceItemRepository;

    @Autowired
    PartItemRepository partItemRepository2;

    @Autowired
    ServiceItemRepository serviceItemRepository2;

    @Override
    public Repair saveObject( Long customerID, RepairDto object) {
        Customer customer = customerRepository.findById(customerID).get();
        Vehicle vehicle = vehicleRepository.findByLicensePlate(object.getLicensePlate());

        Repair repair = new Repair();
        repair.setRemarks(object.getRemarks());
        repair.setCustomer(customer);
        repair.setVehicle(vehicle);

        if (object.getId() != null){
            repair.setId(object.getId());
        }
        repair = repository.save(repair);

        final Repair repair1 = repair;
        object.getUsedItems().forEach(item -> {
            RepairPartItems items = new RepairPartItems();
            items.setRepair(repair1);
            items.setPartId(item.getId());
            partItemRepository.save(items);
        });
        object.getUsedServices().forEach(item -> {
            RepairServiceItems items = new RepairServiceItems();
            items.setRepair(repair1);
            items.setServicePartId(item.getId());
            serviceItemRepository.save(items);
        });
        return repair;
    }

    @Override
    public List<Repair> saveObjects(List<Repair> objects) {
        return repository.saveAll(objects);
    }

    @Override
    public RepairDto getObjectByID(Long id) {
        return null;
    }

    @Override
    public List<RepairResponse> findAll(String customerId) {
        List<Repair> allByCustomerId = repository.findAllByCustomerId(Long.parseLong(customerId));
        return allByCustomerId.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private RepairResponse mapToResponse(Repair repair) {
        RepairResponse response = new RepairResponse();
        List<RepairServiceItems> usedServices = repair.getUsedServices();
        List<RepairPartItems> usedItems = repair.getUsedItems();
        List<Optional<PartItem>> partItems = usedItems.stream()
                .map(item -> partItemRepository2.findById(item.getPartId())).collect(Collectors.toList());
        List<Optional<ServiceItem>> serviceItems = usedServices.stream()
                .map(item -> serviceItemRepository2.findById(item.getServicePartId())).collect(Collectors.toList());
       response.setPartItemList(partItems.stream().map(Optional::get).collect(Collectors.toList()));
       response.setServiceItems(serviceItems.stream().map(Optional::get).collect(Collectors.toList()));
        return response;
    }

    public List<Repair> getByStatus (StatusProcess status){
        return null;
    }

    @Override
    public Repair checkIfExists (Repair object){
        return null;
    }

    @Override
    public String deleteObject(Long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }

    @Transactional
    @Override
    public void deleteAllByCustomer(Customer customer) {
        List<Repair> allById = repository.findAllByCustomer(customer);
        repository.deleteAll(allById);
    }
}
