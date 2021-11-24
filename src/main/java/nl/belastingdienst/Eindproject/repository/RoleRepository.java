package nl.belastingdienst.Eindproject.repository;

import nl.belastingdienst.Eindproject.domain.ERole;
import nl.belastingdienst.Eindproject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);


    Optional<Role> findTopByName(ERole name);


}
