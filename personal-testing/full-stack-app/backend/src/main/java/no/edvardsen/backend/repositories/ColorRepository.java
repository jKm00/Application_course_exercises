package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Color;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color, Integer> {
}
