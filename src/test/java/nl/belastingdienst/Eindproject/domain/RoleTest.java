package nl.belastingdienst.Eindproject.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testAsignRole() {
        Role role = new Role();
        role.setName(ERole.ROLE_ADMIN);
        assertThat(role.getName()).isNotNull();
        assertThat(role.getName()).isEqualTo(ERole.ROLE_ADMIN);
        role.setId(1);
        assertEquals(role.getId(), 1);
    }

    @Test
    void testFialAsignRole() {
        Role role = new Role();
        role.setName(ERole.ROLE_ADMIN);
        assertThat(role.getName()).isNotNull();
        assertThat(role.getName()).isNotEqualTo(ERole.ROLE_MECHANIC);
        role.setId(1);
        assertEquals(role.getId(), 1);
    }
}