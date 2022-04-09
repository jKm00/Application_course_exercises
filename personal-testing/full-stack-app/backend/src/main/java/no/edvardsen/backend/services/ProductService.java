package no.edvardsen.backend.services;

import no.edvardsen.backend.entities.Color;
import no.edvardsen.backend.entities.Product;
import no.edvardsen.backend.entities.ProductEntry;
import no.edvardsen.backend.entities.Size;
import no.edvardsen.backend.repositories.ColorRepository;
import no.edvardsen.backend.repositories.ProductEntryRepository;
import no.edvardsen.backend.repositories.ProductRepository;
import no.edvardsen.backend.repositories.SizeRepository;
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
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
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
    public List<Color> getColorsByProductId(int id) {
        // Find all product entries for the product with the id given
        List<Integer> colorIds = this.productEntryRepository.findColorsForProduct(id);
        // Create a list where colors are stored
        List<Color> colors = new ArrayList<>();
        // Iterate through all product entries
        for (Integer colorId : colorIds) {
            // Get color from color repository by the color if specified in the product entry
            Optional<Color> color = this.colorRepository.findById(colorId);
            // Add color to list
            color.ifPresent(colors::add);
        }
        return colors;
    }

    /**
     * Returns all the sizes for the product with the id given
     *
     * @param id of the product to find the sizes to
     * @return a list of all size
     */
    public List<Size> getSizesByProductId(int id) {
        List<Integer> sizeIds = this.productEntryRepository.findSizesForProduct(id);
        List<Size> sizes = new ArrayList<>();
        for (Integer sizeId: sizeIds) {
            Optional<Size> size = this.sizeRepository.findById(sizeId);
            size.ifPresent(sizes::add);
        }
        return sizes;
    }

    // TODO
}
