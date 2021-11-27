package nl.belastingdienst.Eindproject.domain;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private int id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
