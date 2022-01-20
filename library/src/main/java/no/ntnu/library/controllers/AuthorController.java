package no.ntnu.library.controllers;

import no.ntnu.library.entities.Author;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class AuthorController {
    private List<Author> authors;

    public AuthorController() {
        this.initializeData();
    }

    

    private void initializeData() {
        this.authors = new LinkedList<>();
        this.authors.add(new Author(1, "Arne", "Jensen", 1963));
        this.authors.add(new Author(2, "Petter", "Karlsen", 1969));
        this.authors.add(new Author(3, "Jens", "Olsen", 2004));
        this.authors.add(new Author(4, "Harald", "Simonsen", 2010));
    }
}
