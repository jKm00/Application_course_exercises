package no.edvardsen.userapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get all users
     * HTTP GET to /users
     * @return list of all users currently stored in the database
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Get a user by username
     * @param username the username of the user
     * @return the user found or NOT FOUND if no user is found
     */
    @CrossOrigin
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        ResponseEntity<User> response;
        User user = userService.getUser(username);
        if (user != null) {
            response = new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * Add a user to the register
     * @param user the user to be added, from HTTP response body
     * @return {@code 200 OK} on success, {@code 400 BAD REQUEST} on error
     */
    @PostMapping
    public ResponseEntity<String> add(@RequestBody User user) {
        ResponseEntity<String> response;
        if (userService.add(user)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable int id) {
        ResponseEntity<String> response;
        if (userService.remove(id)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
