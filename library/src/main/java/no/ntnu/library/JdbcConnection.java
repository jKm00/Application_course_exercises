package no.ntnu.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for communication with SQL database.
 * This class makes use of the singleton pattern. To get an
 * instance simple call the static method "getInstance()"
 */
@Component
public class JdbcConnection {
    @Value("${db.name}")
    private String dbName; // Currently doesn't get imported

    private Connection connection;

    /**
     * Singleton patter
     */
    private JdbcConnection() {
    }

    private static JdbcConnection instance;

    /**
     * Get a singleton instance of the class. Use this method to get access to the connetion.
     *
     * @return Singleton instance
     */
    public static JdbcConnection getInstance() {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }

    /**
     * Establish connection to the database
     *
     * @throws Exception Throws exception when connection not successful
     */
    public boolean connect() {
        if (connection == null) {
            try {
                this.connection = DriverManager.getConnection("jdbc:sqlite:libraryDB.db");
            } catch (SQLException e) {
                connection = null;
            }
        }
        return connection != null;
    }

    /**
     * Check if connection to database is established
     * @return {@code true} when connection is established, {@code false} otherwise
     */
    public boolean isConnected() {
        return connection != null;
    }

    public boolean tryConnect() {
        return connect();
    }

    /**
     * Execute an UPDATE for the database - update title for a book
     * @param bookId ID of the book to be updated
     * @param title The new title to set for the book
     * @throws Exception on error
     */
    public void updateBookTitle(int bookId, String title) throws Exception {
        String[] parameters = new String[]{title, "" + bookId};
        executeUpdateStatement("UPDATE books SET title = ? WHERE bookID = ?", parameters);
    }

    /**
     * Gets the name of borrowers who borrowed a book with the given title
     * @param bookTitle The book title of interest
     * @return List of all the borrower names
     * @throws SQLException Exception on error
     */
    public List<String> getBorrowerNames(String bookTitle) throws SQLException {
        String query = "SELECT bb.firstName\n" +
                "FROM books b\n" +
                "INNER JOIN lentBooks l ON b.bookID = l.bookID\n" +
                "INNER JOIN borrowers bb ON l.borrowerID = bb.borrowerID\n" +
                "WHERE b.title = ?";
        return executeStringListSelectQuery(query, new String[]{bookTitle});
    }

    /**
     * Execute a query which returns a list of strings (a single-column table)
     * @param query The SQL query
     * @param values Values to replace the ? placeholders
     * @return List of strings, returned as rows from SQL
     * @throws SQLException Exception on error
     */
    public List<String>  executeStringListSelectQuery(String query, String[] values) throws SQLException {
        PreparedStatement stmt = prepareStatement(query, values);
        ResultSet rs = stmt.executeQuery();
        List<String> responseStrings = new ArrayList<>();
        while (rs.next()) {
            responseStrings.add(rs.getString(1));
        }
        return responseStrings;
    }

    /**
     * Execute an SQL statement which updates the state of the database
     * @param query SQL query, with ? in places of arguments (E.g. SELECT * FROM books WHERE bookID = ?)
     * @param values List of values to replace the ? placeholders in the query
     */
    private void executeUpdateStatement(String query, String[] values) throws Exception {
        if (!isConnected()) throw new Exception("No connection to the database");
        PreparedStatement stmt = prepareStatement(query, values);
        stmt.executeUpdate();
    }

    /**
     * Prepare a statement for a given query and arguments
     * @param query SQL query
     * @param args Values to replace the "?" placeholder
     * @return PreparedStatement
     * @throws SQLException Exception on error
     */
    private PreparedStatement prepareStatement(String query, String[] args) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i = 0; i < args.length; i++) {
            stmt.setString(i + 1, args[i]);
        }
        return stmt;
    }

    public String getBookTitle(Integer id) throws Exception {
        String query = "SELECT title FROM books WHERE bookID = ?";
        String[] parameters = new String[]{"" + id};
        return executeStringSelectQuery(query, parameters);
    }

    private String executeStringSelectQuery(String query, String[] values) throws SQLException {
        PreparedStatement stmt = prepareStatement(query, values);
        ResultSet rs = stmt.executeQuery();
        return rs.getString(1);
    }
}
