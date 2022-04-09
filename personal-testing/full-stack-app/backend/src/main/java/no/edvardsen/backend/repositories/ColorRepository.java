package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Integer> {
}
