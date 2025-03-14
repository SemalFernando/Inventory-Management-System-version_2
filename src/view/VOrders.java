/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controller.COrders;
import java.awt.Color;
import java.text.SimpleDateFormat;
import model.DBConnection;
import model.MOrders;

/**
 *
 * @author Owner
 */
public class VOrders extends javax.swing.JFrame {

    private COrders controller;

    /**
     * Creates new form Order
     */
    public VOrders() {
        this.controller = new COrders();
        initComponents();
        loadOrderData();
        populateCustomerComboBox();
        cmbCustomer.addActionListener(evt -> {
            String selectedCustomer = (String) cmbCustomer.getSelectedItem();
            if (!"Select Customer".equals(selectedCustomer)) {
                // Handle the selected customer
                System.out.println("Selected Customer ID: " + selectedCustomer);
                // Perform any action or database query related to the customer
            }
        });
        populateProductComboBox();
        cmbProduct.addActionListener(evt -> {
            String selectedProduct = (String) cmbProduct.getSelectedItem();
            if (!"Select Product".equals(selectedProduct)) {
                // Handle the selected product
                System.out.println("Selected Product: " + selectedProduct);
                // Perform any action or database query related to the product
            }
        });
        setBounds(260, 120, 755, 430);
        getContentPane().setBackground(new Color(30, 30, 30));
        orderTable.fixTable(jScrollPane);
        orderTable.setColumnAlignment(0, JLabel.CENTER);
        orderTable.setCellAlignment(0, JLabel.CENTER);
        orderTable.setColumnAlignment(2, JLabel.CENTER);
        orderTable.setCellAlignment(2, JLabel.CENTER);
        orderTable.setColumnAlignment(4, JLabel.RIGHT);
        orderTable.setCellAlignment(4, JLabel.RIGHT);
        orderTable.setColumnWidth(0, 50);
        orderTable.setColumnWidth(2, 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox<>();
        cmbProduct = new javax.swing.JComboBox<>();
        txtSearchID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dtpdate = new org.jdesktop.swingx.JXDatePicker();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        orderTable = new eadcw.TableDark();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        setForeground(new java.awt.Color(255, 102, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ORDER INFORMATION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(237, 64, 7));
        jLabel1.setText("Customer ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(237, 64, 7));
        jLabel4.setText("Product Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(237, 64, 7));
        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        txtQty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 160, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(237, 64, 7));
        jLabel7.setText("Order Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        btnadd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(237, 51, 5));
        btnadd.setText("Add");
        btnadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 80, 30));

        btnupdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(237, 51, 5));
        btnupdate.setText("Update");
        btnupdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 80, 30));

        btndelete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(237, 51, 5));
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 80, 30));

        btnrefresh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(237, 51, 5));
        btnrefresh.setText("Refresh");
        btnrefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 80, 30));

        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCustomer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 20));

        cmbProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        cmbProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductActionPerformed(evt);
            }
        });
        getContentPane().add(cmbProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 160, 20));

        txtSearchID.setBackground(new java.awt.Color(237, 64, 7));
        txtSearchID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearchID.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 64, 7), 1, true));
        txtSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 90, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search by ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        dtpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 64, 7), 1, true));
        dtpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpdateActionPerformed(evt);
            }
        });
        getContentPane().add(dtpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 160, 20));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/back-button (1).png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 580, 170));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer ID", "Product ID", "Quantity", "Total Value", "Order Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(orderTable);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 650, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/6.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 741, 393));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            // Validate fields from the UI
            String customerIDStr = (cmbCustomer.getSelectedItem() != null) ? cmbCustomer.getSelectedItem().toString() : "";
            String productName = (cmbProduct.getSelectedItem() != null) ? cmbProduct.getSelectedItem().toString() : "";
            String quantityStr = txtQty.getText().trim();

            // Retrieve and format the date from JXDatePicker
            java.util.Date selectedDate = dtpdate.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Please select a valid order date.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String orderDate = sdf.format(selectedDate);

            // Validate input fields
            if (customerIDStr.isEmpty() || productName.isEmpty() || quantityStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Parse customer ID and quantity
            int customerID = Integer.parseInt(customerIDStr);
            int quantity = Integer.parseInt(quantityStr);

            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Pass the data to the Controller for order processing
            COrders cord = new COrders();
            cord.addOrder(customerID, productName, quantity, orderDate);

            // Show success message
            JOptionPane.showMessageDialog(this, "Order added successfully!");

            // Clear the fields and refresh the data table
            clearFields();
            loadOrderData();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check your entries.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateCustomerComboBox() {
        cmbCustomer.removeAllItems(); // Clear the combo box before populating
        cmbCustomer.addItem("Select Customer"); // Add a placeholder item

        try {
            Statement st = DBConnection.createDBConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT CustomerID FROM customer");

            while (rs.next()) {
                cmbCustomer.addItem(rs.getString("CustomerID")); // Add customer IDs from the database
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading Customer IDs: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

// Method to populate product name combo box
    private void populateProductComboBox() {
        cmbProduct.removeAllItems(); // Clear the combo box before populating
        cmbProduct.addItem("Select Product"); // Add a placeholder item

        try {
            Statement st = DBConnection.createDBConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT ProductName FROM product");

            while (rs.next()) {
                cmbProduct.addItem(rs.getString("ProductName")); // Add product names from the database
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading Product Names: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

// Method to set the current date in the date picker
    private void setDefaultDate() {
        dtpdate.setDate(new java.util.Date());
    }

// Fetch unit price of a product
    private double fetchUnitPrice(int productID) throws SQLException {
        try (Connection conn = DBConnection.createDBConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT UnitPrice FROM product WHERE ProductID = " + productID;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble("UnitPrice");
            } else {
                throw new SQLException("Product not found!");
            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String id = txtSearchID.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an order ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int orderId = Integer.parseInt(id);

            // Get values from combo boxes and text fields
            String customerID = (String) cmbCustomer.getSelectedItem();
            String productName = (String) cmbProduct.getSelectedItem();
            String quantityStr = txtQty.getText();

            // Retrieve and format the order date
            java.util.Date selectedDate = dtpdate.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Please select a valid date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String orderDate = sdf.format(selectedDate);

            // Validate fields
            if (customerID == null || productName == null || quantityStr.isEmpty() || orderDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Parse quantity
            int quantity = Integer.parseInt(quantityStr);

            // Fetch product ID and unit price using controller
            COrders corder = new COrders();
            int productID = corder.fetchProductID(productName);
            double unitPrice = corder.fetchUnitPrice(productID);

            // Calculate total value
            double totalValue = quantity * unitPrice;

            // Call the update method in the controller
            corder.updateOrder(orderId, Integer.parseInt(customerID), productID, quantity, totalValue, orderDate);

            // Clear fields and refresh
            clearFields();
            txtSearchID.requestFocus();
            loadOrderData();
            btnadd.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Order updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid order ID or quantity", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String id = txtSearchID.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an order ID", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Parse the Order ID
            int orderId = Integer.parseInt(id);

            // Confirm the delete action with the user
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this order?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                // Check if the order exists before deleting
                COrders cOrder = new COrders();
                ResultSet rs = cOrder.searchOrderById(orderId);

                if (rs.next()) {
                    // If the order exists, proceed with deletion
                    cOrder.deleteOrder(orderId);

                    // Clear fields and reload data after successful deletion
                    clearFields();
                    loadOrderData(); // Refresh the table data
                    btnadd.setEnabled(true);

                    JOptionPane.showMessageDialog(this, "Order deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Order not found. Cannot delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            // Handle invalid input (non-integer Order ID)
            JOptionPane.showMessageDialog(this, "Invalid Order ID. Please enter a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Handle SQL exceptions
            JOptionPane.showMessageDialog(this, "Database error while deleting order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        loadOrderData();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void cmbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductActionPerformed

    private void txtSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchIDActionPerformed
        String id = txtSearchID.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Order ID.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int orderId = Integer.parseInt(id);
            COrders cord = new COrders();
            ResultSet rs = cord.searchOrderById(orderId);

            if (rs.next()) {
                // Populate the fields with the retrieved data
                cmbCustomer.setSelectedItem(rs.getString("CustomerID")); // Customer ID
                cmbProduct.setSelectedItem(rs.getString("ProductName")); // Product Name
                txtQty.setText(rs.getString("Quantity")); // Quantity
                dtpdate.setDate(rs.getDate("OrderDate")); // Set date in DatePicker

                // Disable Add button to prevent duplicate addition
                btnadd.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Order not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Order ID. Please enter a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchIDActionPerformed

    private void dtpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtpdateActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Dashboard dbForm = new Dashboard();
        dbForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void loadOrderData() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel(); // Ensure `tblOrders` is your JTable
        model.setRowCount(0); // Clear the table for fresh data

        Statement st = null;
        ResultSet rs = null;

        try {
            st = DBConnection.createDBConnection().createStatement();
            String sql = "SELECT OrderID, CustomerID, ProductID, Quantity, TotalValue, OrderDate FROM orders";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                int customerID = rs.getInt("CustomerID");
                int productID = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double totalValue = rs.getDouble("TotalValue");
                String orderDate = rs.getString("OrderDate");

                // Add a row to the table model
                model.addRow(new Object[]{OrderID, customerID, productID, quantity, totalValue, orderDate});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading orders: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void clearFields() {
        cmbCustomer.setSelectedIndex(0);
        cmbProduct.setSelectedIndex(0);
        txtQty.setText("");
        if (dtpdate != null) {
            dtpdate.setDate(null);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbProduct;
    private org.jdesktop.swingx.JXDatePicker dtpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private eadcw.TableDark orderTable;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearchID;
    // End of variables declaration//GEN-END:variables
}
