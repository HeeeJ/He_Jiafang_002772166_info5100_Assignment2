/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import dao.CommunityDao;
import dao.PersonDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.persons.Patient;
import utils.StringUtil;

/**
 *
 * @author Jiaf
 */
public class SignUpFrame extends javax.swing.JFrame {
    Patient patient = new Patient();
    /**
     * Creates new form SignUpFrame
     */
    public SignUpFrame() {
        initComponents();
        List<String> houses = PersonDao.allHouse();
        for(String h : houses){
            cboxHome.addItem(h);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGender = new javax.swing.ButtonGroup();
        txtName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cboxHome = new javax.swing.JComboBox<>();
        lblAge = new javax.swing.JLabel();
        cboxCom = new javax.swing.JComboBox<>();
        cboxCity = new javax.swing.JComboBox<>();
        btnMale = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblName = new javax.swing.JLabel();
        btnFemale = new javax.swing.JRadioButton();
        lblName1 = new javax.swing.JLabel();
        txtAcc = new javax.swing.JTextField();
        lblName2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtName.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGender.setText("Gender:");

        txtAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblAddress.setText("House Address:");

        btnSave.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnSave.setText("Create New Account");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cboxHome.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        cboxHome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxHomeItemStateChanged(evt);
            }
        });
        cboxHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxHomeActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Age:");

        cboxCom.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        cboxCity.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        bgGender.add(btnMale);
        btnMale.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnMale.setText("Male");

        lblName.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name:");

        bgGender.add(btnFemale);
        btnFemale.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnFemale.setText("Female");

        lblName1.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName1.setText("Password:");

        txtAcc.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        txtAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAccMouseExited(evt);
            }
        });
        txtAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccActionPerformed(evt);
            }
        });

        lblName2.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName2.setText("Account:");

        txtPassword.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPasswordMouseExited(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Hint:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(50, 84));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName2)
                                .addGap(18, 18, 18)
                                .addComponent(txtAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGender)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMale))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFemale, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAddress)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblName1)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblAge))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(txtName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxHome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboxCom, 0, 220, Short.MAX_VALUE)
                                        .addComponent(cboxCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName2)
                    .addComponent(txtAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName1)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(btnMale)
                    .addComponent(btnFemale))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        if(StringUtil.isEmpty(txtAge.getText())||StringUtil.isEmpty(txtName.getText())
            || bgGender.getSelection()==null||cboxHome.equals(null)||!StringUtil.isValidPassword(txtPassword.getText())){
            JOptionPane.showMessageDialog(this, "Please check all required information.");
        }
        else{
                patient.setAccount(txtAcc.getText());
                patient.setPassword(txtPassword.getText());
                patient.setName(txtName.getText());
                patient.setAge(txtAge.getText());
                if(btnMale.isSelected())
                    patient.setGender("male");

                patient.setGender("female");
                patient.setHouse((String)cboxHome.getSelectedItem());
                
                
            try {
                CommunityDao.addPatient(patient, cboxHome.getSelectedItem().toString());                
                JOptionPane.showMessageDialog(this, "Successfully update information.");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Create account failed.");
            }
                



      }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboxHomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxHomeItemStateChanged

        String selectedHouse = (String) cboxHome.getSelectedItem();
        List<String> comNCity = PersonDao.getComNCity(selectedHouse);

        cboxCom.removeAllItems();
        cboxCity.removeAllItems();

        cboxCom.addItem(comNCity.get(0));
        cboxCity.addItem(comNCity.get(1));
    }//GEN-LAST:event_cboxHomeItemStateChanged

    private void cboxHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxHomeActionPerformed

    private void txtAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseEntered
        jTextArea1.append("at least 8 characters and at most 20 characters.\n" +
            "at least one digit.\n" +
            "at least one upper case alphabet.\n" +
            "at least one lower case alphabet.\n" +
            "at least one special character which includes !@#$%&*()-+=^.\n" +
            "It doesn???t contain any white space.");
    }//GEN-LAST:event_txtPasswordMouseEntered

    private void txtPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseExited
// TODO add your handling code here:

        jTextArea1.setText("");
    }//GEN-LAST:event_txtPasswordMouseExited

    private void txtAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccMouseEntered
        jTextArea1.append("type your preferred account name.");        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccMouseEntered

    private void txtAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccMouseExited
        jTextArea1.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboxCity;
    private javax.swing.JComboBox<String> cboxCom;
    private javax.swing.JComboBox<String> cboxHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JTextField txtAcc;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
