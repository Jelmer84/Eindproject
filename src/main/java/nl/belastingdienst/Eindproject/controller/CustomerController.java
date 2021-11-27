package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.domain.Customer;
import nl.belastingdienst.Eindproject.service.Service.CustomerService;
import nl.belastingdienst.Eindproject.service.Service.RepairService;
import nl.belastingdienst.Eindproject.service.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    RepairService repairService;

    @PostMapping("/create")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> findObjectById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable Long id) {
        Customer objectByID = service.getObjectByID(id);
        repairService.deleteAllByCustomer(objectByID);
        vehicleService.deleteAllByCustomer(objectByID);
        String s = service.deleteObject(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}