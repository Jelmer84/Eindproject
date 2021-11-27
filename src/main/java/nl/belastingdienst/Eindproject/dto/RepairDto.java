package nl.belastingdienst.Eindproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.belastingdienst.Eindproject.domain.PartItem;
import nl.belastingdienst.Eindproject.domain.ServiceItem;
import nl.belastingdienst.Eindproject.domain.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepairDto {

    private Long id;
    private String licensePlate;
    private List<PartItem> usedItems;
    private List<ServiceItem> usedServices;
    private String remarks;
    private Double totalPriceExTax;
    private Double totalPriceInTax;
    private Double totalTaxAmount;

}
