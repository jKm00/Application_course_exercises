package no.edvardsen.backend.services;

import no.edvardsen.backend.entities.*;
import no.edvardsen.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductEntryRepository productEntryRepository;

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

    /**
     * Returns all the colors for the product with the id given
     *
     * @param id of the product to find the colors to
     * @return a list of all colors
     */
    public List<String> getColorsByProductId(int id) {
        // Find all product entries for the product with the id given
        return this.productEntryRepository.findColorsForProduct(id);
    }

    /**
     * Returns all the sizes for the product with the id given
     *
     * @param id of the product to find the sizes to
     * @return a list of all size
     */
    public List<String> getSizesByProductId(int id) {
        return this.productEntryRepository.findSizesForProduct(id);
    }


    /**
     * Returns all the for a product with the id as given
     *
     * @param id the if of the product to get details about
     * @return a list with every detail for that product
     */
    public List<ProductDetail> getDetailsByProductId(int id) { return this.productDetailRepository.findDetailsByProductId(id); }

    // TODO
}
