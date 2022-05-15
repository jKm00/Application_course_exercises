package no.edvardsen.relationtest.controllers;

import no.edvardsen.relationtest.dto.AddProductRequest;
import no.edvardsen.relationtest.entities.Product;
import no.edvardsen.relationtest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns all products. If no product is found null is returned
     * @return products or null if no product is found
     */
    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest productDetails) {
        if (this.productService.addProduct(productDetails.getTitle(), productDetails.getDesc(), productDetails.getPrice(), productDetails.getColors())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("Could not add product " + productDetails.getTitle(), HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id) {
        if (this.productService.removeProduct(id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("No product with id " + id, HttpStatus.BAD_REQUEST);
    }
}
