package no.edvardsen.userapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Business logic related to users
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Get all users from the application state
     * @return A list of users
     */
    public List<User> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Returns user based on id
     * @param id id of user to look up
     * @return user or {@code null} if no user was found
     */
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    /**
     * Adds a user
     * @param user the user to be added
     * @return {@code true} if user was added, {@code false} otherwise
     */
    public boolean add(User user){
        boolean added = false;
        if (user != null && user.isValid()) {
            User existingUser = findById(user.getId());
            if (existingUser == null) {
                userRepository.save(user);
                added = true;
            }
        }
        return added;
    }

    /**
     * Removes a user
     * @param userId The id of the user to remove
     * @return {@code true} if user was removed, {@code false} otherwise
     */
    public boolean remove(int userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(value -> userRepository.delete(value));
        return user.isPresent();
    }

    /**
     * Search for a user by its username.
     * @param username the username to search for.
     * @return the user found or {@code null} if no user is found.
     */
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
