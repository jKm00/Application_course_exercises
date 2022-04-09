package no.edvardsen.backend.services;

import no.edvardsen.backend.entities.Product;
import no.edvardsen.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Returns a list of products
     *
     * @return all products
     */
    public List<Product> getProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    /**
     * Returns all the featured products from the database
     *
     * @return a list of all featured products
     */
    public List<Product> getFeatured() {
        return this.productRepository.findFeatured();
    }

    /**
     * Returns a product with the id given. If no product is found
     * {@code null} will be returned
     *
     * @param id the id of the product to find
     * @return product with the id given
     */
    public Product getProductById(long id) {
        Optional<Product> result = this.productRepository.findById(id);
        return result.orElse(null);
    }
    // TODO
}
