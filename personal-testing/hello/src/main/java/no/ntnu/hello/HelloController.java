package no.ntnu.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * Returns a greeting message
     * @return a greeting message
     */
    @GetMapping("/hello")
    public String greeting() {
        return "Hello World";
    }
}
