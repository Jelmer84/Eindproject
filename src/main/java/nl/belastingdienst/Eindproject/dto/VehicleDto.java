package nl.belastingdienst.Eindproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.belastingdienst.Eindproject.domain.StatusProcess;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class VehicleDto {

    private Long id;
    private Date inspectionDate;
    private String make;
    private int year;
    private String licensePlate;
    private StatusProcess status;
    private Long customerId;
}