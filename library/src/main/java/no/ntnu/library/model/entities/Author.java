package no.ntnu.library.model.entities;

import io.swagger.annotations.ApiModelProperty;

public class Author {
    @ApiModelProperty(notes = "The unique id of the author")
    private int id;
    @ApiModelProperty(notes ="The first name of the author")
    private String firstName;
    @ApiModelProperty(notes ="The last name of the author")
    private String lastName;
    @ApiModelProperty(notes ="The year the author was born")
    private int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthYear(birthYear);
    }

    /**
     * Checks is the author is valid. Needs an id over 0,
     * firstName and lastName cannot be empty and birthYear
     * has to be over 0.
     * @return {@code true} if author is valid, {@code false} otherwise.
     */
    public boolean isValid() {
        return this.id > 0 && !this.firstName.isEmpty() && !this.lastName.isEmpty() && this.birthYear > 0;
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
