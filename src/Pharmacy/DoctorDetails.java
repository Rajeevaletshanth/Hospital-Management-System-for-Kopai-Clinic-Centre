
package Pharmacy;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DoctorDetails extends javax.swing.JFrame {

   
    Connection conn = null;
    ResultSet rs,rs1;
    PreparedStatement pst;
    public DoctorDetails() {
    initComponents();
 

   
        
    }
    public DoctorDetails(int InvoiceID) {
        initComponents();
           try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yarlmothercare", "root", "");
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        sunmitbtnAtDR_details.setEnabled(false);
        InvoiceIdAtDoc.setText(String.valueOf(InvoiceID));
        InvoiceIdAtDoc.setEditable(false);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        InvoiceIdAtDoc = new javax.swing.JTextField();
        DoctorNameAtPrescription = new javax.swing.JTextField();
        RegNoAtPrescription = new javax.swing.JTextField();
        sunmitbtnAtDR_details = new javax.swing.JButton();
        Validation_dr_name_at_Doctor_details = new javax.swing.JLabel();
        Validation_dr_regno_at_Doctor_details1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoice ID : ");

        jLabel2.setText("Doctor Name : ");

        jLabel3.setText("Doctor's Reg. no. :");

        InvoiceIdAtDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                InvoiceIdAtDocFocusLost(evt);
            }
        });
        InvoiceIdAtDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoiceIdAtDocActionPerformed(evt);
            }
        });

        DoctorNameAtPrescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DoctorNameAtPrescriptionFocusLost(evt);
            }
        });

        RegNoAtPrescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RegNoAtPrescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                RegNoAtPrescriptionFocusLost(evt);
            }
        });
        RegNoAtPrescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RegNoAtPrescriptionKeyReleased(evt);
            }
        });

        sunmitbtnAtDR_details.setText("Submit");
        sunmitbtnAtDR_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunmitbtnAtDR_detailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(sunmitbtnAtDR_details)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InvoiceIdAtDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(DoctorNameAtPrescription)
                            .addComponent(RegNoAtPrescription))
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addComponent(Validation_dr_name_at_Doctor_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Validation_dr_regno_at_Doctor_details1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(InvoiceIdAtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DoctorNameAtPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(Validation_dr_name_at_Doctor_details, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RegNoAtPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Validation_dr_regno_at_Doctor_details1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sunmitbtnAtDR_details)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sunmitbtnAtDR_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunmitbtnAtDR_detailsActionPerformed
        
        String drname = DoctorNameAtPrescription.getText();
        String regno = RegNoAtPrescription.getText();
        int inv_id=Integer.parseInt(InvoiceIdAtDoc.getText());
     
        try{
            pst=conn.prepareStatement("Insert into doctor_prescription values(?,?,?)");
            pst.setInt(1,inv_id);
            pst.setString(2,drname);
            pst.setString(3,regno);
          
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inserted Successfully");
            DoctroDetailbtnctrl();
            dispose();
    }//GEN-LAST:event_sunmitbtnAtDR_detailsActionPerformed
   catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
     
    }
    private void InvoiceIdAtDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InvoiceIdAtDocFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_InvoiceIdAtDocFocusLost

    private void DoctorNameAtPrescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DoctorNameAtPrescriptionFocusLost
       
        String s = DoctorNameAtPrescription.getText();
        if(s.equals(""))
        {
            Validation_dr_name_at_Doctor_details.setText("Name field can't be empty");
            Validation_dr_name_at_Doctor_details.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetter(a))
                {
                    Validation_dr_name_at_Doctor_details.setText("");
                }
                else
                {
                   Validation_dr_name_at_Doctor_details.setText("You only can have text in the Doctor name field!");
                   Validation_dr_name_at_Doctor_details.setForeground(Color.red);
                }
            
            }
        }   
        DoctroDetailbtnctrl();
        
           
    }//GEN-LAST:event_DoctorNameAtPrescriptionFocusLost

    private void RegNoAtPrescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RegNoAtPrescriptionFocusGained
        
        String s = DoctorNameAtPrescription.getText();
        if(s.equals(""))
        {
            Validation_dr_name_at_Doctor_details.setText("Name field can't be empty");
            Validation_dr_name_at_Doctor_details.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetter(a))
                {
                    Validation_dr_name_at_Doctor_details.setText("");
                }
                else
                {
                   Validation_dr_name_at_Doctor_details.setText("You only can have text in the Doctor name field!");
                   Validation_dr_name_at_Doctor_details.setForeground(Color.red);
                }
            
            }
        }   
        DoctroDetailbtnctrl();
    }//GEN-LAST:event_RegNoAtPrescriptionFocusGained

    private void RegNoAtPrescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RegNoAtPrescriptionFocusLost
       
         String s = RegNoAtPrescription.getText();
        if(s.equals(""))
        {
            Validation_dr_regno_at_Doctor_details1.setText("Reg NO field can't be empty");
            Validation_dr_regno_at_Doctor_details1.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetterOrDigit(a))
                {
                    Validation_dr_regno_at_Doctor_details1.setText("");
                }
                else
                {
                   Validation_dr_regno_at_Doctor_details1.setText("You only can have numbers and texts in Reg No field!");
                   Validation_dr_regno_at_Doctor_details1.setForeground(Color.red);
                }
            
            }
        }   
        DoctroDetailbtnctrl();
    }//GEN-LAST:event_RegNoAtPrescriptionFocusLost

    private void RegNoAtPrescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RegNoAtPrescriptionKeyReleased
      
        String s = RegNoAtPrescription.getText();
        if(s.equals(""))
        {
            Validation_dr_regno_at_Doctor_details1.setText("Quantity field can't be empty");
            Validation_dr_regno_at_Doctor_details1.setForeground(Color.red);
        }
        else
        {
            for (int i = 0 ; i < s.length(); i++)
            {
                char a = s.charAt(i);
            
                if (Character.isLetterOrDigit(a))
                {
                    Validation_dr_regno_at_Doctor_details1.setText("");
                }
                else
                {
                   Validation_dr_regno_at_Doctor_details1.setText("You only can have numbers and texts in Reg No field!");
                   Validation_dr_regno_at_Doctor_details1.setForeground(Color.red);
                }
            
            }
        }   
        DoctroDetailbtnctrl();
    }//GEN-LAST:event_RegNoAtPrescriptionKeyReleased

    private void InvoiceIdAtDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoiceIdAtDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoiceIdAtDocActionPerformed
  
  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorDetails().setVisible(true);
}
        });
    }
    
    public void DoctroDetailbtnctrl()
    {
        if(Validation_dr_name_at_Doctor_details.getText().equals("") && Validation_dr_regno_at_Doctor_details1.getText().equals("") && !DoctorNameAtPrescription.getText().equals("") && !RegNoAtPrescription.getText().equals("")  )
        {
            sunmitbtnAtDR_details.setEnabled(true);
        }
        else
        {
            sunmitbtnAtDR_details.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DoctorNameAtPrescription;
    private javax.swing.JTextField InvoiceIdAtDoc;
    private javax.swing.JTextField RegNoAtPrescription;
    private javax.swing.JLabel Validation_dr_name_at_Doctor_details;
    private javax.swing.JLabel Validation_dr_regno_at_Doctor_details1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton sunmitbtnAtDR_details;
    // End of variables declaration//GEN-END:variables
}



