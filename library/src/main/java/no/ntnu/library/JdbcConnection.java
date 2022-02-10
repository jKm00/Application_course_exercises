package no.ntnu.library;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class responsible for communication with SQL database.
 * This class makes use of the singleton pattern. To get an
 * instance simple call the static method "getInstance()"
 */
public class JdbcConnection {
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
     * Connects to the database
     * @param databaseUrl the url to the database
     * @throws Exception Throws exception when connection not successful
     */
    public void connect(URL databaseUrl) throws Exception {
        if (databaseUrl == null) {
            throw new IllegalArgumentException("Invalid URL");
        }
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + String.valueOf(databaseUrl));
    }

    /**
     * Check if connection to database is established
     * @return {@code true} when connection is established, {@code false} otherwise
     */
    public boolean isConnected() {
        return connection != null;
    }

}
