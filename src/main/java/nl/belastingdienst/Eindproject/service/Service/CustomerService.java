package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer object);

    List<Customer> findAll();

    Customer getObjectByID (Long id);

    Customer getByName(String name);

    String deleteObject(long id);
}
