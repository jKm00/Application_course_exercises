package no.edvardsen.userapp;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing User data in the database.
 * Spring will auto-generate necessary methods.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
