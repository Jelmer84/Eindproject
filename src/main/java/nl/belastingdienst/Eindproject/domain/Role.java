package nl.belastingdienst.Eindproject.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private int id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {}

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

    @ManyToMany(mappedBy = "roles")
    private Collection<User> User_id = new ArrayList<User>();

    public Collection<User> getUser_id() {
        return User_id;
    }

    public void setUser_id(Collection<User> user_id) {
        User_id = user_id;
    }
}