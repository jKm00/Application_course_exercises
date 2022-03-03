package no.ntnu.edvardsem.hikingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API controller for products collection
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    /**
     * Returns all the products in the database
     * @return all products in database
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(this.service.getProducts(), HttpStatus.OK);
    }
}
