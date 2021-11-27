package nl.belastingdienst.Eindproject.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void testCreateNewCustomer() {
        Customer customer = new Customer();
        customer.setName("test");
        customer.setEmail("email@email.com");
        customer.setId(1L);
        assertNotNull(customer.getId());
        assertEquals("test", customer.getName());
        assertEquals("email@email.com", customer.getEmail());
        assertEquals(1L, customer.getId());
    }

    @Test
    public void testFailNewCustomer() {
    Customer customer = new Customer();
    customer.setName("test");
    customer.setEmail("email@email.com");
    customer.setId(1L);
    assertNotNull(customer.getId());
    assertNotEquals("test1", customer.getName());
    assertNotEquals("email@email1.com", customer.getEmail());
    assertNotEquals(2L, customer.getId());
}
}