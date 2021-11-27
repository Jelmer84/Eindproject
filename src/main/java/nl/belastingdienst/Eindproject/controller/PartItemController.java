package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.domain.PartItem;
import nl.belastingdienst.Eindproject.service.Service.PartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/item")
public class PartItemController {

    @Autowired
    PartItemService service;

    @PostMapping("/create")
    public ResponseEntity<PartItem> addObject(@RequestBody PartItem object) {
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PartItem>> findAllPartItems() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}