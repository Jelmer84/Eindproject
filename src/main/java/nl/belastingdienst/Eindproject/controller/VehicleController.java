package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.domain.Vehicle;
import nl.belastingdienst.Eindproject.dto.VehicleDto;
import nl.belastingdienst.Eindproject.service.Impl.CustomerServiceImpl;
import nl.belastingdienst.Eindproject.service.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/car")
public class VehicleController {
    @Autowired
    VehicleService service;

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/create/{customerID}")
    public ResponseEntity<?> addObject(@Valid @RequestBody Vehicle object, @PathVariable Long customerID) {
        Vehicle vehicle = service.saveObject(object, customerID);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("CustomerID not found, customer must be created before vehicle", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Vehicle> findObjectById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }

    @GetMapping("/licPlate/{licPlate}")
    public ResponseEntity<Vehicle> findObjectByLicPlate(@PathVariable String licPlate) {
        return new ResponseEntity<>(service.getObjectBylicPlate(licPlate), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleDto>> findAllVehicles() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/carpage")
    public ResponseEntity<List<VehicleDto>> findAllVehiclesForCarPage() {
        return new ResponseEntity<>(service.findPayedOrInspected(), HttpStatus.OK);
    }

    @GetMapping("/repairpage")
    public ResponseEntity<List<VehicleDto>> findAllVehiclesForRepairPage() {
        return new ResponseEntity<>(service.findAwaitingRepairOrInspectionPlanned(), HttpStatus.OK);
    }

    @GetMapping("/paymentpage")
    public ResponseEntity<List<VehicleDto>> findAllVehiclesForPaymentPage() {
        return new ResponseEntity<>(service.findRepairedOrCanceledOrInvoiced(), HttpStatus.OK);
    }

    @PutMapping("/update/statuses")
    public ResponseEntity<Object> updateStatus(@RequestBody List<Map<String, Object>> vehicles) {
        return new ResponseEntity<>(service.updateVehiclesStatus(vehicles), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateObject(@RequestBody Vehicle object, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateVehicle(object), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id) {
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }

    @PutMapping("{id}/document")
    public void assignDocumentToVehicle(@PathVariable("id") Long vehicleId, @RequestBody Long documentId) {
        service.assignDocumentToVehicle(documentId, vehicleId);
    }
}
