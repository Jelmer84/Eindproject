package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.domain.Repair;
import nl.belastingdienst.Eindproject.domain.RepairResponse;
import nl.belastingdienst.Eindproject.dto.RepairDto;
import nl.belastingdienst.Eindproject.service.Service.RepairService;
import nl.belastingdienst.Eindproject.domain.Repair;
import nl.belastingdienst.Eindproject.domain.RepairResponse;
import nl.belastingdienst.Eindproject.dto.RepairDto;
import nl.belastingdienst.Eindproject.service.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/repair")

public class RepairController {

    @Autowired
    RepairService service;

    @PostMapping("/create/{id}")
    public ResponseEntity<Repair> addObject(@PathVariable Long id, @RequestBody RepairDto object) {
        return new ResponseEntity<>(service.saveObject(id, object), HttpStatus.CREATED);
    }

    @GetMapping("/all/{customerId}")
    public ResponseEntity<List<RepairResponse>> findAllRepairs(@PathVariable(name = "customerId") String customerId) {
        return new ResponseEntity<>(service.findAll(customerId), HttpStatus.OK);
    }
}
