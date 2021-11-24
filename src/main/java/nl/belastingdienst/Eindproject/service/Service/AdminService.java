package nl.belastingdienst.Eindproject.service.Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }
}