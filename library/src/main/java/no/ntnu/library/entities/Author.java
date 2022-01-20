package no.ntnu.library.entities;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthYear(birthYear);
    }

    /**
     * Returns the id of the author
     * @return the id of the author
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the author
     * @param id the id of the author
     */
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be below 0");
        }
        this.id = id;
    }

    /**
     * Returns the first name of the author
     * @return the first name of the author
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the author
     * @param firstName of the author
     */
    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the author
     * @return the last name of the author
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the author
     * @param lastName of the author
     */
    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    /**
     * Returns the year the author was born
     * @return the year the author was born
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Sets the year the author was born
     * @param birthYear the year the author was born
     */
    public void setBirthYear(int birthYear) {
        if (birthYear < 0) {
            throw new IllegalArgumentException("Birth year cannot be below 0");
        }
        this.birthYear = birthYear;
    }
}
