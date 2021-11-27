package nl.belastingdienst.Eindproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Repair {
    @Id
    @GeneratedValue
    private Long id;
    private String remarks;
    @OneToOne
    @JsonIgnore
    private Customer customer;
    @OneToOne
    @JsonIgnore
    private Vehicle vehicle;
    @OneToMany(mappedBy = "repair")
    private List<RepairPartItems> usedItems;
    @OneToMany(mappedBy = "repair")
    private List<RepairServiceItems> usedServices;
}