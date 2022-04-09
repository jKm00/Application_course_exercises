package no.edvardsen.backend.repositories;

import no.edvardsen.backend.entities.ProductDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Integer> {
    @Query(value = "SELECT * FROM product_details WHERE product_id = ?", nativeQuery = true)
    List<ProductDetail> findDetailsByProductId(int id);
}
