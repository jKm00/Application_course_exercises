package no.edvardsen.relationtest;

import no.edvardsen.relationtest.entities.Color;
import no.edvardsen.relationtest.entities.Product;
import no.edvardsen.relationtest.entities.ProductEntry;
import no.edvardsen.relationtest.keys.ProductEntryKey;
import no.edvardsen.relationtest.repositories.ColorRepository;
import no.edvardsen.relationtest.repositories.ProductEntryRepository;
import no.edvardsen.relationtest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DummyDataInitializer implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ProductEntryRepository productEntryRepository;

    private Logger logger = Logger.getLogger("Init");

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (productRepository.count() > 0) {
            logger.info("Data already exists...");
        } else {
            logger.info("No data found, initializing...");

            Color black = new Color("Black");
            Color blue = new Color("Blue");
            Color militaryGreen = new Color("Military green");

            Product sweater = new Product("Sweater", "Winter Sweater", 399.9f);
            Product pants = new Product("Pants", "Hiking pants", 549.49f);

            ProductEntry blackSweater = new ProductEntry(new ProductEntryKey(sweater.getId(), black.getId()), sweater, black, 10);
            ProductEntry blueSweater = new ProductEntry(new ProductEntryKey(sweater.getId(), blue.getId()), sweater, blue, 7);
            ProductEntry militaryPants = new ProductEntry(new ProductEntryKey(pants.getId(), militaryGreen.getId()), pants, militaryGreen, 25);

            colorRepository.save(black);
            colorRepository.save(blue);
            colorRepository.save(militaryGreen);

            productRepository.save(sweater);
            productRepository.save(pants);

            productEntryRepository.save(blackSweater);
            productEntryRepository.save(blueSweater);
            productEntryRepository.save(militaryPants);

            logger.info("Finished initializing...");
        }
    }
}
