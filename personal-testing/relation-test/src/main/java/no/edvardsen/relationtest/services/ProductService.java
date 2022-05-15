package no.edvardsen.relationtest.services;

import no.edvardsen.relationtest.dto.AddProductRequest;
import no.edvardsen.relationtest.entities.Color;
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
        try {
            Product product = new Product(title, desc, price);
            for (String color : colors) {
                Color colorFound = this.colorRepository.findByColor(color);
                if (colorFound == null) {
                    colorFound = new Color(color);
                    this.colorRepository.save(colorFound);
                }
                product.addColor(colorFound);
            }
            this.productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
