
package Pharmacy;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Notification extends javax.swing.JFrame {

     Connection conn = null;
     DefaultTableModel dm;
     ResultSet rs;
    
    
    public Notification(){
        initComponents();
        ItemNameAtNotification.setEditable(false);
        try{
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        dm=(DefaultTableModel) GridAtNotification.getModel();
        try
        {
            String SQL;
            SQL = "SELECT * FROM item WHERE Availability < 100";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
                dm.addRow(new Object[]{rs.getString(2),rs.getString(6)});
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        try
        {
            String sql = "SELECT Name FROM Supplier";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                supplierAtNotification.addItem(rs.getString(1));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        GridAtNotification = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ItemNameAtNotification = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        supplierAtNotification = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        QtyAtNotification = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GridAtNotification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GridAtNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GridAtNotificationMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(GridAtNotification);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Item Name : ");

        jLabel2.setText("Supplier : ");

        supplierAtNotification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        supplierAtNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierAtNotificationActionPerformed(evt);
            }
        });

        jLabel3.setText("Quentity : ");

        jButton2.setText("Place Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ItemNameAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplierAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(QtyAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton2)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemNameAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(supplierAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(QtyAtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void GridAtNotificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GridAtNotificationMousePressed
       
        int i=GridAtNotification.getSelectedRow();
        ItemNameAtNotification.setText(dm.getValueAt(i, 0).toString());
    }//GEN-LAST:event_GridAtNotificationMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String sup_name=supplierAtNotification.getSelectedItem().toString();
        String mail = null;
        try
        {
            String SQL;
            SQL = "SELECT EmailAddress FROM supplier WHERE Name like '"+sup_name+"'";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            rs.next();
            mail=rs.getString(1);
            
            
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Email_sender es = new Email_sender();
        es.get_sum(mail,"Our hospital's pharmacy needs "+QtyAtNotification.getText()+" quantity of "+ItemNameAtNotification.getText()+".\n\n\n athlanta_hospital ");
        es.send();
        JOptionPane.showMessageDialog(null, "Your order has been placed via E-mail.");
        ItemNameAtNotification.setText("");
        supplierAtNotification.setSelectedItem("Select");
        QtyAtNotification.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void supplierAtNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierAtNotificationActionPerformed
       
    }//GEN-LAST:event_supplierAtNotificationActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GridAtNotification;
    private javax.swing.JTextField ItemNameAtNotification;
    private javax.swing.JTextField QtyAtNotification;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> supplierAtNotification;
    // End of variables declaration//GEN-END:variables
}
