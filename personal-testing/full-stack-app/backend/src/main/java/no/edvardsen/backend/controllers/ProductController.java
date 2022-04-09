package no.edvardsen.backend.controllers;

import no.edvardsen.backend.entities.Product;
import no.edvardsen.backend.entities.ProductDetail;
import no.edvardsen.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    /**
     * Returns a product with the id given
     *
     * @param id the id of the product to find
     * @return product with the id given
     */
    @GetMapping("/{id}")
    @CrossOrigin
    public Product getProductById(@PathVariable int id) {
        return this.productService.getProductById(id);
    }

    /**
     * Returns a list of all products that are featured
     *
     * @return all featured products
     */
    @GetMapping("/featured")
    @CrossOrigin
    public List<Product> getFeatured() {
        return this.productService.getFeatured();
    }

    /**
     * Returns a list of all colors for the product with the id given
     *
     * @param id of the product to get all the colors for
     * @return a list of all colors
     */
    @GetMapping("/colors/{id}")
    @CrossOrigin
    public List<String> getColors(@PathVariable int id) {
        return this.productService.getColorsByProductId(id);
    }

    /**
     * Returns a list of all sizes for the product with the id given
     *
     * @param id of the product to get all the sizes for
     * @return a list of all size
     */
    @GetMapping("/sizes/{id}")
    @CrossOrigin
    public List<String> getSizes(@PathVariable int id) {
        return this.productService.getSizesByProductId(id);
    }

    /**
     * Returns a list of all details for the product with the id given
     *
     * @param id of the product to get all the sizes for
     * @return a list of all details
     */
    @GetMapping("/details/{id}")
    @CrossOrigin
    public List<ProductDetail> getDetails(@PathVariable int id) {
        return this.productService.getDetailsByProductId(id);
    }

    // TODO
}
