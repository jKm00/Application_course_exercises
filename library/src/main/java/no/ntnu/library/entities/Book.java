package no.ntnu.library.entities;

public class Book {
    private int id;
    private String title;
    private int year;
    private int numberOfPages;

    public Book(int id, String title, int year, int numberOfPages) {
        this.setId(id);
        this.setTitle(title);
        this.setYear(year);
        this.setNumberOfPages(numberOfPages);
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
