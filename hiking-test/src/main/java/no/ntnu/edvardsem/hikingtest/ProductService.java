package no.ntnu.edvardsem.hikingtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Business logic related to products
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    /**
     * Get all products
     * @return a list of all products
     */
    public List<Product> getProducts() {
        List<Product> products = new LinkedList<>();
        this.repository.findAll().forEach(products::add);
        return products;
    }

    /**
     * Updates a product in the database
     * @param newProduct a new product with updated values
     * @param id the id of the product to be updated
     * @return {@code true} if product was successfully updated,
     * {@code false} otherwise.
     */
    public boolean updateProduct(Product newProduct, int id) {
        boolean updated = false;
        Optional<Product> result = this.repository.findById(id);
        if (result.isPresent()) {
            Product oldProduct = result.get();
            if (oldProduct.getId() == id) {
                this.repository.delete(oldProduct);
                this.repository.save(newProduct);
                updated = true;
            }
        }
        return updated;
    }

    /**
     * Adds a product to the repository
     * @param product the product to add
     * @return {@code true} if product was successfully added,
     * {@code false} otherwise
     */
    public boolean addProduct(Product product) {
        boolean added = false;
        if (this.repository.findByName(product.getName()) == null) {
            this.repository.save(product);
            added = true;
        }
        return added;
    }
}
