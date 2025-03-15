package view;

import view.VOrders;
import view.VInventory;
import view.VCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        setBounds(260, 120, 755, 430);
        dateTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncustomer = new javax.swing.JButton();
        btninventory = new javax.swing.JButton();
        btnorders = new javax.swing.JButton();
        btnreports = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        Ldate = new javax.swing.JLabel();
        Ltime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncustomer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btncustomer.setForeground(new java.awt.Color(237, 51, 5));
        btncustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/customer-service (1).png"))); // NOI18N
        btncustomer.setText("Customers");
        btncustomer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btncustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncustomer.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btncustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncustomerActionPerformed(evt);
            }
        });
        getContentPane().add(btncustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        btninventory.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btninventory.setForeground(new java.awt.Color(237, 51, 5));
        btninventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/inventory (1).png"))); // NOI18N
        btninventory.setText("Inventory");
        btninventory.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btninventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btninventory.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btninventory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btninventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btninventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        btnorders.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnorders.setForeground(new java.awt.Color(237, 51, 5));
        btnorders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/order (1).png"))); // NOI18N
        btnorders.setText("Orders");
        btnorders.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnorders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnorders.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnorders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordersActionPerformed(evt);
            }
        });
        getContentPane().add(btnorders, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        btnreports.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnreports.setForeground(new java.awt.Color(237, 51, 5));
        btnreports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/report (1).png"))); // NOI18N
        btnreports.setText("Reports");
        btnreports.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnreports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnreports.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnreports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportsActionPerformed(evt);
            }
        });
        getContentPane().add(btnreports, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DASHBOARD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        btnlogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(237, 51, 5));
        btnlogout.setText("Log out");
        btnlogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(237, 51, 5), 1, true));
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 20, 90, 35));

        Ldate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Ldate.setForeground(new java.awt.Color(255, 255, 255));
        Ldate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 240, 20));

        Ltime.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        Ltime.setForeground(new java.awt.Color(255, 255, 255));
        Ltime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 240, 40));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eadcw/6.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dateTime() {
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMMM");
        String formattedDate = dateFormat.format(new Date());
        String dd = dateFormat.format(d);
        Ldate.setText(dd);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
                String tt = sdfTime.format(now);
                Ltime.setText(tt);
            }
        });
        timer.start();
    }

    private void btncustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncustomerActionPerformed

        try {
            VCustomer customerForm = new VCustomer();
            customerForm.setVisible(true);
            this.dispose(); // Close the Dashboard
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to open Customer Form: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btncustomerActionPerformed

    private void btninventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventoryActionPerformed
        try {
            VInventory inventoryForm = new VInventory();
            inventoryForm.setVisible(true);
            this.dispose(); // Close the Dashboard
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to open Inventory Form: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btninventoryActionPerformed

    private void btnordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordersActionPerformed
        try {
            VOrders orderForm = new VOrders();
            orderForm.setVisible(true);
            this.dispose(); // Close the Dashboard
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to open Order Form: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnordersActionPerformed

    private void btnreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportsActionPerformed
        try {
            Report reportForm = new Report();
            reportForm.setVisible(true);
            this.dispose(); // Close the Dashboard
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to open Report Form: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnreportsActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed

        int confirmLogout = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmLogout == JOptionPane.YES_OPTION) {
            try {
                Login loginForm = new Login();
                loginForm.setVisible(true);
                this.dispose(); // Close the Dashboard
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to logout: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ldate;
    private javax.swing.JLabel Ltime;
    private javax.swing.JButton btncustomer;
    private javax.swing.JButton btninventory;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnorders;
    private javax.swing.JButton btnreports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
