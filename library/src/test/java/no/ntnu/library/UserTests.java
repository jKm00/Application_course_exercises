package no.ntnu.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.ntnu.library.model.entities.User;
import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    public void testAddValidUser() {
        User user = new User("joakim", "password123", "joakim@mail.com");
        assertEquals("joakim", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("joakim@mail.com", user.getEmail());
    }

    @Test
    public void testValidMethod() {
        User user = new User("joakim", "password123", "joakim@mail.com");
        assertTrue(user.isValid());
    }
}
