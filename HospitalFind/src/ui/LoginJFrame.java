/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;


import dao.PersonDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.persons.CommunityAdmin;
import model.persons.Doctor;
import model.persons.Patient;
import model.persons.Person;
import model.persons.SystemAdmin;
import utils.StringUtil;

/**
 *
 * @author jiaf
 */
public class LoginJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginJFrame
     */
    private String userRole = null;
    
    public LoginJFrame(){}
    
    public LoginJFrame(String role) {
        
        userRole = role;
        initComponents();
        btnCreateAccount.setVisible(false);
         if(userRole == "patient")
             btnCreateAccount.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        pwPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(420, 520));
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(350, 450));
        setPreferredSize(new java.awt.Dimension(350, 450));
        setResizable(false);

        lblTitle.setText("Find your hospital!");

        lblAccount.setText("Account:");

        lblPassword.setText("Password:");

        txtAccount.setText("sysAdmin");
        txtAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountActionPerformed(evt);
            }
        });

        btnLogin.setText("Sign In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCreateAccount.setText("New Here?");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        pwPassword.setText("sys123456");
        pwPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblAccount))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAccount)
                                .addComponent(pwPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccount)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pwPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateAccount)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String account = txtAccount.getText();
        String password = new String(this.pwPassword.getPassword());
        
        //textfeild empty validation.
        if(StringUtil.isEmpty(account)||StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(this, "Please provide both account and password.");
        }else{
            try {
            //Initail User
                
                if(userRole == "patient"){
                    
                    Patient patient = PersonDao.patientlogin(account, password);
                    if(patient != null){  
                        PatientHomeFrame patientHomeFrame = new PatientHomeFrame(patient);
                        patientHomeFrame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Check your role, account and password.");
                    }
                        
                }
                
                else if(userRole == "doctor"){
                    Doctor doc = PersonDao.doclogin(account, password);
                    if(doc != null){
                        DoctorHomeFrame doctorHomeFrame = new DoctorHomeFrame(doc);
                        doctorHomeFrame.setVisible(true);
                    }else
                        JOptionPane.showMessageDialog(this, "Check your role, account and password.");
                    
                    
                }
                else if(userRole == "comAdmin"){
                    CommunityAdmin ca = PersonDao.calogin(account, password);
                    if(ca != null){
                        ComAdminFrame caf = new ComAdminFrame(ca) ;
                        caf.setVisible(true);
                    }else
                       JOptionPane.showMessageDialog(this, "Check your role, account and password.");
                }
                else if(userRole == "sysAdmin" ){
                    SystemAdmin sa = PersonDao.salogin(account, password);
                    if(sa != null){
                        SysAdFrame saf = new SysAdFrame(sa);
                        saf.setVisible(true);
                    }else
                        JOptionPane.showMessageDialog(this, "Check your role, account and password.");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Login Error. Please check your role selection.");
                }
                                
                dispose();//dispose login frame

            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Login Error.");
            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        SignUpFrame signUpFrame = new SignUpFrame();
        signUpFrame.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void pwPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwPasswordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField pwPassword;
    private javax.swing.JTextField txtAccount;
    // End of variables declaration//GEN-END:variables
}
