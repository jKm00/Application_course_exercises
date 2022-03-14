package no.ntnu.edvardsem.hikingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(this.service.getProducts(), HttpStatus.OK);
    }

    /**
     * Replaces a product with the product given, so it get's updated
     * @param newProduct the new product with updated values
     * @param id the id of the product to be updated
     * @return {@code 200 OK} if product was successfully updated,
     * {@code 400 BAD REQUEST} otherwise
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product newProduct, @PathVariable int id) {
        ResponseEntity<String> response;
        if (this.service.updateProduct(newProduct, id)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Adds a product to the repository
     * @param product the product to be added
     * @return {@code 200 OK} if product was successfully added,
     * {@code 400 BAD REQUEST} otherwise.
     */
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        ResponseEntity<String> response;
        if (this.service.addProduct(product)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
