package no.ntnu.library;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCLogic {
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // Get URL to database file
            URL databaseUrl = JDBCLogic.class.getClassLoader().getResource("libraryDB.db");
            // Make sure databaseUrl points to a file
            assert databaseUrl != null;
            // Connect to database
            con = DriverManager.getConnection("jdbc:sqlite:" + String.valueOf(databaseUrl)); // Connect to database
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return con;
    }
}
