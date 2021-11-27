package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.ServiceItem;

import java.util.List;

public interface ServiceItemService {

    ServiceItem saveObject(ServiceItem object);

    List<ServiceItem> saveObjects(List<ServiceItem> objects);

    ServiceItem getObjectByID (Long id);

    ServiceItem getByName(String name);

    List<ServiceItem> findAll();

    ServiceItem checkIfExists(ServiceItem object);

    String deleteObject(long id);
}