package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.PartItem;

import java.util.List;

public interface PartItemService {

    PartItem saveObject(PartItem object);

    List<PartItem> saveObjects(List<PartItem> objects);

    PartItem getObjectByID (Long id);

    PartItem getByName(String name);

    List<PartItem> findAll();

    PartItem checkIfExists(PartItem object);

    String deleteObject(long id);
}