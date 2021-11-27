package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.domain.ServiceItem;
import nl.belastingdienst.Eindproject.service.Service.ServiceItemService;
import nl.belastingdienst.Eindproject.domain.ServiceItem;
import nl.belastingdienst.Eindproject.service.Service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/service")

public class ServiceItemController {
    @Autowired
    ServiceItemService service;

    @PostMapping("/create")
    public ResponseEntity<ServiceItem> addObject(@RequestBody ServiceItem object) {
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }

    @PostMapping("/create/list")
    public ResponseEntity<List<ServiceItem>> addObjects(@RequestBody List<ServiceItem> objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ServiceItem> findObjectById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ServiceItem> findObjectByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceItem>> findAllServiceItems() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceItem> updateObject(@RequestBody ServiceItem object) {
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
