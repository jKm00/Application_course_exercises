package no.ntnu.library.model.registers;

import no.ntnu.library.model.entities.Book;

import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookRegister {
    private List<Book> books;

    public BookRegister() {
        this.initializeData();
    }

    /**
     * Returns a list of all books in the register
     * @return a list of all books in the register
     */
    public List<Book> getAllBooks() {
        return this.books;
    }

    /**
     * Returns a list of all books that are written by the author
     * with the authorId given
     * @param authorId the id of the author who wrote the books
     * @return a list of books
     */
    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> result = new LinkedList<>();
        for (Book book : this.books) {
            if (book.hasAuthor(authorId)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns a list of books with a minimum of pages as specified
     * @param minPages the least amount of pages the book needs to contain to
     *                 be returned
     * @return a list of books
     */
    public List<Book> getBooksByMinPages(int minPages) {
        List<Book> result = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getNumberOfPages() > minPages) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns a book with the given id. {@code null} is returned if no
     * book was found with the given id.
     * @param id of the book
     * @return a book
     */
    public Book getBookById(int id) {
        Book result = null;
        Iterator<Book> it = this.books.iterator();
        while (it.hasNext() && result == null) {
            Book book = it.next();
            if (book.getId() == id) {
                result = book;
            }
        }
        return result;
    }

    /**
     * Adds a book to the register.
     * @param book the book to be added
     * @return {@code true} if book was added, {@code false} if not
     */
    public boolean addBook(Book book) {
        boolean bookAdded = false;
        if (book != null && book.isValid()) {
            Book existingBook = this.getBookById(book.getId());
            if (existingBook == null) {
                this.books.add(book);
                bookAdded = true;
            }
        }
        return bookAdded;
    }

    /**
     * Delete a book from the register
     * @param id of the book to be deleted
     * @return the book that was just deleted, or {@code} null
     * if no book with the given id was found and nothing was deleted
     */
    public Book deleteBook(int id) {
        Book book = getBookById(id);
        if (book != null) {
            this.books.remove(book);
        }
        return book;
    }

    public int getBookCount() {
        return this.books.size();
    }

    /**
     * Updates a book
     * @param id the id of the book to be updated
     * @param book the updated version of the book
     * @return {@code true} if book was successfully updated,
     * {@code false} otherwise
     */
    public boolean updateBook(int id, Book book) throws InvalidObjectException {
        if (!book.isValid()) {
            throw new InvalidObjectException("Not valid book object");
        }
        boolean bookUpdated = false;
        Book existingBook = this.getBookById(id);
        if (existingBook != null) {
            if (book.getId() == id) {
                this.books.remove(existingBook);
                this.books.add(book);
                bookUpdated = true;
            }
        }
        return bookUpdated;
    }

    /**
     * Returns a list of books with a minimum of pages as specified and where at least
     * on of the author has the same id as the author id given
     * @param minPages the least amount of pages the book needs to contain
     *                 to be returned
     * @param authorId the id of  the author who wrote the books
     * @return a list of books
     */
    public List<Book> getBooksByMinPagesAndAuthorId(int minPages, int authorId) {
        List<Book> result = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getNumberOfPages() > minPages && book.hasAuthor(authorId)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Initialize the register with some dummy data
     */
    private void initializeData() {
        this.books = new LinkedList<>();
        Book book1 = new Book(1, "The Nordic Theory", 2019, 204);
        book1.addAuthor(1);
        book1.addAuthor(3);
        this.books.add(book1);
        Book book2 = new Book(2, "How To Talk To Absolutely Everyone", 2005, 154);
        book2.addAuthor(1);
        book2.addAuthor(2);
        this.books.add(book2);
        Book book3 = new Book(3, "The Alchemist", 2012, 85);
        book3.addAuthor(4);
        this.books.add(book3);
        Book book4 = new Book(4, "They Both Die At the End", 2021, 312);
        book4.addAuthor(1);
        book4.addAuthor(2);
        book4.addAuthor(3);
        this.books.add(book4);
    }
}
