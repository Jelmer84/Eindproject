package nl.belastingdienst.Eindproject.controller;

import nl.belastingdienst.Eindproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public String allAccess() {
        return testService.generatePublicContent();
    }

    @GetMapping("/register")
    public String registerAccess() {
        return testService.generateRegisterContent();
    }

    @GetMapping("/mech")
    public String mechanicAccess() {
        return testService.generateMechContent();
    }

    @GetMapping("/back")
    public String backOfficeAccess() {
        return testService.generateBackContent();
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return testService.generateAdminContent();
    }
}
