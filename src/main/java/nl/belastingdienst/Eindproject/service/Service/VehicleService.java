package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.domain.Vehicle;
import nl.belastingdienst.Eindproject.dto.VehicleDto;

import java.util.List;
import java.util.Map;

public interface VehicleService {

    Vehicle saveObject(Vehicle object, Long customerID);

    List<Vehicle> saveObjects(List<Vehicle> objects);

    Vehicle getObjectByID(Long id);

    Vehicle getObjectBylicPlate(String licPlate);

    List<VehicleDto> findAll();

    Vehicle updateVehicle(Vehicle object);

    String deleteObject(long id);

    void assignDocumentToVehicle(Long documentId, Long vehicleId);

    List<VehicleDto> findPayedOrInspected();

    Object updateVehiclesStatus(List<Map<String, Object>> vehicles);

    List<VehicleDto> findAwaitingRepairOrInspectionPlanned();

    List<VehicleDto> findRepairedOrCanceledOrInvoiced();

    void deleteAllByCustomer(Customer customer);
}