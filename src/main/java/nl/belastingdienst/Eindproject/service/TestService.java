package nl.belastingdienst.Eindproject.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String generatePublicContent() {
        return "Public Content.";
    }

    @PreAuthorize("hasRole('REGISTER')")
    public String generateRegisterContent() {
        return "Register Content.";
    }

    @PreAuthorize("hasRole('MECHANIC')")
    public String generateMechContent() {
        return "Mechanic Board.";
    }

    @PreAuthorize("hasRole('BACKOFFICE')")
    public String generateBackContent() {return "Back Office Board.";}

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }
}

