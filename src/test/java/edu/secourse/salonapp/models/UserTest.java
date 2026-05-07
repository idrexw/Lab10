package edu.secourse.salonapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructorAndIdGeneration() {
        User user = new User("jdoe", "pass123", "John Doe", "john@example.com", "C");

        assertEquals("jdoe", user.getUsername());
        assertEquals("pass123", user.getPassword());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmailAddress());

        // Verifies the Random ID bounds in your constructor: rand.nextInt(10000000,99999999)
        assertTrue(user.getAccountId() >= 10000000 && user.getAccountId() < 99999999,
                "Account ID should be within the 8-digit random range");
    }

    @Test
    void testSubclassRoles() {
        // Tests that your subclasses properly assign the role via their constructors
        Stylist testStylist = new Stylist("s_user", "pw", "Stylist Name", "s@mail.com", "S");
        Customer testCustomer = new Customer("c_user", "pw", "Customer Name", "c@mail.com", "C");
        Admin testAdmin = new Admin("a_user", "pw", "Admin Name", "a@mail.com", "A");

        assertEquals("S", testStylist.getRole());
        assertEquals("C", testCustomer.getRole());
        assertEquals("A", testAdmin.getRole());
    }

    @Test
    void testSettersAndGetters() {
        User user = new User("old", "old", "old", "old", "C");

        user.setUsername("new_user");
        user.setPassword("new_pass");
        user.setName("New Name");
        user.setEmailAddress("new@email.com");
        user.setRole("S");
        user.setAccountId(12345678);

        assertEquals("new_user", user.getUsername());
        assertEquals("new_pass", user.getPassword());
        assertEquals("New Name", user.getName());
        assertEquals("new@email.com", user.getEmailAddress());
        assertEquals("S", user.getRole());
        assertEquals(12345678, user.getAccountId());
    }
}