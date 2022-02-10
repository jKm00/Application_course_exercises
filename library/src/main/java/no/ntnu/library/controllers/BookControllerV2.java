package no.ntnu.library.controllers;

import no.ntnu.library.JdbcConnection;
import no.ntnu.library.model.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for books endpoints using the database
 */
@RestController
@RequestMapping("books2")
public class BookControllerV2 {

    private final JdbcConnection connection;

    public BookControllerV2() {
        this.connection = JdbcConnection.getInstance();
    }

    /**
     * Updates the tile of the book with the id given in the database
     * @param id The id of the book to be updated
     * @param book The updated version of the book
     * @return {@code 200 OK} when updated, {@code INTERNAL SERVER ERROR} when there is no connection to the
     * database and {@code BAD REQUEST} otherwise
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookTitle(@PathVariable Integer id, @RequestBody Book book) {
        ResponseEntity<String> response;
        if (connection.tryConnect()) {
            if (id == book.getId()) {
                try {
                    connection.updateBookTitle(id, book.getTitle());
                    response = new ResponseEntity<>(HttpStatus.OK);
                } catch (Exception e) {
                    response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            response = new ResponseEntity<>("No connection to DB", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBooksByTitle(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (connection.tryConnect()) {
            try {
                String bookTitle = connection.getBookTitle(id);
                response = new ResponseEntity<>(bookTitle, HttpStatus.OK);
            } catch (Exception e) {
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
