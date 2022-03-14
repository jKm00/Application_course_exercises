package no.ntnu.library.controllers;

import no.ntnu.library.model.entities.User;
import no.ntnu.library.model.registers.UserRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRegister register;

    public UserController() {
        this.register = new UserRegister();
    }

    @GetMapping()
    public User[] getUsers() {
        return this.register.getUsers();
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody User user) {
        ResponseEntity<String> response;
        try {
            boolean added = this.register.addUser(user);
            if (added) {
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody String username, @RequestBody String password) {
        ResponseEntity<User> response;
        User user = this.register.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                response = new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
