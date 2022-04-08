package no.edvardsen.backend.services;

import no.edvardsen.backend.entities.Product;
import no.edvardsen.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    // TODO
}
