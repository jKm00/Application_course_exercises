package no.edvardsen.relationtest.repositories;

import no.edvardsen.relationtest.entities.Color;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Long> {
    @Query(value = "SELECT * FROM colors WHERE color = ?", nativeQuery = true)
    Color findByColor(String color);
}
