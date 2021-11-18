package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.repository.UserRepository;
import nl.belastingdienst.Eindproject.service.BackOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/back")
public class BackOfficeController {

    private final BackOfficeService backOfficeService;

    @Autowired
    public BackOfficeController(BackOfficeService backOfficeService) {
        this.backOfficeService = backOfficeService;
    }

    @GetMapping("/home")
    public String backOfficeAccess() {
        return backOfficeService.generateBackContent();
    }

    @Autowired
    private UserRepository repository;
}