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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Supplier_management extends javax.swing.JInternalFrame {

    Connection conn = null;
    ResultSet rs,rs1;
    PreparedStatement pst;
    Statement st;
    int CompanyID = 1;
    DefaultTableModel dm;
    
    String CDate="";
    
    boolean isupdate = false;
   
    public Supplier_management() {
        initComponents();
        setMaximizable(true);
        
        
        disableButtons();

        
        try{
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        dm = (DefaultTableModel) TableAtSupplier.getModel();
        
        getSupplier();
        try{
            String SQL;
            SQL = "SELECT MAX(CompanyID) FROM supplier";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
                CompanyID = 1+Integer.parseInt(rs1.getString(1));
                     
            }
        }
        catch(Exception e)
        {
           
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        CDate = dateFormat.format(date);
        DateAtSupplier.setText(CDate);
        DateAtSupplier.setEditable(false);
        
        CompanyIDAtSupplier.setText(String.valueOf(CompanyID));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAtSupplier = new javax.swing.JTable();
        SearchAtSupplier = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        NameAtSupplier = new javax.swing.JTextField();
        ClearSupplierBtnAtSupplier = new javax.swing.JButton();
        ValidationForEmailAtSupplier = new javax.swing.JLabel();
        AddSupplierBtnAtSupplier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DeleteSupplierBtnAtSupplier = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressAtSupplier = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ValidationForNameAtSupplier = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TPNumberAtSupplier = new javax.swing.JTextField();
        ValidationForTPNOAtSupplier = new javax.swing.JLabel();
        ValidationForAddressAtSupplier = new javax.swing.JLabel();
        EmailAddressAtSupplier = new javax.swing.JTextField();
        UpdateSupplierBtnAtSupplier = new javax.swing.JButton();
        CompanyIDAtSupplier = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        DateAtSupplier = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search : ");

        TableAtSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Name", "T.P Number", "Address", "Email Address", "Added Date"
            }
        ));
        TableAtSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableAtSupplierMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TableAtSupplier);

        SearchAtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchAtSupplierKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchAtSupplierKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchAtSupplierKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        NameAtSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameAtSupplierFocusLost(evt);
            }
        });
        NameAtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameAtSupplierKeyReleased(evt);
            }
        });

        ClearSupplierBtnAtSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearSupplierBtnAtSupplier.setText("Clear");
        ClearSupplierBtnAtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearSupplierBtnAtSupplierActionPerformed(evt);
            }
        });

        ValidationForEmailAtSupplier.setText("EX : abcd@xyz.com");

        AddSupplierBtnAtSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddSupplierBtnAtSupplier.setText("Add Supplier");
        AddSupplierBtnAtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSupplierBtnAtSupplierActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Company ID : ");

        DeleteSupplierBtnAtSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteSupplierBtnAtSupplier.setText("Delete Supplier");
        DeleteSupplierBtnAtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSupplierBtnAtSupplierActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Email Address : ");

        AddressAtSupplier.setColumns(20);
        AddressAtSupplier.setRows(5);
        AddressAtSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AddressAtSupplierFocusLost(evt);
            }
        });
        AddressAtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddressAtSupplierKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(AddressAtSupplier);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("T.P Number : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Address : ");

        TPNumberAtSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TPNumberAtSupplierFocusLost(evt);
            }
        });
        TPNumberAtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPNumberAtSupplierKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TPNumberAtSupplierKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TPNumberAtSupplierKeyTyped(evt);
            }
        });

        ValidationForTPNOAtSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValidationForTPNOAtSupplierMouseClicked(evt);
            }
        });

        EmailAddressAtSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailAddressAtSupplierFocusLost(evt);
            }
        });
        EmailAddressAtSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailAddressAtSupplierKeyReleased(evt);
            }
        });

        UpdateSupplierBtnAtSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateSupplierBtnAtSupplier.setText("Update Supplier");
        UpdateSupplierBtnAtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierBtnAtSupplierActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Date : ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(AddSupplierBtnAtSupplier)
                        .addGap(28, 28, 28)
                        .addComponent(UpdateSupplierBtnAtSupplier)
                        .addGap(39, 39, 39)
                        .addComponent(DeleteSupplierBtnAtSupplier)
                        .addGap(38, 38, 38)
                        .addComponent(ClearSupplierBtnAtSupplier))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ValidationForAddressAtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ValidationForNameAtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameAtSupplier)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(CompanyIDAtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ValidationForEmailAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EmailAddressAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ValidationForTPNOAtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TPNumberAtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(DateAtSupplier))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(DateAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CompanyIDAtSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NameAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(ValidationForNameAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TPNumberAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(ValidationForTPNOAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValidationForAddressAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddSupplierBtnAtSupplier)
                            .addComponent(UpdateSupplierBtnAtSupplier)
                            .addComponent(DeleteSupplierBtnAtSupplier)
                            .addComponent(ClearSupplierBtnAtSupplier)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(EmailAddressAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValidationForEmailAtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel32)
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableAtSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAtSupplierMousePressed

        int i=TableAtSupplier.getSelectedRow();
        CompanyIDAtSupplier.setText(dm.getValueAt(i, 0).toString());
        NameAtSupplier.setText(dm.getValueAt(i, 1).toString());
        TPNumberAtSupplier.setText(dm.getValueAt(i, 2).toString());
        AddressAtSupplier.setText(dm.getValueAt(i, 3).toString());
        EmailAddressAtSupplier.setText(dm.getValueAt(i, 4).toString());
        DateAtSupplier.setText(dm.getValueAt(i, 5).toString());
        
        ValidationForEmailAtSupplier.setText("");
        
        isupdate = true;
        enableButtons();
        
    }//GEN-LAST:event_TableAtSupplierMousePressed

    private void SearchAtSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAtSupplierKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SearchAtSupplierKeyPressed

    private void SearchAtSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAtSupplierKeyReleased
       
        String key = SearchAtSupplier.getText();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
        try{
            String SQL;
            SQL = "SELECT * FROM supplier WHERE Name LIKE '%"+key+"%' OR CompanyID LIKE '%"+key+"%' OR TPNumber LIKE '%"+key+"%' OR Address LIKE '%"+key+"%' OR EmailAddress LIKE '%"+key+"%'";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
               
                dm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_SearchAtSupplierKeyReleased

    private void ClearSupplierBtnAtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearSupplierBtnAtSupplierActionPerformed
        
        Clear();
        disableButtons();
    }//GEN-LAST:event_ClearSupplierBtnAtSupplierActionPerformed

    private void AddSupplierBtnAtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSupplierBtnAtSupplierActionPerformed
        // TODO add your handling code here:

        String Name = NameAtSupplier.getText();
        String TPNumber = TPNumberAtSupplier.getText();
        String Address = AddressAtSupplier.getText();
        String EmailAddress = EmailAddressAtSupplier.getText();
        try{
            pst=conn.prepareStatement("Insert into supplier  values(?,?,?,?,?,?)");
            pst.setString(1,String.valueOf(CompanyID));
            pst.setString(2,Name);
            pst.setString(3,TPNumber);
            pst.setString(4,Address);
            pst.setString(5,EmailAddress);
            pst.setString(6,CDate);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inserted Successfully");

            dm.addRow(new Object[]{String.valueOf(CompanyID),Name,TPNumber,Address,EmailAddress,CDate});
            ++CompanyID;
            Clear();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_AddSupplierBtnAtSupplierActionPerformed

    private void DeleteSupplierBtnAtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSupplierBtnAtSupplierActionPerformed
        // TODO add your handling code here:
        String SupploerID = CompanyIDAtSupplier.getText();
        try{
            String sql = "DELETE from supplier where CompanyID LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, SupploerID);
            pst.execute();
            getSupplier();
            JOptionPane.showMessageDialog(null,"Deleted!");
            Clear();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_DeleteSupplierBtnAtSupplierActionPerformed

    private void UpdateSupplierBtnAtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierBtnAtSupplierActionPerformed
        // TODO add your handling code here:
        String SupplierID = CompanyIDAtSupplier.getText();
        String Name = NameAtSupplier.getText();
        String TPNumber = TPNumberAtSupplier.getText();
        String Address = AddressAtSupplier.getText();
        String EmailAddress = EmailAddressAtSupplier.getText();
        try{
            st = conn.createStatement();
            String sql1 = "UPDATE supplier SET Name='"+Name+"',TPNumber='"+TPNumber+"',Address='"+Address+"',EmailAddress='"+EmailAddress+"'  where CompanyID LIKE " + SupplierID + "";
            st.executeUpdate(sql1);//reenter the updated record
            getSupplier();
            JOptionPane.showMessageDialog(null,"Updated successfuly!");
            Clear();
            disableButtons();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_UpdateSupplierBtnAtSupplierActionPerformed

    private void SearchAtSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAtSupplierKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SearchAtSupplierKeyTyped

    private void TPNumberAtSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPNumberAtSupplierKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TPNumberAtSupplierKeyPressed

    private void ValidationForTPNOAtSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValidationForTPNOAtSupplierMouseClicked
        // TODO add your handling code here:
        String no = TPNumberAtSupplier.getText();
        if(no.equals(""))
        {
            
        }
        else if(ValidationForTPNOAtSupplier.getText().equals(""))
        {

        }
        else
        {
            JOptionPane.showMessageDialog(null,"You Entered "+no+"\n And it is a "+no.length()+" digit numbers.\n You have to enter 10 digit number for Local T.P numbers And 13 digit number for foreign T.P.Numbers"
                    + "\n Examble : 0123456789 - Local T.P numbers And \n 0011543245434 - foreign T.P.Numbers!","Invalid entry for T.P Number" , JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ValidationForTPNOAtSupplierMouseClicked

    private void TPNumberAtSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPNumberAtSupplierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TPNumberAtSupplierKeyTyped

    private void TPNumberAtSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TPNumberAtSupplierFocusLost
        // TODO add your handling code here:
          String s = TPNumberAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForTPNOAtSupplier.setText("TP number field can't be empty");
            ValidationForTPNOAtSupplier.setForeground(Color.red);
        }
        else if(s.length() != 10 && s.length()!=13 && isupdate)
        {
            ValidationForTPNOAtSupplier.setText("Invalid number! press here for help.");
            ValidationForTPNOAtSupplier.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isDigit(a))
                {
                    ValidationForTPNOAtSupplier.setText("");
                }
                else
                {
                    ValidationForTPNOAtSupplier.setText("You only can have numbers in TP number field!");
                    ValidationForTPNOAtSupplier.setForeground(Color.red);
                }
            
            }
        }
        
        enableButtons();
    }//GEN-LAST:event_TPNumberAtSupplierFocusLost

    private void TPNumberAtSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPNumberAtSupplierKeyReleased
        // TODO add your handling code here:
        String s = TPNumberAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForTPNOAtSupplier.setText("TP number field can't be empty");
            ValidationForTPNOAtSupplier.setForeground(Color.red);
        }
        else if(s.length() != 10 && s.length()!=13 && isupdate)
        {
            ValidationForTPNOAtSupplier.setText("Invalid number! press here for help.");
            ValidationForTPNOAtSupplier.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isDigit(a))
                {
                    ValidationForTPNOAtSupplier.setText("");
                }
                else
                {
                    ValidationForTPNOAtSupplier.setText("You only can have numbers in TP number field!");
                    ValidationForTPNOAtSupplier.setForeground(Color.red);
                }
            
            }
        }
        
        enableButtons();
    }//GEN-LAST:event_TPNumberAtSupplierKeyReleased

    private void NameAtSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameAtSupplierFocusLost
        // TODO add your handling code here:
        String s = NameAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForNameAtSupplier.setText("Name field can't be empty");
            ValidationForNameAtSupplier.setForeground(Color.red);
        }
        else 
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetter(a))
                {
                    ValidationForNameAtSupplier.setText("");
                }
                else
                {
                   ValidationForNameAtSupplier.setText("You only can have text in the Name field!");
                   ValidationForNameAtSupplier.setForeground(Color.red);
                }
            
            }
        }
       
        
        enableButtons();
    }//GEN-LAST:event_NameAtSupplierFocusLost

    private void NameAtSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameAtSupplierKeyReleased
        // TODO add your handling code here:
        String s = NameAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForNameAtSupplier.setText("Name field can't be empty");
            ValidationForNameAtSupplier.setForeground(Color.red);
        }
        else 
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetter(a))
                {
                    ValidationForNameAtSupplier.setText("");
                }
                else
                {
                   ValidationForNameAtSupplier.setText("You only can have text in the Name field!");
                   ValidationForNameAtSupplier.setForeground(Color.red);
                }
            
            }
        }
        enableButtons();
    }//GEN-LAST:event_NameAtSupplierKeyReleased

    private void AddressAtSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AddressAtSupplierFocusLost
        // TODO add your handling code here:
        String s = AddressAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForAddressAtSupplier.setText("Address field can't be empty");
            ValidationForAddressAtSupplier.setForeground(Color.red);
        }
        else
        {
            ValidationForAddressAtSupplier.setText("");
            
        }
        enableButtons();
        
    }//GEN-LAST:event_AddressAtSupplierFocusLost

    private void AddressAtSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddressAtSupplierKeyReleased
        // TODO add your handling code here:
        String s = AddressAtSupplier.getText();
        if(s.equals(""))
        {
            ValidationForAddressAtSupplier.setText("Name field can't be empty");
            ValidationForAddressAtSupplier.setForeground(Color.red);
        }
        else
        {
            ValidationForAddressAtSupplier.setText("");
            
        }
        enableButtons();
    }//GEN-LAST:event_AddressAtSupplierKeyReleased

    private void EmailAddressAtSupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailAddressAtSupplierKeyReleased
        // TODO add your handling code here:
        String email = EmailAddressAtSupplier.getText();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if(m.matches())
        {
            ValidationForEmailAtSupplier.setText("");
            ValidationForEmailAtSupplier.setForeground(Color.black);
        }
        else
        {
            ValidationForEmailAtSupplier.setText("EX : abcd@xyz.com");
            ValidationForEmailAtSupplier.setForeground(Color.red);
        }
        enableButtons();
        
    }//GEN-LAST:event_EmailAddressAtSupplierKeyReleased

    private void EmailAddressAtSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailAddressAtSupplierFocusLost
        // TODO add your handling code here:
        String email = EmailAddressAtSupplier.getText();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if(!m.matches())
        {
            ValidationForEmailAtSupplier.setForeground(Color.red);
        }
        enableButtons();
    }//GEN-LAST:event_EmailAddressAtSupplierFocusLost

    public void getSupplier()
    {
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
        try{
            String SQL;
            SQL = "SELECT * FROM supplier";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();
            while(rs.next())
            {
                CompanyID = 1+Integer.parseInt(rs.getString(1));
                        //Integer.parseInt(jTextField16.getText());
                dm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void Clear()
    {
        NameAtSupplier.setText("");
        TPNumberAtSupplier.setText("");
        AddressAtSupplier.setText("");
        EmailAddressAtSupplier.setText("");
        CompanyIDAtSupplier.setText(String.valueOf(CompanyID));
        DateAtSupplier.setText(CDate);
        ValidationForEmailAtSupplier.setForeground(Color.BLACK);
        ValidationForEmailAtSupplier.setText("EX : abcd@xyz.com");
        isupdate = false;
        ValidationForTPNOAtSupplier.setText("");
        ValidationForNameAtSupplier.setText("");
        ValidationForAddressAtSupplier.setText("");
    }
    
    public void enableButtons()
    {
        if(ValidationForNameAtSupplier.getText().equals("") && ValidationForTPNOAtSupplier.getText().equals("") && ValidationForEmailAtSupplier.getText().equals("") && ValidationForAddressAtSupplier.getText().equals("") && !NameAtSupplier.getText().equals("") && !TPNumberAtSupplier.getText().equals("") && !AddressAtSupplier.getText().equals("") && !EmailAddressAtSupplier.getText().equals(""))
        {
            AddSupplierBtnAtSupplier.setEnabled(true);
            UpdateSupplierBtnAtSupplier.setEnabled(false);
            DeleteSupplierBtnAtSupplier.setEnabled(false);
            
            if(isupdate)
            {
                AddSupplierBtnAtSupplier.setEnabled(false);
                UpdateSupplierBtnAtSupplier.setEnabled(true);
                DeleteSupplierBtnAtSupplier.setEnabled(true);
            }
        }
        else
        {
            AddSupplierBtnAtSupplier.setEnabled(false);
            UpdateSupplierBtnAtSupplier.setEnabled(false);
            DeleteSupplierBtnAtSupplier.setEnabled(false);
        }
    }
    
    public void disableButtons()
    {
        AddSupplierBtnAtSupplier.setEnabled(false);
        UpdateSupplierBtnAtSupplier.setEnabled(false);
        DeleteSupplierBtnAtSupplier.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSupplierBtnAtSupplier;
    private javax.swing.JTextArea AddressAtSupplier;
    private javax.swing.JButton ClearSupplierBtnAtSupplier;
    private javax.swing.JLabel CompanyIDAtSupplier;
    private javax.swing.JTextField DateAtSupplier;
    private javax.swing.JButton DeleteSupplierBtnAtSupplier;
    private javax.swing.JTextField EmailAddressAtSupplier;
    private javax.swing.JTextField NameAtSupplier;
    private javax.swing.JTextField SearchAtSupplier;
    private javax.swing.JTextField TPNumberAtSupplier;
    private javax.swing.JTable TableAtSupplier;
    private javax.swing.JButton UpdateSupplierBtnAtSupplier;
    private javax.swing.JLabel ValidationForAddressAtSupplier;
    private javax.swing.JLabel ValidationForEmailAtSupplier;
    private javax.swing.JLabel ValidationForNameAtSupplier;
    private javax.swing.JLabel ValidationForTPNOAtSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}