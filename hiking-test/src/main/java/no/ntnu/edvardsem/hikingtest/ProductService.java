package no.ntnu.edvardsem.hikingtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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
}
