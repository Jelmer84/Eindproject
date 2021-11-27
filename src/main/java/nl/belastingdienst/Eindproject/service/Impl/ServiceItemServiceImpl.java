package nl.belastingdienst.Eindproject.service.Impl;

import nl.belastingdienst.Eindproject.domain.ServiceItem;
import nl.belastingdienst.Eindproject.repository.ServiceItemRepository;
import nl.belastingdienst.Eindproject.service.Service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemServiceImpl implements ServiceItemService {

    @Autowired
    ServiceItemRepository repository;

    @Override
    public ServiceItem saveObject(ServiceItem object) {
        return repository.save(object);
    }

    @Override
    public List<ServiceItem> saveObjects(List<ServiceItem> objects) {
        return repository.saveAll(objects);
    }

    @Override
    public ServiceItem getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public ServiceItem getByName(String name){
        return repository.findByName(name);
    }

    @Override
    public List<ServiceItem> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceItem checkIfExists (ServiceItem object){
        if (Long.valueOf(object.getId()) != null){
            Optional<ServiceItem> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new ServiceItem();
            }
        }
        else{
            return saveObject(object);
        }
    }

    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
