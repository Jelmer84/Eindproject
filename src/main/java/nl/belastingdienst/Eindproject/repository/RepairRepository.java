package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findAllByCustomerId(long customerId);
}
