package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MOrders {

    // Method to add an order
    public void addOrder(int customerID, int productID, int quantity, double totalValue, String orderDate) {
        Statement st = null;
        try {
            // Prepare the SQL query
            String sql = "INSERT INTO orders (CustomerID, ProductID, Quantity, TotalValue, OrderDate) VALUES (?, ?, ?, ?, ?)";

            // Use PreparedStatement for safer SQL queries
            PreparedStatement ps = DBConnection.createDBConnection().prepareStatement(sql);
            ps.setInt(1, customerID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.setDouble(4, totalValue);

            // Convert the orderDate string to SQL Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(orderDate);
            ps.setDate(5, new java.sql.Date(parsedDate.getTime()));

            // Execute the query
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order added successfully.");
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public int fetchProductID(String productName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int productID = -1; // Default to -1 to indicate "not found"
        try {
            // Use PreparedStatement to prevent SQL injection
            String sql = "SELECT ProductID FROM product WHERE ProductName = ?";
            ps = DBConnection.createDBConnection().prepareStatement(sql);
            ps.setString(1, productName);

            // Execute the query
            rs = ps.executeQuery();
            if (rs.next()) {
                productID = rs.getInt("ProductID");
            }
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return productID;
    }

    public double fetchUnitPrice(int productID) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        double unitPrice = 0.0; // Default to 0.0 to indicate "not found"
        try {
            // Use PreparedStatement to prevent SQL injection
            String sql = "SELECT UnitPrice FROM product WHERE ProductID = ?";
            ps = DBConnection.createDBConnection().prepareStatement(sql);
            ps.setInt(1, productID);

            // Execute the query
            rs = ps.executeQuery();
            if (rs.next()) {
                unitPrice = rs.getDouble("UnitPrice");
            }
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return unitPrice;
    }

    // Method to update an existing order
    public void updateOrder(int orderID, int customerID, int productID, int quantity, double totalValue, String orderDate) {
        PreparedStatement ps = null;
        try {
            // Prepare the SQL query
            String sql = "UPDATE orders SET CustomerID = ?, ProductID = ?, Quantity = ?, TotalValue = ?, OrderDate = ? WHERE OrderID = ?";
            ps = DBConnection.createDBConnection().prepareStatement(sql);

            // Set parameters
            ps.setInt(1, customerID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.setDouble(4, totalValue);

            // Convert the order date to java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(orderDate);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            ps.setDate(5, sqlDate);

            ps.setInt(6, orderID);

            // Execute the update query
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 1) {
                JOptionPane.showMessageDialog(null, "Order updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Order not found or no changes made.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | java.text.ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Method to delete an order
    public void deleteOrder(int orderID) {
        Statement st = null;
        try {
            // Establish a database connection and prepare the DELETE query
            st = DBConnection.createDBConnection().createStatement();
            String sql = "DELETE FROM orders WHERE OrderID = " + orderID;

            // Execute the query and check if an order was deleted
            int rowsAffected = st.executeUpdate(sql);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Order deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Order not found. Deletion failed.");
            }
        } catch (SQLException ex) {
            // Handle any SQL-related exceptions
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error while deleting order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the Statement object
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Method to load orders into the table
    public void loadOrders(DefaultTableModel model) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = DBConnection.createDBConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM orders");

            ResultSetMetaData rsd = rs.getMetaData();
            int columnCount = rsd.getColumnCount();

            model.setRowCount(0); // Clear existing rows in the table model

            while (rs.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i)); // Fetch each column's data
                }
                model.addRow(row); // Add the row to the table model
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading order data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) {
                try {
                    rs.close(); // Close ResultSet
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close(); // Close Statement
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public ResultSet searchOrderById(int orderID) throws SQLException {
        String query = "SELECT o.OrderID, o.CustomerID, p.ProductName, o.Quantity, o.OrderDate "
                + "FROM orders o INNER JOIN product p ON o.ProductID = p.ProductID WHERE o.OrderID = ?";
        PreparedStatement ps = DBConnection.createDBConnection().prepareStatement(query);
        ps.setInt(1, orderID);
        return ps.executeQuery();
    }

}
