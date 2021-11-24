package nl.belastingdienst.Eindproject.domain;

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
public class RepairPartItems {
    @Id
    @GeneratedValue
    private long id;
    @Column(name ="part_id")
    private long partId;
    @ManyToOne
    private nl.belastingdienst.Eindproject.domain.Repair repair;
}