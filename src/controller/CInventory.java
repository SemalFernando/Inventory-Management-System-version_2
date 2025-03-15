package controller;

import model.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CInventory {

    public void addProduct(int productID, String productName, double unitPrice) {
        MInventory minv = new MInventory();
        minv.addProduct(productID, productName, unitPrice);
    }

    public void updateProduct(int productID, String productName, double unitPrice) {
        if (productID <= 0 || productName.isEmpty() || unitPrice <= 0) {
            System.out.println("Invalid input. Ensure all fields are filled and product ID is valid.");
            return;
        }

        MInventory minv = new MInventory();
        minv.updateProduct(productID, productName, unitPrice);
    }

    public void deleteProduct(int productID) {
        MInventory minv = new MInventory();
        minv.deleteProduct(productID);
    }

    public void loadProducts(DefaultTableModel model) {
        MInventory minv = new MInventory();
        minv.loadProducts(model);
    }

    public ResultSet searchProductById(int productID) throws SQLException {
        MInventory minv = new MInventory();
        return minv.searchProductById(productID);
    }

    public void checkProductExists(String productID) {
        if (productID == null || productID.isEmpty()) {
            System.out.println("Invalid Product ID. Cannot check existence.");
            return;
        }
        MInventory minv = new MInventory();
        minv.checkProductExists(productID);
    }

}
