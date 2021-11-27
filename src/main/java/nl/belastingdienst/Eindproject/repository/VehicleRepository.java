package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.domain.StatusProcess;
import nl.belastingdienst.Eindproject.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByLicensePlate(String licensePlate);
    List<Vehicle> findAllByStatusOrStatus(StatusProcess status, StatusProcess status1);
    void deleteAllByCustomer(Customer customer);
    List<Vehicle> findAllByCustomer(Customer customer);

    List<Vehicle>  findAllByStatusOrStatusOrStatus(StatusProcess repaired, StatusProcess canceled, StatusProcess invoiced);
}