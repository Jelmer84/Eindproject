package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.PartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartItemRepository extends JpaRepository<PartItem, Long> {
    PartItem findByName(String Name);
}
