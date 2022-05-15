package no.edvardsen.relationtest.repositories;

import no.edvardsen.relationtest.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
