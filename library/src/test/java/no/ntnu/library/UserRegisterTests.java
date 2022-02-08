package no.ntnu.library;

import no.ntnu.library.model.entities.User;
import no.ntnu.library.model.registers.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTests {
    UserRegister register;

    @BeforeEach
    public void setUp() {
        register = new UserRegister();
    }

    @Test
    public void testAddUser() {
        User user = new User("joakim", "password123", "joakim@mail.com");
        assertTrue(register.addUser(user));
        assertEquals(1, register.size());
    }

    @Test
    public void testAddUserTwice() {
        User user = new User("joakim", "password123", "joakim@mail.com");
        register.addUser(user);
        assertFalse(register.addUser(user));
    }

    @Test
    public void testGetUser() {
        User user = new User("joakim", "password123", "joakim@mail.com");
        register.addUser(user);

        User userFound = register.getUser(user.getUsername());
        assertEquals(user, userFound);
    }

    @Test
    public void testGetInvalidUser() {
        User userFound = register.getUser("Hans");
        assertEquals(null, userFound);
    }
}
