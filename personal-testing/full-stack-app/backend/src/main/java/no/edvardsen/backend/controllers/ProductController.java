package no.edvardsen.backend.controllers;

import no.edvardsen.backend.entities.Product;
import no.edvardsen.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns all products
     * @return a list of all products
     */
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // TODO
}
