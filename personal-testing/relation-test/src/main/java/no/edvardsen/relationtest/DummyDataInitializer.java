package no.edvardsen.relationtest;

import no.edvardsen.relationtest.entities.Color;
import no.edvardsen.relationtest.entities.Product;
import no.edvardsen.relationtest.repositories.ColorRepository;
import no.edvardsen.relationtest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.logging.Logger;

@Component
public class DummyDataInitializer implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;

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
            colorRepository.save(black);
            colorRepository.save(blue);
            colorRepository.save(militaryGreen);

            Product sweater = new Product("Sweater", "Winter Sweater", 399.9f);
            sweater.addColor(black);
            sweater.addColor(blue);
            Product pants = new Product("Pants", "Hiking pants", 549.49f);
            pants.addColor(black);
            pants.addColor(militaryGreen);

            productRepository.save(sweater);
            productRepository.save(pants);

            logger.info("Finished initializing...");
        }
    }
}
