package controller;

import model.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCustomer {

    public void addCustomer(int customerID, String name, String contact, String address, String email) {
        MCustomer mcus = new MCustomer();
        mcus.addCustomer(customerID, name, contact, address, email);
    }

    public void updateCustomer(int customerID, String name, String contact, String address, String email) {
        if (customerID <= 0 || name.isEmpty() || contact.isEmpty() || address.isEmpty() || email.isEmpty()) {
            System.out.println("Invalid input. Ensure all fields are filled and customer ID is valid.");
            return;
        }

        MCustomer mcus = new MCustomer();
        mcus.updateCustomer(customerID, name, contact, address, email);
    }

    public void deleteCustomer(int customerID) {
        MCustomer mcus = new MCustomer();
        mcus.deleteCustomer(customerID);
    }

    public void loadCustomer(DefaultTableModel model) {
        MCustomer mcus = new MCustomer();
        mcus.loadCustomer(model);
    }

    public ResultSet searchCustomerById(int customerID) throws SQLException {
        MCustomer mcus = new MCustomer();
        return mcus.searchCustomerById(customerID);
    }

    public void checkCustomerExists(String customerID) {
        if (customerID == null || customerID.isEmpty()) {
            System.out.println("Invalid Customer ID. Cannot check existence.");
            return;
        }
        MCustomer mcus = new MCustomer();
        mcus.checkCustomerExists(customerID);
    }

}
