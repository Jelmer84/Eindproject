package nl.belastingdienst.Eindproject.service.Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BackOfficeService {

    @PreAuthorize("hasRole('BACKOFFICE')")
    public String generateBackContent() {return "Back Office Board.";}

}
