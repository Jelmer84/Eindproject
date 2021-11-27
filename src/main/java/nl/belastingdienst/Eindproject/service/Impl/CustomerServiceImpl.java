package nl.belastingdienst.Eindproject.service.Impl;

import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.repository.CustomerRepository;
import nl.belastingdienst.Eindproject.service.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getObjectByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!" + id;
    }
}
