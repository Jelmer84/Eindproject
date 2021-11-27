package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.RepairPartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPartItemRepository extends JpaRepository<RepairPartItems, Long> {
}
