package no.ntnu.library.model.entities;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private Date creationDate;
    private String email;

    /**
     * Creates an object of user
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     */
    public User(String username, String password, String email) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.creationDate = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Empty username");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Empty password");
        }
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Empty email");
        }
        this.email = email;
    }
}
