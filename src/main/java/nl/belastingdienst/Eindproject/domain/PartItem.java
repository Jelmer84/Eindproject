package nl.belastingdienst.Eindproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PartItem {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private double sellPrice;
    private double buyPrice;
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Repair repair;
}