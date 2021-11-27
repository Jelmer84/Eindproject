package nl.belastingdienst.Eindproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String place;
    private String zipcode;
    private String telephone;
    @Column(unique = true)
    @NotNull
    private String email;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Vehicle> vehicles;
}
