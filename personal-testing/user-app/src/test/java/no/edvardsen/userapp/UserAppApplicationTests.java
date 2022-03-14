package no.edvardsen.userapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class UserAppApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    private Logger logger = Logger.getLogger("Test-class logger");

    @Test
    void contextLoads() {
        logger.log(Level.INFO, databaseUrl);
    }

    @Test
    void testDatabase() throws Exception {
        assertEquals(0, userRepository.count());
    }
}
