package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Size;
import org.springframework.data.repository.CrudRepository;

public interface SizeRepository extends CrudRepository<Size, Integer> {
}
