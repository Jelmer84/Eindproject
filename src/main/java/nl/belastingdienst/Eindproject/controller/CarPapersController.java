package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.service.Service.CarPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/carpapers")

public class CarPapersController {
    @Autowired
    CarPaperService service;

    @PostMapping("/add")
    @ResponseBody
    public String upload(@RequestParam(name = "pdf") MultipartFile file, @RequestParam(name = "licensePlate") String licensePlate) throws IOException {
        if (service.verifyIfLicPlateExists(licensePlate)) {
            return "this licPlate already exists";
        } else {
            service.saveDocument(file, licensePlate);
            return "Document saved!";
        }
    }
}

