package no.ntnu.library.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import no.ntnu.library.model.entities.Book;
import no.ntnu.library.model.registers.BookRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookRegister bookRegister;

    public BookController() {
        this.bookRegister = new BookRegister();
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
    @CrossOrigin
    @GetMapping("")
    @ApiOperation(value = "Returns all the book in the library",
        notes = "If an author id or a minimum number of pages is specified, only books with these specifications will be returned",
        response = Book.class,
        responseContainer = "List")
    public List<Book> getAllBooks(@ApiParam(value = "Filter for only getting books written by the author with the given author id")
                                      @RequestParam(required = false) Integer authorId,
                                  @ApiParam(value = "Filter for only getting books with a minimum amount of pages as specified")
                                  @RequestParam(required = false) Integer minPages) {
        List<Book> booksFound;
        if (authorId == null && minPages == null) {
            booksFound = this.bookRegister.getAllBooks();
        } else if (minPages == null) {
            booksFound = this.bookRegister.getBooksByAuthorId(authorId);
        } else if (authorId == null) {
            booksFound = this.bookRegister.getBooksByMinPages(minPages);
        } else {
            booksFound = this.bookRegister.getBooksByMinPagesAndAuthorId(minPages, authorId);
        }
        return booksFound;
    }

    /**
     * Returns a book with the id given as param.
     * @param id the id of the book.
     * @return a book with the given id.
     */
    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(value = "Find book by id",
        notes = "Returns a book with the id given in the URL",
        response = Book.class,
        responseContainer = "ResponseEntity")
    public ResponseEntity<Book> getBook(@ApiParam(value = "Id for the book you need to retrieve")
                                            @PathVariable Integer id) {
        ResponseEntity<Book> response;
        Book book = this.bookRegister.getBookById(id);
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
    @CrossOrigin
    @PostMapping
    @ApiOperation(value = "Adds a book to the library",
        notes = "Adds the book object provided to the library",
        response = String.class)
    public ResponseEntity<String> addBook(@ApiParam(value = "A book object that will be added to the library")
                                              @RequestBody Book book) {
        ResponseEntity<String> response;
        if (this.bookRegister.addBook(book)) {
            response = new ResponseEntity<>(HttpStatus.OK);
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
    @ApiOperation(value = "Deletes a book from the library",
        notes = "Delete a book with a specific id from the library")
    public ResponseEntity<Book> deleteBook(@ApiParam(value = "The id of the book that should be deleted")
                                                 @PathVariable Integer id) {
        ResponseEntity<Book> response;
        Book deletedBook = this.bookRegister.deleteBook(id);
        if (deletedBook != null) {
            response = new ResponseEntity<>(deletedBook, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getNumberOfBooks() {
        return new ResponseEntity<>(this.bookRegister.getBookCount(), HttpStatus.OK);
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
    @ApiOperation(value = "Updates a book",
        notes = "Updates a book with a new book object containing the updated information",
        response = String.class)
    public ResponseEntity<String> updateBook(@ApiParam(value = "The id of the book that should be updated")
                                                 @PathVariable Integer id,
                                             @ApiParam("The new book object containing the updated information")
                                             @RequestBody Book book) {
        ResponseEntity<String> response;

        try {
            if (this.bookRegister.updateBook(id, book)) {
                response = new ResponseEntity<>(HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (InvalidObjectException e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }
}
