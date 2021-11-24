package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}