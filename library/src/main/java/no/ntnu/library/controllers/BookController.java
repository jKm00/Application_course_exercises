package no.ntnu.library.controllers;

import no.ntnu.library.entities.Author;
import no.ntnu.library.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController() {
        this.initializeData();
    }

    /**
     * Returns a list of books with all the books matching the
     * filters. If no filter is given all books are returned.
     * @param authorId, the id of the author. If author id is
     *                  given, only books written by that author
     *                  is returned.
     * @param minPages, number of minimum pages. If minPages is
     *                  given, only books with that amount of pages
     *                  or more will be returned.
     * @return a list of books matching the filter given.
     */
    @GetMapping("")
    public List<Book> getAllBooks(@RequestParam(required = false) Integer authorId, @RequestParam(required = false) Integer minPages) {
        List<Book> booksFound;
        if (authorId == null && minPages == null) {
            booksFound = this.books;
        } else if (minPages == null) {
            booksFound = new LinkedList<>();
            for (Book book : this.books) {
                if (book.hasAuthor(authorId)) {
                    booksFound.add(book);
                }
            }
        } else if (authorId == null) {
            booksFound = new LinkedList<>();
            for (Book book : this.books) {
                if (book.getNumberOfPages() > minPages) {
                    booksFound.add(book);
                }
            }
        } else {
            booksFound = new LinkedList<>();
            for (Book book : this.books) {
                if (book.hasAuthor(authorId) && book.getNumberOfPages() > minPages) {
                    booksFound.add(book);
                }
            }
        }
        return booksFound;
    }

    /**
     * Returns a book with the id given as param.
     * @param id the id of the book.
     * @return a book with the given id.
     */
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

    /**
     * Adds a book
     * @param book the book to be added
     * @return {@code 200 OK} if book was added, {@code 400 BAD REQUEST}
     * otherwise.
     */
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

    /**
     * Deletes a book
     * @param id id of the book to be deleted
     * @return {@code 200 OK} if book was deleted, {@code 404 NOT FOUND}
     * if book wasn't found and couldn't be deleted.
     */
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

    /**
     * Updates a book
     * @param id the id of the book to be updated
     * @param book the updated version of the book
     * @return {@code 200 OK} if book was successfully updated,
     * {@code 400 BAD REQUEST} if the updated book is not valid,
     * {@code 404 NOT FOUND} if there are no books with the id given.
     */
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
        Book book1 = new Book(1, "The Nordic Theory", 2019, 204);
        book1.addAuthor(1);
        book1.addAuthor(3);
        this.books.add(book1);
        Book book2 = new Book(2, "How To Talk To Absolutly Eberyone", 2005, 154);
        book2.addAuthor(1);
        book2.addAuthor(2);
        this.books.add(book2);
        Book book3 = new Book(3, "The Alchemist", 2012, 85);
        book3.addAuthor(4);
        this.books.add(book3);
        Book book4 = new Book(4, "They Both Dia At the End", 2021, 312);
        book4.addAuthor(1);
        book4.addAuthor(2);
        book4.addAuthor(3);
        this.books.add(book4);
    }
}
