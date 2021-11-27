package nl.belastingdienst.Eindproject.service.Impl;

import nl.belastingdienst.Eindproject.domain.CarPapers;
import nl.belastingdienst.Eindproject.domain.Vehicle;
import nl.belastingdienst.Eindproject.repository.CarPaperRepository;
import nl.belastingdienst.Eindproject.repository.VehicleRepository;
import nl.belastingdienst.Eindproject.service.Service.CarPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CarPaperServiceImpl implements CarPaperService {

    @Autowired
    private CarPaperRepository carPaperRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public CarPapers getDocumentByLicPlate(String licPlate) {
        return carPaperRepository.findByLicensePlate(licPlate);
    }

    @Override
    public void saveDocument(MultipartFile file, String licPlate) throws IOException {
        CarPapers carPapers = new CarPapers();
        carPapers.setLicensePlate(licPlate);
        carPapers.carPapers = file.getBytes();
        carPapers = carPaperRepository.save(carPapers);
        pairDocumentVehicle(licPlate, carPapers);
    }

    private void pairDocumentVehicle(String licPlate, CarPapers carPapers){
        Vehicle existingVehicle= vehicleRepository.findByLicensePlate(licPlate);
        existingVehicle.setCarPapers(carPapers);
        vehicleRepository.save(existingVehicle);
    }
    @Override
    public boolean verifyIfLicPlateExists(String licPlate){
        CarPapers carPapers = carPaperRepository.findByLicensePlate(licPlate);
        if (carPapers != null){
            return true;
        }
        else {
            return false;
        }
    }
}
