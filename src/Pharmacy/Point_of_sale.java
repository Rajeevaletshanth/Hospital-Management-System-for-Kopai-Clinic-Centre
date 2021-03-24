
package Pharmacy;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class Point_of_sale extends javax.swing.JInternalFrame {
    int InvoiceID = 1;
    Connection conn = null;
    ResultSet rs1;
    PreparedStatement pst;
    Statement st;
    int no=1;
    double pricePerUnit=0;
    DefaultTableModel dmt2;
    
    double total=0;
   
    
    boolean otcdoctor=true;
   
  

   
    public Point_of_sale() {
        initComponents();
        setMaximizable(true);
        AddbtnAtPOS.setEnabled(false);
        ItemAvailabilityAtPOS.setEditable(false);
        TotalAtPos.setEditable(false);
        sel_priceAtPOS.setEditable(false);
        
        
        
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
        
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
  
        try{
            int count=0;
            String SQL;
            SQL = "SELECT COUNT(*) FROM item WHERE Availability < 100";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            count=rs1.getInt(1);
            
            if(count>0)
            {
                
            NotificationAtMain.setText("Low Stock "+count+" Items");
            NotificationAtMain.setForeground(Color.red);
            
            }
            
            
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    
        try{
            int count=0;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, +3);
            Date date = cal.getTime();

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String expDate = formatter.format(date);
            
            String SQL;
            SQL = "SELECT COUNT(*) FROM stock WHERE expDate < '"+expDate+"' AND availability > 0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            count=rs1.getInt(1);
            
            if(count>0)
            {
                ExpiryDateAlert.setText(count+" Items are going to expire within 3 months");
                ExpiryDateAlert.setForeground(Color.red);
            }
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
         patIDatPOS.setEnabled(false);
         

        try{
            String SQL;
            SQL = "SELECT MAX(InvoiceID) FROM pos";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            while(rs1.next())
            {
                InvoiceID = 1+Integer.parseInt(rs1.getString(1));
                        
            }
        }
        catch(Exception e)
        {
           
        }
        invoiceIDAtpos.setText(String.valueOf(InvoiceID));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        RadiodtwAtPOS = new javax.swing.JCheckBox();
        TextAtItemPOS = new javax.swing.JTextField();
        BalanceAtPos = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        serialNoAtPOS = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        qtyAtPOS = new javax.swing.JTextField();
        itemidAtPOS = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableAtPOS = new javax.swing.JTable();
        AmountAtPos = new javax.swing.JTextField();
        AddbtnAtPOS = new javax.swing.JButton();
        TotalAtPos = new javax.swing.JTextField();
        patIDatPOS = new javax.swing.JTextField();
        posdistributedwardlb = new javax.swing.JLabel();
        invoiceIDAtpos = new javax.swing.JLabel();
        validationforQTYAtPOS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ItemAvailabilityAtPOS = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        sel_priceAtPOS = new javax.swing.JTextField();
        NotificationAtMain = new javax.swing.JLabel();
        ExpiryDateAlert = new javax.swing.JLabel();

        RadiodtwAtPOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RadiodtwAtPOS.setText("Distributed to ward");
        RadiodtwAtPOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadiodtwAtPOSMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RadiodtwAtPOSMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                RadiodtwAtPOSMouseReleased(evt);
            }
        });
        RadiodtwAtPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadiodtwAtPOSActionPerformed(evt);
            }
        });

        TextAtItemPOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextAtItemPOSKeyReleased(evt);
            }
        });

        BalanceAtPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BalanceAtPosKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Invoice ID : ");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setText("Remove Entry");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        serialNoAtPOS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                serialNoAtPOSFocusLost(evt);
            }
        });
        serialNoAtPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialNoAtPOSActionPerformed(evt);
            }
        });
        serialNoAtPOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serialNoAtPOSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                serialNoAtPOSKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Item ID :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Amount Received : ");

        qtyAtPOS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtyAtPOSFocusLost(evt);
            }
        });
        qtyAtPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyAtPOSActionPerformed(evt);
            }
        });
        qtyAtPOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyAtPOSKeyReleased(evt);
            }
        });

        itemidAtPOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemidAtPOSKeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Balance : ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Quantity : ");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Total : ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Serial No: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Item Name : ");

        tableAtPOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Item Name", "Quantity", "Price Per Unit", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableAtPOS);

        AmountAtPos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AmountAtPosMouseClicked(evt);
            }
        });
        AmountAtPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmountAtPosKeyReleased(evt);
            }
        });

        AddbtnAtPOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddbtnAtPOS.setText("Add");
        AddbtnAtPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnAtPOSActionPerformed(evt);
            }
        });

        patIDatPOS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                patIDatPOSFocusLost(evt);
            }
        });
        patIDatPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patIDatPOSActionPerformed(evt);
            }
        });

        posdistributedwardlb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        posdistributedwardlb.setText("Enter Patient ID :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Item Availability : ");

        ItemAvailabilityAtPOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Selling Price :");

        sel_priceAtPOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sel_priceAtPOSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceIDAtpos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(serialNoAtPOS))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(validationforQTYAtPOS, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(qtyAtPOS, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(AddbtnAtPOS)))))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(itemidAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemAvailabilityAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextAtItemPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sel_priceAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(posdistributedwardlb, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patIDatPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RadiodtwAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AmountAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BalanceAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(invoiceIDAtpos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(serialNoAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(itemidAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(TextAtItemPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadiodtwAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(sel_priceAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(qtyAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patIDatPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(posdistributedwardlb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(ItemAvailabilityAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationforQTYAtPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddbtnAtPOS)
                .addGap(26, 26, 26)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(TotalAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(BalanceAtPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        NotificationAtMain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NotificationAtMain.setForeground(new java.awt.Color(255, 0, 0));
        NotificationAtMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotificationAtMainMouseClicked(evt);
            }
        });

        ExpiryDateAlert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ExpiryDateAlert.setForeground(new java.awt.Color(255, 0, 0));
        ExpiryDateAlert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpiryDateAlertMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                        .addComponent(ExpiryDateAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NotificationAtMain, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NotificationAtMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExpiryDateAlert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serialNoAtPOSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serialNoAtPOSFocusLost
        
         
       POSbtncontroller();
       
        
          
    }//GEN-LAST:event_serialNoAtPOSFocusLost

    private void serialNoAtPOSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serialNoAtPOSKeyReleased
        Integer posseqno =Integer.parseInt(serialNoAtPOS.getText());
        
      
         try
         {
            String SQL;
            SQL = "SELECT itemName FROM stock WHERE serialNo ='"+posseqno+"'";
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            String sqlItemName;
            sqlItemName = rs1.getString(1);
           TextAtItemPOS.setText(sqlItemName);
        } 
        catch (SQLException ex) 
        {
             TextAtItemPOS.setText("");
             itemidAtPOS.setText("");
             ItemAvailabilityAtPOS.setText("");
             qtyAtPOS.setText("");
             pricePerUnit=0;
            
        }
              
       
        String positemname = TextAtItemPOS.getText();
        
      
        try{
            String SQL;
            SQL = "SELECT ItemID,Availability,sel_price FROM item WHERE ItemName like '"+positemname+"'";
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            String positemid;
            positemid = rs1.getString(1);
            ItemAvailabilityAtPOS.setText(rs1.getString(2));
            itemidAtPOS.setText(positemid);
            pricePerUnit=rs1.getDouble(3);
            sel_priceAtPOS.setText(String.valueOf(pricePerUnit));
        } 
        catch (SQLException ex) {
             TextAtItemPOS.setText("");
             itemidAtPOS.setText("");
             ItemAvailabilityAtPOS.setText("");
             qtyAtPOS.setText("");
             pricePerUnit=0;
            Logger.getLogger(Point_of_sale.class.getName()).log(Level.SEVERE, null, ex);
            itemidAtPOS.setText("");
            sel_priceAtPOS.setText("");
          
        }
    }//GEN-LAST:event_serialNoAtPOSKeyReleased

    private void AddbtnAtPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnAtPOSActionPerformed
       
        if(!patIDatPOS.getText().equals(""))
        {
         
        }
        dmt2=(DefaultTableModel) tableAtPOS.getModel();
        Integer positemid = Integer.parseInt(itemidAtPOS.getText());
        String positemname= TextAtItemPOS.getText();
        Integer posqty = Integer.parseInt(qtyAtPOS.getText());
        String pospid = patIDatPOS.getText();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());//get todays date
        boolean dtw;
        
       
        if (RadiodtwAtPOS.isSelected())
       {

           dtw= true;  
      
       }
       else
       {

           dtw = false;
       }
   
       double subTotal=pricePerUnit*posqty;
        
         
       
       total= total+subTotal;
       TotalAtPos.setText(String.valueOf(total));
        try{
            pst=conn.prepareStatement("Insert into pos values(?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1,InvoiceID);
            pst.setInt(2,no);
            pst.setInt(3,positemid);
            pst.setString(4,positemname);
            pst.setInt(5,posqty);
            pst.setDouble(6,pricePerUnit);
            pst.setDouble(7,subTotal);
            pst.setString(8,String.valueOf(dtw));
            pst.setString(9,pospid);
            pst.setString(10,date);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inserted Successfully");

            dmt2.addRow(new Object[]{String.valueOf(no),positemname,posqty,String.valueOf(pricePerUnit),String.valueOf(subTotal)});
            
            ++no;
       
          ClearPOS();
          POSbtncontroller();


          
        }
        catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        int availability=0;
        String otc="";
        try{
            String SQL;
            SQL = "SELECT availability,OTC FROM item WHERE ItemName LIKE '" + positemname + "'";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1= pst.executeQuery();
            rs1.next();
            
            availability= Integer.parseInt(rs1.getString(1))-posqty;
            otc=rs1.getString(2);
                        
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        if(otc.equals("false") && otcdoctor)
        {
            DoctorDetails d = new DoctorDetails(InvoiceID);
            d.setVisible(true);
            otcdoctor=false;
        }
        
        try{
            st = conn.createStatement();
            String sql1 = "UPDATE item SET availability='"+availability+"'  where ItemName LIKE '" + positemname + "'";
            st.executeUpdate(sql1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
       
        
        int row=0;
        try{
            String SQL;
            SQL = "SELECT COUNT(*) FROM stock WHERE ItemName LIKE '" + positemname + "' AND availability >0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1= pst.executeQuery();
            rs1.next();
            row=rs1.getInt(1);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        String ava[][]= new String[3][row];
        try{
            String SQL;
            SQL = "SELECT InvoiceNo,seqNostock,availability FROM stock WHERE ItemName LIKE '" + positemname + "' AND availability >0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1= pst.executeQuery();
            int i=0;
            while(rs1.next())
            {
                ava[0][i]=rs1.getString(1);
                ava[1][i]=rs1.getString(2);
                ava[2][i]=rs1.getString(3);
                
                i++;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        int i=0;
        while(posqty>0)
        {
                
            posqty=posqty-Integer.parseInt(ava[2][i]);
            if(posqty>=0)
            {
                try{
                    st = conn.createStatement();
                    String sql1 = "UPDATE stock SET availability='0'  where ItemName LIKE '" + positemname + "' AND InvoiceNo LIKE '"+ava[0][i]+"' AND seqNostock LIKE '"+ava[1][i]+"'";
                    st.executeUpdate(sql1);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            else
            {
                int aval=posqty*-1;
                try{
                    st = conn.createStatement();
                    String sql1 = "UPDATE stock SET availability='"+aval+"'  where ItemName LIKE '" + positemname + "' AND InvoiceNo LIKE '"+ava[0][i]+"' AND seqNostock LIKE '"+ava[1][i]+"'";
                    st.executeUpdate(sql1);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            i++;
                
        }

        try{
            int count=0;
            String SQL;
            SQL = "SELECT COUNT(*) FROM item WHERE Availability < 100";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            count=rs1.getInt(1);
            
            if(count>0)
            {
                
            NotificationAtMain.setText("Low Stock "+count+" Items");
            NotificationAtMain.setForeground(Color.red);
            
            }
            
            
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        try{
            int count=0;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, +3);
            Date dat = cal.getTime();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String expDate = formatter.format(dat);
            
            String SQL;
            SQL = "SELECT COUNT(*) FROM stock WHERE expDate < '"+expDate+"' AND availability > 0";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            count=rs1.getInt(1);
            
            if(count>0)
            {
                ExpiryDateAlert.setText(count+" Items are going to expire within 3 months");
                ExpiryDateAlert.setForeground(Color.red);
            }
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       
        
        
    }//GEN-LAST:event_AddbtnAtPOSActionPerformed
    
    private void RadiodtwAtPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadiodtwAtPOSActionPerformed
        
        BalanceAtPos.setText("0");
        BalanceAtPos.setEnabled(false);
        AmountAtPos.setText("0");
        AmountAtPos.setEnabled(false);
        
    }//GEN-LAST:event_RadiodtwAtPOSActionPerformed

    private void patIDatPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patIDatPOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patIDatPOSActionPerformed

    private void RadiodtwAtPOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadiodtwAtPOSMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RadiodtwAtPOSMouseClicked

    private void RadiodtwAtPOSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadiodtwAtPOSMousePressed
// TODO add your handling code here:
    }//GEN-LAST:event_RadiodtwAtPOSMousePressed

    private void serialNoAtPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialNoAtPOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serialNoAtPOSActionPerformed

    private void serialNoAtPOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serialNoAtPOSKeyTyped

    }//GEN-LAST:event_serialNoAtPOSKeyTyped

    private void itemidAtPOSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemidAtPOSKeyReleased
        String pos_itemid=itemidAtPOS.getText();
         try
         {
            String SQL;
            SQL = "SELECT itemName,Availability,sel_price FROM item WHERE ItemID ='"+pos_itemid+"'";
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            TextAtItemPOS.setText(rs1.getString(1));
            ItemAvailabilityAtPOS.setText(rs1.getString(2));
            pricePerUnit=rs1.getDouble(3);
            sel_priceAtPOS.setText(String.valueOf(pricePerUnit));
        } 
       catch (SQLException ex) 
        {
             TextAtItemPOS.setText("");
             serialNoAtPOS.setText("");
             ItemAvailabilityAtPOS.setText("");
             qtyAtPOS.setText("");
             sel_priceAtPOS.setText("");
             pricePerUnit=0;
             
        }
    }//GEN-LAST:event_itemidAtPOSKeyReleased

    private void TextAtItemPOSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAtItemPOSKeyReleased
           
        String positemname = TextAtItemPOS.getText();
         try
         {
            String SQL;
            SQL = "SELECT ItemID,Availability,sel_price FROM item WHERE itemName ='"+positemname+"'";
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            rs1.next();
            itemidAtPOS.setText(rs1.getString(1));
            ItemAvailabilityAtPOS.setText(rs1.getString(2));
            pricePerUnit=rs1.getDouble(3);
            sel_priceAtPOS.setText(String.valueOf(pricePerUnit));
        } 
       catch (SQLException ex) 
        { 
             serialNoAtPOS.setText("");
             itemidAtPOS.setText("");
             ItemAvailabilityAtPOS.setText("");
             qtyAtPOS.setText("");
             sel_priceAtPOS.setText("");
             pricePerUnit=0;
             
        }
    
    }//GEN-LAST:event_TextAtItemPOSKeyReleased

    private void RadiodtwAtPOSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadiodtwAtPOSMouseReleased
        
        if(RadiodtwAtPOS.isSelected())
        {
            patIDatPOS.setEnabled(true);
        }
        else
        {
            patIDatPOS.setEnabled(false);
        }
    }//GEN-LAST:event_RadiodtwAtPOSMouseReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
         
        int i =tableAtPOS.getSelectedRow();
        String seqno = dmt2.getValueAt(i,0).toString();
        double subtot=Double.parseDouble(dmt2.getValueAt(i,4).toString());
        String item_name = dmt2.getValueAt(i,1).toString();
        int Qty = Integer.parseInt(dmt2.getValueAt(i,2).toString());
        total=total-subtot;
        TotalAtPos.setText(""+total);
        int AvailabilityAtItem=0; 
        try{
            String sql = "DELETE from pos where InvoiceID LIKE ? AND seqno LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(InvoiceID));
            pst.setString(2,seqno);
            
            pst.execute();
           

            getPOS();
            JOptionPane.showMessageDialog(null,"Deleted!");
          

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
  
        try
        {
            String sql;
            sql = "SELECT Availability from item where ItemName like '"+item_name+"'";
            pst = conn.prepareStatement(sql);
            rs1 = pst.executeQuery();
            rs1.next();
            AvailabilityAtItem = Qty + rs1.getInt(1);
            
            
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, e);       
        }
        
        try
        {
            String sql ="UPDATE item SET Availability='"+AvailabilityAtItem+"' where ItemName like '"+item_name+"'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        int row=0;
        try{
            String SQL;
            SQL = "SELECT COUNT(*) FROM stock WHERE ItemName LIKE '" + item_name + "' AND availability != quantity ";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1= pst.executeQuery();
            rs1.next();
            row=rs1.getInt(1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        String ava[][]= new String[4][row];
        try{
            String SQL;
            SQL = "SELECT InvoiceNo,seqNostock,availability,quantity FROM stock WHERE ItemName LIKE '" + item_name + "' AND availability != quantity ";
            PreparedStatement pst;
            pst = conn.prepareStatement(SQL);
            rs1= pst.executeQuery();
            int x = row-1;
          
            while(rs1.next())
            {
                ava[0][x]=rs1.getString(1);
                ava[1][x]=rs1.getString(2);
                ava[2][x]=rs1.getString(3);
                ava[3][x]=rs1.getString(4);
                
                x--;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        int z=0;
        while(Qty>0)
        {
            
            if(Qty>=(Integer.parseInt(ava[3][z]))-(Integer.parseInt(ava[2][z])))
            {
                try{
                    st = conn.createStatement();
                    String sql1 = "UPDATE stock SET availability='"+ava[3][z]+"'  where ItemName LIKE '" + item_name + "' AND InvoiceNo LIKE '"+ava[0][z]+"' AND seqNostock LIKE '"+ava[1][z]+"'";
                    st.executeUpdate(sql1);
                    Qty=Qty-((Integer.parseInt(ava[3][z]))-(Integer.parseInt(ava[2][z])));
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            else
            {
                int aval=Qty+(Integer.parseInt(ava[2][z]));
                try{
                    st = conn.createStatement();
                    String sql1 = "UPDATE stock SET availability='"+aval+"'  where ItemName LIKE '" + item_name + "' AND InvoiceNo LIKE '"+ava[0][z]+"' AND seqNostock LIKE '"+ava[1][z]+"'";
                    st.executeUpdate(sql1);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            z++;
                
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void qtyAtPOSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyAtPOSFocusLost
       
        String s = qtyAtPOS.getText();
        if(s.equals(""))
        {
            validationforQTYAtPOS.setText("Quantity field can't be empty");
            validationforQTYAtPOS.setForeground(Color.red);
        }
        else if(Integer.parseInt(qtyAtPOS.getText())>Integer.parseInt(ItemAvailabilityAtPOS.getText()))
        {
            validationforQTYAtPOS.setText("Quantity exceeds the availability");
            validationforQTYAtPOS.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isDigit(a))
                {
                    validationforQTYAtPOS.setText("");
                }
                else
                {
                   validationforQTYAtPOS.setText("You can only have numbers in Quantity field!");
                   validationforQTYAtPOS.setForeground(Color.red);
                }
            
            }
        }   
       POSbtncontroller();
    }//GEN-LAST:event_qtyAtPOSFocusLost

    private void qtyAtPOSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyAtPOSKeyReleased
        
        String s = qtyAtPOS.getText();
        validationforQTYAtPOS.setForeground(Color.red);
        try{
            Integer.parseInt(qtyAtPOS.getText());
        }
        catch(Exception e)
        {
            validationforQTYAtPOS.setText("You can only have numbers in Quantity field!");
        }
        if(s.equals(""))
        {
            validationforQTYAtPOS.setText("Quantity field can't be empty");
        }
        else if(Integer.parseInt(qtyAtPOS.getText())>Integer.parseInt(ItemAvailabilityAtPOS.getText()))
        {
            validationforQTYAtPOS.setText("Quantity exceeds the availability");
            
        }
  
       POSbtncontroller();
    }//GEN-LAST:event_qtyAtPOSKeyReleased

    private void qtyAtPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyAtPOSActionPerformed
      
    }//GEN-LAST:event_qtyAtPOSActionPerformed

    private void AmountAtPosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountAtPosKeyReleased
       
        double amount=Double.parseDouble(AmountAtPos.getText());
        double total =Double.parseDouble(TotalAtPos.getText());
        
        double balance = amount-total;
     
        
        BalanceAtPos.setText(String.valueOf(balance));
        if(amount>=total ||(AmountAtPos.getText().equals("0")))
        {

        }
       
        else
        {
   
        }
        
    }//GEN-LAST:event_AmountAtPosKeyReleased

    private void NotificationAtMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationAtMainMouseClicked
       
        Notification n = new Notification();
        n.setVisible(true);
    }//GEN-LAST:event_NotificationAtMainMouseClicked

    private void ExpiryDateAlertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpiryDateAlertMouseClicked
     
         ExpiryDateAlert eda = new ExpiryDateAlert();
         eda.setVisible(true);
    }//GEN-LAST:event_ExpiryDateAlertMouseClicked

    private void sel_priceAtPOSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sel_priceAtPOSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_sel_priceAtPOSKeyReleased

    private void patIDatPOSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patIDatPOSFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_patIDatPOSFocusLost

    private void AmountAtPosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountAtPosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AmountAtPosMouseClicked

    private void BalanceAtPosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BalanceAtPosKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BalanceAtPosKeyReleased
  public void ClearPOS()
    {
        serialNoAtPOS.setText("");
        itemidAtPOS.setText("");
        TextAtItemPOS.setText("");
        qtyAtPOS.setText("");
        ItemAvailabilityAtPOS.setText("");
       
        sel_priceAtPOS.setText("");
    
        
        
        
    }
  public void POSbtncontroller()
  {
      if(validationforQTYAtPOS.getText().equals("") && !qtyAtPOS.getText().equals("") && Integer.parseInt(qtyAtPOS.getText())<=Integer.parseInt(ItemAvailabilityAtPOS.getText()))
      {
          AddbtnAtPOS.setEnabled(true);
          
      }
      
      else
      {
          AddbtnAtPOS.setEnabled(false);
      }
     
  }
  
  
    public void getPOS()
    {
        
        while(dmt2.getRowCount() > 0)
        {
            dmt2.removeRow(0);
        }
        try{
            String SQL;
            SQL = "SELECT * FROM pos WHERE InvoiceID LIKE '"+InvoiceID+"'";
            pst = conn.prepareStatement(SQL);
            rs1 = pst.executeQuery();
            while(rs1.next())
            {
                
                dmt2.addRow(new Object[]{rs1.getString(2),rs1.getString(5),rs1.getString(6),rs1.getString(7),rs1.getString(8)});
             
            }
            
            
        }
        catch(SQLException | NumberFormatException e)
        {
         
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddbtnAtPOS;
    private javax.swing.JTextField AmountAtPos;
    private javax.swing.JTextField BalanceAtPos;
    private javax.swing.JLabel ExpiryDateAlert;
    private javax.swing.JTextField ItemAvailabilityAtPOS;
    private javax.swing.JLabel NotificationAtMain;
    private javax.swing.JCheckBox RadiodtwAtPOS;
    private javax.swing.JTextField TextAtItemPOS;
    private javax.swing.JTextField TotalAtPos;
    private javax.swing.JLabel invoiceIDAtpos;
    private javax.swing.JTextField itemidAtPOS;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField patIDatPOS;
    private javax.swing.JLabel posdistributedwardlb;
    private javax.swing.JTextField qtyAtPOS;
    private javax.swing.JTextField sel_priceAtPOS;
    private javax.swing.JTextField serialNoAtPOS;
    private javax.swing.JTable tableAtPOS;
    private javax.swing.JLabel validationforQTYAtPOS;
    // End of variables declaration//GEN-END:variables
}
