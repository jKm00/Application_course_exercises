package no.ntnu.edvardsem.hikingtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${application.version}")
    private String appVersion;

    /**
     * Returns the current version of the application as a string
     * @return the current version of the application as a string
     */
    @GetMapping
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<String>("Version: " + appVersion, HttpStatus.OK);
    }
}
