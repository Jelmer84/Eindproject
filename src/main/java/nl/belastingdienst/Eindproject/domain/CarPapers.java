package nl.belastingdienst.Eindproject.domain;

import com.sun.istack.NotNull;
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
public class CarPapers {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private String licensePlate;

    @Lob
    public byte[] carPapers;

    @OneToOne(mappedBy = "carPapers")
    Vehicle vehicle;
}