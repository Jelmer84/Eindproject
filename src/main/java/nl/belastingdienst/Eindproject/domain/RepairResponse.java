package nl.belastingdienst.Eindproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairResponse {
    List<nl.belastingdienst.Eindproject.domain.PartItem> partItemList;
    List<nl.belastingdienst.Eindproject.domain.ServiceItem> serviceItems;
}
