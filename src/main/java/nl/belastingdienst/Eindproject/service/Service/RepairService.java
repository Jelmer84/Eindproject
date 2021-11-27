package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.domain.Repair;
import nl.belastingdienst.Eindproject.domain.RepairResponse;
import nl.belastingdienst.Eindproject.domain.StatusProcess;
import nl.belastingdienst.Eindproject.dto.RepairDto;

import java.util.List;

public interface RepairService {

    Repair saveObject( Long customerId,RepairDto object);

    List<Repair> saveObjects(List<Repair> objects);

    RepairDto getObjectByID (Long id);

    List<RepairResponse> findAll(String customerId);

    List<Repair> getByStatus (StatusProcess status);

    Repair checkIfExists(Repair object);

    String deleteObject(Long id);

    void deleteAllByCustomer(Customer customer);
}
