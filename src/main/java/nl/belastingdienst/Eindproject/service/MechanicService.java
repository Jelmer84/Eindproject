package nl.belastingdienst.Eindproject.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MechanicService {

    @PreAuthorize("hasRole('MECHANIC')")
    public String generateMechContent() {
        return "Mechanic Board.";
    }
}
