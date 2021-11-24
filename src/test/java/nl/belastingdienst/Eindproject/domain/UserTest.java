package nl.belastingdienst.Eindproject.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void testCreateNewUser() {
        User user = new User();
        user.setUsername("test");
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setId(1);
        assertNotNull(user.getUsername());
        assertEquals("test", user.getUsername());
        assertEquals("email@email.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(1L, user.getId());
    }

    @Test
    public void testFailNewUser() {
        User user = new User();
        user.setUsername("test");
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setId(1);
        assertNotNull(user.getUsername());
        assertNotEquals("test1", user.getUsername());
        assertNotEquals("email1@email.com", user.getEmail());
        assertNotEquals("password1", user.getPassword());
        assertNotEquals(2L, user.getId());
    }
}