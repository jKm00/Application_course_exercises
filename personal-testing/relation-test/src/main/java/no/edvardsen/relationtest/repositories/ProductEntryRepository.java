package no.edvardsen.relationtest.repositories;

import no.edvardsen.relationtest.entities.ProductEntry;
import no.edvardsen.relationtest.keys.ProductEntryKey;
import org.springframework.data.repository.CrudRepository;

public interface ProductEntryRepository extends CrudRepository<ProductEntry, ProductEntryKey> {
}
