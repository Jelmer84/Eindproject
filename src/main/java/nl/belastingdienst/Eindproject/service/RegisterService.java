package nl.belastingdienst.Eindproject.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @PreAuthorize("hasRole('REGISTER')")
    public String generateRegisterContent() {
        return "Register Content.";
    }
}





