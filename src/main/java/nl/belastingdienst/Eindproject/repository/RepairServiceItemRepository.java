package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.RepairServiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairServiceItemRepository extends JpaRepository<RepairServiceItems, Long> {
}
