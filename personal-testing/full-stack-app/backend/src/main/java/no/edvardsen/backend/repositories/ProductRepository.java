package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
