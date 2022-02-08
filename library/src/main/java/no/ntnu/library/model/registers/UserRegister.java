package no.ntnu.library.model.registers;

import no.ntnu.library.model.entities.User;

import java.util.HashMap;

public class UserRegister {
    private HashMap<String, User> users;

    public UserRegister() {
        this.users = new HashMap<>();
    }

    public boolean addUser(User user) {
        return true;
    }
}
