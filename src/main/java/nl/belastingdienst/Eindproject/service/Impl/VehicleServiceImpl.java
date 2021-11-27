package nl.belastingdienst.Eindproject.service.Impl;

import lombok.var;
import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.domain.StatusProcess;
import nl.belastingdienst.Eindproject.domain.Vehicle;
import nl.belastingdienst.Eindproject.dto.VehicleDto;
import nl.belastingdienst.Eindproject.exceptions.RecordNotFoundException;
import nl.belastingdienst.Eindproject.repository.CarPaperRepository;
import nl.belastingdienst.Eindproject.repository.CustomerRepository;
import nl.belastingdienst.Eindproject.repository.VehicleRepository;
import nl.belastingdienst.Eindproject.service.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository repository;
    CarPaperRepository carPaperRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Vehicle saveObject(Vehicle object, Long customerID) {
        Optional<Customer> checkIfCustomerExists = customerRepository.findById(customerID);
        if (checkIfCustomerExists.isPresent()){
            object.setCustomer(checkIfCustomerExists.get());
        }
        else {
            return null;
        }
        return repository.save(object);
    }

    @Override
    public List<Vehicle> saveObjects(List<Vehicle> objects) {
        return repository.saveAll(objects);
    }

    public Vehicle getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }

    public Vehicle getObjectBylicPlate (String licensePlate){
        return repository.findByLicensePlate(licensePlate);
    }

    @Override
    public List<VehicleDto> findAll() {
        List<VehicleDto> collect = repository.findAll().stream().map(vehicle -> new VehicleDto(vehicle.getId(), vehicle.getInspectionDate(),
                vehicle.getMake(), vehicle.getYear(), vehicle.getLicensePlate(), vehicle.getStatus(),
                vehicle.getCustomer().getId())).collect(Collectors.toList());
        return  collect;
    }

    @Override
    public Vehicle updateVehicle (Vehicle object) {
        return repository.save(object);
    }

    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }

    @Override
    public void assignDocumentToVehicle(Long documentId, Long vehicleId) {
        var optionalDocument = carPaperRepository.findById(documentId);
        var optionalVehicle = repository.findById(vehicleId);
        if (optionalDocument.isPresent() && optionalVehicle.isPresent()) {
            var carPapers = optionalDocument.get();
            var vehicle = optionalVehicle.get();
            vehicle.setCarPapers(carPapers);
            repository.save(vehicle);
        } else {
            throw new RecordNotFoundException("Vehicle or document is not found");
        }
    }

    @Override
    public List<VehicleDto> findPayedOrInspected() {
        return repository.findAllByStatusOrStatus(StatusProcess.Inspected, StatusProcess.Payed).stream().map(vehicle -> new VehicleDto(vehicle.getId(), vehicle.getInspectionDate(),
                vehicle.getMake(), vehicle.getYear(), vehicle.getLicensePlate(), vehicle.getStatus(),
                vehicle.getCustomer().getId())).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findAwaitingRepairOrInspectionPlanned() {
        return repository.findAllByStatusOrStatus(StatusProcess.AwaitingRepair, StatusProcess.InspectionPlanned).stream().map(vehicle -> new VehicleDto(vehicle.getId(), vehicle.getInspectionDate(),
                vehicle.getMake(), vehicle.getYear(), vehicle.getLicensePlate(), vehicle.getStatus(),
                vehicle.getCustomer().getId())).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findRepairedOrCanceledOrInvoiced() {
        return repository.findAllByStatusOrStatusOrStatus(StatusProcess.Repaired, StatusProcess.Canceled, StatusProcess.Invoiced).stream().map(vehicle -> new VehicleDto(vehicle.getId(), vehicle.getInspectionDate(),
                vehicle.getMake(), vehicle.getYear(), vehicle.getLicensePlate(), vehicle.getStatus(),
                vehicle.getCustomer().getId())).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteAllByCustomer(Customer customer) {
        List<Vehicle> allById = repository.findAllByCustomer(customer);
        repository.deleteAll(allById);
    }

    @Override
    public Object updateVehiclesStatus(List<Map<String, Object>> vehicles) {
        for (Map<String, Object> map:  vehicles) {
            Optional<Vehicle> byId = repository.findById(Long.parseLong(map.get("id").toString()));
            Vehicle vehicle = byId.get();
            vehicle.setStatus(StatusProcess.valueOf(map.get("status").toString()));
            repository.save(vehicle);
        }
        return true;
    }
}