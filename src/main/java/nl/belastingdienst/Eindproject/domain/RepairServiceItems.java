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
public class RepairServiceItems {
    @Id
    @GeneratedValue
    private long id;
    @Column(name ="service_part_id")
    private long servicePartId;
    @ManyToOne
    private nl.belastingdienst.Eindproject.domain.Repair repair;
}