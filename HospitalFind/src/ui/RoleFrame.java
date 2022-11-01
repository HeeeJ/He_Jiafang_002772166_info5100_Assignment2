/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author Jiaf
 */
public class RoleFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form RoleFrame
     */
    public RoleFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbPatient = new javax.swing.JLabel();
        lbDoctor = new javax.swing.JLabel();
        lbComAdm = new javax.swing.JLabel();
        lbSysAdm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginRole");
        setBackground(new java.awt.Color(0, 51, 102));
        setIconImages(null);
        setLocation(new java.awt.Point(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Hospital Management System!");

        jLabel2.setText("Please tell us who are you?");

        lbPatient.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient.png"))); // NOI18N
        lbPatient.setText("Patient");
        lbPatient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPatientMouseClicked(evt);
            }
        });

        lbDoctor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doctor.png"))); // NOI18N
        lbDoctor.setText("Doctor");
        lbDoctor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDoctorMouseClicked(evt);
            }
        });

        lbComAdm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbComAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comAdmin.png"))); // NOI18N
        lbComAdm.setText("Community Administar");
        lbComAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbComAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbComAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbComAdmMouseClicked(evt);
            }
        });

        lbSysAdm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSysAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin.png"))); // NOI18N
        lbSysAdm.setText("System Manager");
        lbSysAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbSysAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSysAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSysAdmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbComAdm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPatient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSysAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbComAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSysAdm)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbComAdm, lbDoctor, lbPatient, lbSysAdm});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatientMouseClicked
        
        LoginJFrame login = new LoginJFrame("patient");
        login.setVisible(true);
        
    }//GEN-LAST:event_lbPatientMouseClicked

    private void lbDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDoctorMouseClicked
        // TODO add your handling code here:
        
        LoginJFrame login = new LoginJFrame("doctor");
        login.setVisible(true);
    }//GEN-LAST:event_lbDoctorMouseClicked

    private void lbComAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbComAdmMouseClicked
        // TODO add your handling code here:
        LoginJFrame login = new LoginJFrame("comAdmin");
        login.setVisible(true);
    }//GEN-LAST:event_lbComAdmMouseClicked

    private void lbSysAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSysAdmMouseClicked
        // TODO add your handling code here:
        LoginJFrame login = new LoginJFrame("sysAdmin");
        login.setVisible(true);
    }//GEN-LAST:event_lbSysAdmMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbComAdm;
    private javax.swing.JLabel lbDoctor;
    private javax.swing.JLabel lbPatient;
    private javax.swing.JLabel lbSysAdm;
    // End of variables declaration//GEN-END:variables
}
