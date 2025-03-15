package model;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MCustomer {

    public void addCustomer(int customerID, String name, String contact, String address, String email) {
        Statement st = null;
        try {
            st = DBConnection.createDBConnection().createStatement();
            String sql = "INSERT INTO Customer (CustomerID, Name, ContactNumber, Address, Email) VALUES ('"
                    + customerID + "', '"
                    + name + "', '"
                    + contact + "', '"
                    + address + "', '"
                    + email + "')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Customer added successfully."); // Indicates the customer was added successfully
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding customer or customer already exists.", "Error", JOptionPane.ERROR_MESSAGE);
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

    public void checkCustomerExists(String customerID) {
        String sql = "SELECT COUNT(*) FROM customer WHERE CustomerID = '" + customerID + "'";
        try (Connection conn = DBConnection.createDBConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    System.out.println("Customer exists in the database.");
                } else {
                    System.out.println("Customer does not exist.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    public void updateCustomer(int customerID, String name, String contact, String address, String email) {
        Statement st = null;
        try {
            st = DBConnection.createDBConnection().createStatement();
            String sql = "UPDATE Customer SET Name='" + name
                    + "', ContactNumber='" + contact
                    + "', Address='" + address
                    + "', Email='" + email
                    + "' WHERE CustomerID=" + customerID;
            int i = st.executeUpdate(sql);

            if (i == 1) {
                System.out.println("Customer updated successfully!");
            } else {
                System.out.println("Error updating customer or customer not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
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

    public void deleteCustomer(int customerID) {
        Statement st = null;
        try {
            st = DBConnection.createDBConnection().createStatement();
            String sql = "DELETE FROM Customer WHERE CustomerID='" + customerID + "'";
            int i = st.executeUpdate(sql);

            /*if (i == 1) {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting customer or customer not found.");
            }*/
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public void loadCustomer(DefaultTableModel model) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = DBConnection.createDBConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM Customer");

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
            JOptionPane.showMessageDialog(null, "Error loading customer data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public ResultSet searchCustomerById(int customerId) throws SQLException {
        Statement st = DBConnection.createDBConnection().createStatement();
        return st.executeQuery("SELECT * FROM customer WHERE CustomerID = " + customerId);
    }
}
