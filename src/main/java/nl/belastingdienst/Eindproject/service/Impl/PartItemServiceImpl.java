package nl.belastingdienst.Eindproject.service.Impl;

import nl.belastingdienst.Eindproject.domain.PartItem;
import nl.belastingdienst.Eindproject.repository.PartItemRepository;
import nl.belastingdienst.Eindproject.service.Service.PartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartItemServiceImpl implements PartItemService {

    @Autowired
    PartItemRepository repository;

    @Override
    public PartItem saveObject(PartItem object) {
        return repository.save(object);
    }

    @Override
    public List<PartItem> saveObjects(List<PartItem> objects) {
        return repository.saveAll(objects);
    }

    @Override
    public PartItem getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public PartItem getByName(String name){
        return repository.findByName(name);
    }

    @Override
    public List<PartItem> findAll() {
        return repository.findAll();
    }

    @Override
    public PartItem checkIfExists (PartItem object){
        if (Long.valueOf(object.getId()) != null){
            Optional<PartItem> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new PartItem();
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