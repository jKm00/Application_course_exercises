package no.ntnu.library.controllers;

import no.ntnu.library.model.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private List<Author> authors;

    public AuthorController() {
        this.initializeData();
    }

    @GetMapping("")
    public List<Author> getAllAuthors() {
        return this.authors;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        ResponseEntity<Author> response;
        Author author = findAuthorById(id);
        if (author != null) {
            response = new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        ResponseEntity<String> response;
        String errorMsg = null;
        if (author == null) {
            errorMsg = "No author given";
        }
        if (!author.isValid()) {
            errorMsg = "Author is not valid";
        }
        if (findAuthorById(author.getId()) != null) {
            errorMsg = "Book already  exists";
        }

        if (errorMsg == null) {
            this.authors.add(author);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        ResponseEntity<String> response;
        Author author = findAuthorById(id);
        if (author != null) {
            this.authors.remove(author);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBook(@PathVariable Integer id, @RequestBody Author author) {
        ResponseEntity<String> response;
        String errorMsg = null;
        Author existingAuthor = null;

        if (author == null) {
            errorMsg = "Author is empty";
        } else if (!author.isValid()) {
            errorMsg = "Author is not valid";
        } else if (id != author.getId()) {
            errorMsg = "Mismatch in the author id";
        } else {
            existingAuthor = findAuthorById(id);
            if (existingAuthor == null) {
                errorMsg = "Author not found";
            }
        }

        if (errorMsg == null) {
            this.authors.remove(existingAuthor);
            this.authors.add(author);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
        }


        return response;
    }

    /**
     * Finds author in the collection by the id given. If
     * no author is found, {@code null} will be returned.
     * @param id the id of the author
     * @return the author with the id given, or {@code null} if
     * no author was found.
     */
    private Author findAuthorById(Integer id) {
        Author authorFound = null;
        Iterator<Author> it = this.authors.iterator();
        while (authorFound == null && it.hasNext()) {
            Author author = it.next();
            if (author.getId() == id) {
                authorFound = author;
            }
        }
        return authorFound;
    }

    private void initializeData() {
        this.authors = new LinkedList<>();
        this.authors.add(new Author(1, "Arne", "Jensen", 1963));
        this.authors.add(new Author(2, "Petter", "Karlsen", 1969));
        this.authors.add(new Author(3, "Jens", "Olsen", 2004));
        this.authors.add(new Author(4, "Harald", "Simonsen", 2010));
    }
}
