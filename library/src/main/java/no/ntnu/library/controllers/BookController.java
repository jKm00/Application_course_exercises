package no.ntnu.library.controllers;

import no.ntnu.library.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private List<Book> books;

    public BookController() {
        this.initializeData();
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return this.books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        ResponseEntity<Book> response;
        Book book = this.findBookById(id);
        if (book != null) {
            response = new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        ResponseEntity<String> response;
        if (book != null && book.isValid()) {
            Book existingBook = this.findBookById(book.getId());
            if (existingBook == null) {
                this.books.add(book);
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        ResponseEntity<String> response;
        Book book = findBookById(id);
        if (book != null) {
            this.books.remove(book);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        ResponseEntity<String> response;

        // Check if book is in collection
        Book existingBook = findBookById(id);
        if (existingBook != null) {
            // Check if book is valid
            if (book.isValid() && book.getId() == id) {
                // Update book
                this.books.remove(existingBook);
                this.books.add(book);
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                // Return bad request msg
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            // Return not found msg
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    /**
     * Finds book in the collection by id. If not book was
     * found {@code null} will be returned.
     * @param id the id of the book to be found
     * @return the book with the id given, or {@code null} if
     * no book was found in the collection
     */
    private Book findBookById(int id) {
        Book bookFound = null;
        Iterator<Book> it = this.books.iterator();
        while (bookFound == null && it.hasNext()) {
            Book book = it.next();
            if (book.getId() == id) {
                bookFound = book;
            }
        }
        return bookFound;
    }

    private void initializeData() {
        this.books = new LinkedList<>();
        this.books.add(new Book(1, "The Nordic Theory", 2019, 204));
        this.books.add(new Book(2, "How To Talk To Absolutly Eberyone", 2005, 154));
        this.books.add(new Book(3, "The Alchemist", 2012, 85));
        this.books.add(new Book(4, "They Both Dia At the End", 2021, 312));
    }
}
