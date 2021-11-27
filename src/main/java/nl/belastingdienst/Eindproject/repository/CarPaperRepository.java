package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.CarPapers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPaperRepository extends JpaRepository<CarPapers, Long> {
    CarPapers findByLicensePlate(String licPlate);
}

