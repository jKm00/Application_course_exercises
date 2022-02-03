package no.ntnu.library;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCLogic {
    private static Connection connect;
    public String bookTitle;
    public String libraryBranch;

    public JDBCLogic() {
        this.connect();
    }

    public Connection connect() {
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

    public boolean updateBorrowerAddressByID(String newAddress, int id) {
        boolean updated = false;
        PreparedStatement prepared;
        try {
            prepared = connect.prepareStatement("UPDATE Borrower SET address = (?) WHERE borrowerID = (?)");
            prepared.setString(1, newAddress);
            prepared.setString(2, String.valueOf(id));
            prepared.execute();
            updated = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updated;
    }
}
