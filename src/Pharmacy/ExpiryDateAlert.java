/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ExpiryDateAlert extends javax.swing.JFrame {

  
    Connection conn = null;
    ResultSet rs1;
    PreparedStatement pst;
    Statement st;
    DefaultTableModel dmt;
    
    
    
    public ExpiryDateAlert() {
        initComponents();
         dmt = (DefaultTableModel) TableAtExpiry.getModel();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
           
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       
        
         try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, +3);
            Date date = cal.getTime();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String expDate = formatter.format(date);
            
            String SQL;
            SQL = "SELECT itemName,expDate,availability FROM stock WHERE expDate < '"+expDate+"' AND availability > 0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            while(rs1.next())
            {

             dmt.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3)});

            }
           
            
            
          
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
         
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAtExpiry = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableAtExpiry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Expiry Date", "Availability"
            }
        ));
        jScrollPane1.setViewportView(TableAtExpiry);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Dump");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Back");
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        int r = TableAtExpiry.getSelectedRow();
        String itemAtExp =  dmt.getValueAt(r,0).toString();
        String expAtEapAlert =  dmt.getValueAt(r,1).toString();
        String availabiblityAtExp =  dmt.getValueAt(r,2).toString();
        try{
            st = conn.createStatement();
            String sql1 = "UPDATE stock SET availability='0'  where expDate = '" + expAtEapAlert + "' and availability LIKE  '"+availabiblityAtExp+"' AND itemName like '"+itemAtExp+"'";
            st.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"Dumped successfuly!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        int availability_In_Item=0;
        try{
            String SQL;
            SQL = "SELECT Availability FROM item";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            availability_In_Item=rs1.getInt(1)-Integer.parseInt(availabiblityAtExp);
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            st = conn.createStatement();
            String sql1 = "UPDATE item SET availability='"+availability_In_Item+"'  where ItemName LIKE '" + itemAtExp + "'";
            st.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null,"Dumped successfuly!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        
        
           while(dmt.getRowCount() > 0)
        {
            dmt.removeRow(0);
        }
        
          try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, +3);
            Date date = cal.getTime();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String expDate = formatter.format(date);
            
            String SQL;
            SQL = "SELECT itemName,expDate,availability FROM stock WHERE expDate < '"+expDate+"' AND availability > 0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            while(rs1.next())
            {

             dmt.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3)});

            }
           
            
            
          
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpiryDateAlert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAtExpiry;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
