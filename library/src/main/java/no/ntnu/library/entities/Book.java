package no.ntnu.library.entities;

import io.swagger.annotations.ApiModelProperty;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Book {
    @ApiModelProperty(notes ="The unique id of the book")
    private int id;
    @ApiModelProperty(notes ="The title of the book")
    private String title;
    @ApiModelProperty(notes ="The year the book was published")
    private int year;
    @ApiModelProperty(notes ="The number of pages the book contains")
    private int numberOfPages;
    @ApiModelProperty(notes ="A list of all the author who wrote the book")
    private List<Integer> authors;

    public Book(int id, String title, int year, int numberOfPages) {
        this.setId(id);
        this.setTitle(title);
        this.setYear(year);
        this.setNumberOfPages(numberOfPages);
        this.authors = new LinkedList<>();
    }

    /**
     * Returns a list with all authors of the book
     * @return authors of the book
     */
    public List<Integer> getAuthors() {
        return this.authors;
    }

    /**
     * Checks if the book has an author with authorId given.
     * @param authorId the id of the author
     * @return {@code true} if the book as an author with that id,
     * {@code false} otherwise.
     */
    public boolean hasAuthor(int authorId) {
        boolean authorFound = false;
        Iterator<Integer> it = this.authors.iterator();
        while (!authorFound && it.hasNext()) {
            if (it.next() == authorId) {
                authorFound = true;
            }
        }
        return authorFound;
    }

    /**
     * Adds an author to the authors list. If the author
     * is already in the list, nothing will be added.
     * @param authorId the id of the author to be added.
     */
    public void addAuthor(int authorId) {
        if (!this.hasAuthor(authorId)) {
            this.authors.add(authorId);
        }
    }

    /**
     * Checks if the object is a valid book
     * @return {@code true} is its valid, {@code false}
     * if not
     */
    public boolean isValid() {
        return (id > 0 && !this.title.isEmpty() && this.year > 0 && this.numberOfPages > 0);
    }

    /**
     * Returns the id of the book
     * @return the id of the book
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of the book
     * @param id, new id of the book
     */
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be below 0");
        }
        this.id = id;
    }

    /**
     * Returns the title of the book
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets a new title to the book
     * @param title, the new title to be set
     */
    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title of cannot be empty");
        }
        this.title = title;
    }

    /**
     * Returns the year the book was published
     * @return the year the book was published
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year the book was published
     * @param year, the year the book was published
     */
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be below 0");
        }
        this.year = year;
    }

    /**
     * Returns the number of pages in the book
     * @return number of pages in the book
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Sets the number of pages in the book
     * @param numberOfPages, number of pages in the book
     */
    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 0) {
            throw new IllegalArgumentException("Book cannot have less then 0 pages");
        }
        this.numberOfPages = numberOfPages;
    }
}
