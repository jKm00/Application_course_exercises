package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.Color;
import no.edvardsen.backend.entities.ProductEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductEntryRepository extends CrudRepository<ProductEntry, Integer> {
    @Query(value = "SELECT * FROM product_entries WHERE product_id = ?", nativeQuery = true)
    List<ProductEntry> findColorsForProduct(int id);
}
