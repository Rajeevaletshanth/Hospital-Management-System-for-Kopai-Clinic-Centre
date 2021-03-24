/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class pms_pricecontroling extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs,rs1;
    PreparedStatement pst;
    Statement st;
    DefaultTableModel dm;

    public pms_pricecontroling() {
        initComponents();
        try{
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        POSControllerItemName.setEditable(false);
        
        dm=(DefaultTableModel) GreadAtItems.getModel(); 
        
        ItemGride();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        SearchComboBoxAtItem = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        GreadAtItems = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        POSControllerItemName = new javax.swing.JTextField();
        percentageAtPRICECONTROL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SearchComboBoxAtItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchComboBoxAtItemKeyReleased(evt);
            }
        });

        GreadAtItems.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GreadAtItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Type", "Drug Type", "OTC", "Availability", "Selling Price", "Purchase Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreadAtItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GreadAtItemsMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(GreadAtItems);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Search : ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(46, 46, 46)
                        .addComponent(SearchComboBoxAtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchComboBoxAtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Item Name :");

        POSControllerItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POSControllerItemNameActionPerformed(evt);
            }
        });

        percentageAtPRICECONTROL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentageAtPRICECONTROLActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Profit percentage of the item :");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(POSControllerItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(percentageAtPRICECONTROL, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(POSControllerItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentageAtPRICECONTROL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchComboBoxAtItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchComboBoxAtItemKeyReleased
     
        String key = SearchComboBoxAtItem.getText();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
        try{
            String SQL;
            SQL = "SELECT * FROM item WHERE ItemID LIKE '%"+key+"%' OR ItemName LIKE '%"+key+"%' OR Type LIKE '%"+key+"%' OR DrugType LIKE '%"+key+"%' OR OTC LIKE '%"+key+"%'" ;
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
                dm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),Boolean.parseBoolean(rs.getString(4)),rs.getString(6),rs.getString(7),rs.getString(8)});
            }

        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_SearchComboBoxAtItemKeyReleased

    private void GreadAtItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GreadAtItemsMousePressed
        // TODO add your handling code here:

        int i=GreadAtItems.getSelectedRow();
        POSControllerItemName.setText(dm.getValueAt(i, 1).toString());
    }//GEN-LAST:event_GreadAtItemsMousePressed

    private void percentageAtPRICECONTROLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageAtPRICECONTROLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_percentageAtPRICECONTROLActionPerformed

    private void POSControllerItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POSControllerItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_POSControllerItemNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        double percen = Double.parseDouble(percentageAtPRICECONTROL.getText());
        int i=GreadAtItems.getSelectedRow();
        
        double tsel =Double.parseDouble(dm.getValueAt(i, 7).toString());
       
        double selp = tsel+((percen/100.0)*tsel);
        try{
            st = conn.createStatement();
            String SQL = "Update item SET sel_price ='"+selp+"'  WHERE ItemName Like '"+POSControllerItemName.getText()+"'";
            st.executeUpdate(SQL);
            
            ItemGride();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
            
        }
        catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        percentageAtPRICECONTROL.setText("");
        POSControllerItemName.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(pms_pricecontroling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pms_pricecontroling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pms_pricecontroling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pms_pricecontroling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pms_pricecontroling().setVisible(true);
            }
        });
    }

    public void ItemGride()
    {
    while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
        try{
            String SQL;
            SQL = "SELECT * FROM item";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
                dm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),Boolean.parseBoolean(rs.getString(4)),rs.getString(6),rs.getString(7),rs.getString(8)});
            }
            
            
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GreadAtItems;
    private javax.swing.JTextField POSControllerItemName;
    private javax.swing.JTextField SearchComboBoxAtItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField percentageAtPRICECONTROL;
    // End of variables declaration//GEN-END:variables
}
