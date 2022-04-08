package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE featured = 1", nativeQuery = true)
    List<Product> findFeatured();
}
