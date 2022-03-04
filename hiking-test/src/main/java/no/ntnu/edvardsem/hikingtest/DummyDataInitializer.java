package no.ntnu.edvardsem.hikingtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Fills the database with dummy data when Spring Boot app has started
 */
@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    private final Logger logger = LoggerFactory.getLogger("DummyInit");

    /**
     * Adds dummy data to the database. If database is already initialized,
     * no data are added to make sure there won't be any duplicated data.
     * @param event Event not used
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (isDataImported()) {
            logger.info("Data already added! Exiting method so that there won't be any duplicated data...");
            return;
        }
        logger.info("Importing dummy data...");
        Product boots = new Product("Hiking Boots", "Hold your feet warm", 2400, 20);
        Product sweater = new Product("Winter Sweater", "Holds the heat effectively", 800, 15);
        Product hat = new Product("Winter Hat", "Fits well on most heads", 200, 50);

        productRepository.save(boots);
        productRepository.save(sweater);
        productRepository.save(hat);

        Customer customer1 = new Customer("Joakim", "Edvardsen");

        customerRepository.save(customer1);

        logger.info("Finished importing dummy data...");
    }

    /**
     * Checks if the repository has any data
     * @return {@code true} if repository contains any data,
     * {@code false} otherwise
     */
    private boolean isDataImported() {
        return this.productRepository.count() > 0;
    }
}
