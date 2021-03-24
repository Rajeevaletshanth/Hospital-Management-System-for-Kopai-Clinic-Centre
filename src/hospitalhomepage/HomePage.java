/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalhomepage;


import finance_management.MainMenu;
import In_patient.inPatient_management;
import Inventory.inv_home;
import pms.clinic.opdGUI;
import Pharmacy.Main;





public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
    }

    
    public void set_previlege(String type){
        if(type.equals("admin")){
             
        
        }
        else if(type.equals("rep")){
            
             
            inv.setEnabled(false);
           
            pha.setEnabled(false);
                bf.setEnabled(false);
                
            
        }
        else if(type.equals("hr")){
            opd.setEnabled(false);
            inp.setEnabled(false);
           
            pha.setEnabled(false);
                bf.setEnabled(false);
            
            
        }
        else if(type.equals("phar")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            inv.setEnabled(false);
            bf.setEnabled(false);
            
            
            
        }
        else if(type.equals("lab_assist")){
            opd.setEnabled(false);
            inp.setEnabled(false);
           
            inv.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
            
        }
        else if(type.equals("opd")){
          
            inp.setEnabled(false);
            inv.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
        }
        else if (type.equals("vcl")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            inv.setEnabled(false);
          
            pha.setEnabled(false);
                bf.setEnabled(false);
            
        }
        else{
        
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        opd = new javax.swing.JButton();
        inp = new javax.swing.JButton();
        pha = new javax.swing.JButton();
        inv = new javax.swing.JButton();
        bf = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        opd.setBackground(new java.awt.Color(40, 40, 40));
        opd.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        opd.setForeground(new java.awt.Color(255, 255, 255));
        opd.setText("CLINIC");
        opd.setPreferredSize(new java.awt.Dimension(200, 30));
        opd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opdActionPerformed(evt);
            }
        });

        inp.setBackground(new java.awt.Color(40, 40, 40));
        inp.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        inp.setForeground(new java.awt.Color(255, 255, 255));
        inp.setText("IN PATIENT");
        inp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpActionPerformed(evt);
            }
        });

        pha.setBackground(new java.awt.Color(40, 40, 40));
        pha.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        pha.setForeground(new java.awt.Color(255, 255, 255));
        pha.setText("PHARMACY");
        pha.setPreferredSize(new java.awt.Dimension(200, 30));
        pha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phaActionPerformed(evt);
            }
        });

        inv.setBackground(new java.awt.Color(40, 40, 40));
        inv.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        inv.setForeground(new java.awt.Color(255, 255, 255));
        inv.setText("INVENTORY");
        inv.setPreferredSize(new java.awt.Dimension(200, 30));
        inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invActionPerformed(evt);
            }
        });

        bf.setBackground(new java.awt.Color(40, 40, 40));
        bf.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        bf.setForeground(new java.awt.Color(255, 255, 255));
        bf.setText("FINANCE");
        bf.setPreferredSize(new java.awt.Dimension(200, 30));
        bf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(40, 40, 40));
        jButton1.setFont(new java.awt.Font("Myriad Pro", 1, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(opd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(inp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(inv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(opd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inp, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inv, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(inp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(inv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(bf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(130, 150, 630, 510);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Myriad Pro", 1, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("KOPAI CLINIC CENTRE");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 40, 660, 79);

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalhomepage/heart.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-580, 0, 1930, 780);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       LogIn li=new LogIn();
       li.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }//GEN-LAST:event_bfActionPerformed

    private void invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invActionPerformed
        // TODO add your handling code here:
        this.dispose();
        inv_home ih = new inv_home();
        ih.setVisible(true);
    }//GEN-LAST:event_invActionPerformed

    private void phaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phaActionPerformed
        // TODO add your handling code here:
        Main m = new Main();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_phaActionPerformed

    private void inpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpActionPerformed

        this.setVisible(false);
        inPatient_management Im=new inPatient_management();
        Im.setVisible(true);
    }//GEN-LAST:event_inpActionPerformed

    private void opdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opdActionPerformed
        // TODO add your handling code here:
        this.dispose();
        opdGUI op = new opdGUI();
        op.setVisible(true);
    }//GEN-LAST:event_opdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bf;
    private javax.swing.JButton inp;
    private javax.swing.JButton inv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton opd;
    private javax.swing.JButton pha;
    // End of variables declaration//GEN-END:variables
}
