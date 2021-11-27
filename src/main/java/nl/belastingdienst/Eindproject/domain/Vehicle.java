package nl.belastingdienst.Eindproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    private Date inspectionDate;
    private String make;
    private int year;
    @Column(unique = true)
    @NotNull(message = "license Plate is required")
    @NotBlank
    private String licensePlate;

    private StatusProcess status;

    @OneToOne
    @JsonIgnore
    CarPapers carPapers;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}