package no.edvardsen.userapp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a user. Users are stored in the database
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Check if the user object is valid
     * @return {@code true} when valid, {@code false} otherwise
     */
    @JsonIgnore
    public boolean isValid() {
        return !"".equals(username) && !"".equals(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
