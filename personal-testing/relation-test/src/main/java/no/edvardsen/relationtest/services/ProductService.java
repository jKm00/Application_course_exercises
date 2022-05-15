package no.edvardsen.relationtest.services;

import no.edvardsen.relationtest.entities.Product;
import no.edvardsen.relationtest.repositories.ColorRepository;
import no.edvardsen.relationtest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;

    /**
     * Returns all products stored in the database
     * @return products stored in database
     */
    public List<Product> getProducts() {
        return StreamSupport.stream(this.productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /**
     * Adds a product to the database
     * @param title for the product
     * @param desc the description for the product
     * @param price for the product
     * @param colors a list of all colors the product is available in
     * @return true if product was successfully added, false otherwise
     */
    public boolean addProduct(String title, String desc, float price, List<String> colors) {
        return true;
    }

    /**
     * Removes a product from the database
     * @param id of the product to remove
     * @return the product that was deleted on deletion, or null if no product was found with the id
     * given resulting in no deletion.
     */
    public Product removeProduct(Long id) {
        return null;
    }
}
