package controller;

import model.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class COrders {

    MOrders model = new MOrders();

    public void addOrder(int customerID, String productName, int quantity, String orderDate) throws SQLException {
        try {
            // Fetch the product ID and unit price
            int productID = model.fetchProductID(productName);
            double unitPrice = model.fetchUnitPrice(productID);

            if (unitPrice <= 0) {
                throw new SQLException("Invalid unit price for product: " + productName);
            }

            // Calculate total value
            double totalValue = unitPrice * quantity;

            // Pass the data to the model for insertion
            model.addOrder(customerID, productID, quantity, totalValue, orderDate);
        } catch (SQLException ex) {
            throw new SQLException("Failed to add order: " + ex.getMessage());
        }
    }

    // Method to update an order
    public void updateOrder(int orderID, int customerID, int productID, int quantity, double totalValue, String orderDate) {
        if (orderID <= 0 || customerID <= 0 || productID <= 0 || quantity <= 0 || orderDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input. Ensure all fields are filled and IDs are valid.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pass data to the model for updating the order
        MOrders morder = new MOrders();
        morder.updateOrder(orderID, customerID, productID, quantity, totalValue, orderDate);
    }

    // Method to delete an order
    public void deleteOrder(int orderID) {
        if (orderID <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid Order ID. Please check your input.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MOrders morder = new MOrders();
        morder.deleteOrder(orderID);
    }

    // Method to load orders into the table
    public void loadOrders(DefaultTableModel model) {
        MOrders morder = new MOrders();
        morder.loadOrders(model);
    }

    public ResultSet searchOrderById(int orderID) throws SQLException {
        MOrders morder = new MOrders();
        return morder.searchOrderById(orderID);
    }

    public int fetchProductID(String productName) throws SQLException {
        return model.fetchProductID(productName);
    }

    public double fetchUnitPrice(int productID) throws SQLException {
        return model.fetchUnitPrice(productID);
    }

}
