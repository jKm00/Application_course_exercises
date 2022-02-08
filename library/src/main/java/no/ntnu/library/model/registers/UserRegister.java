package no.ntnu.library.model.registers;

import no.ntnu.library.model.entities.User;

import java.util.HashMap;

public class UserRegister {
    private HashMap<String, User> users;

    public UserRegister() {
        this.users = new HashMap<>();
    }

    /**
     * Adds a user to the register
     * @param user the user to be added
     * @return {@code true} if user was added, {@code false} otherwise
     */
    public boolean addUser(User user) {
        if (!user.isValid()) {
            throw new IllegalArgumentException("User is not valid");
        }
        boolean added = false;
        if (!this.users.containsKey(user.getUsername())) {
            this.users.put(user.getUsername(), user);
            added = true;
        }
        return added;
    }

    /**
     * Returns a user with the username given. If no user is found
     * {@code null} will be returned.
     * @param username of the user to find
     * @return user with username given or {@code null} if no user
     * was found with that username
     */
    public User getUser(String username) {
        return this.users.get(username);
    }

    /**
     * Returns the number of entries in the register
     * @return number of entries in the register
     */
    public int size() {
        return this.users.size();
    }
}
