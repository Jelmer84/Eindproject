package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
    ServiceItem findByName(String Name);
}
