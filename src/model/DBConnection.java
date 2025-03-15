package model;
import java.sql.*;

public class DBConnection {
    private static Connection con;

    public static Connection createDBConnection() {
        try {
            String url = "jdbc:mysql://localhost/inventory_management";
            con = DriverManager.getConnection(url, "root", "Semali33g8hby");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}