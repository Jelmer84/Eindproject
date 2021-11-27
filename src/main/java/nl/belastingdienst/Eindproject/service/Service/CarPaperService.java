package nl.belastingdienst.Eindproject.service.Service;

import nl.belastingdienst.Eindproject.domain.CarPapers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CarPaperService {
    CarPapers getDocumentByLicPlate(String licPlate);

    void saveDocument(MultipartFile file, String licPlate) throws IOException;
    boolean verifyIfLicPlateExists(String licPlate);
}
