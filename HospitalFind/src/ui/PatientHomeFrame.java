/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import dao.EncounterDao;
import dao.HospitalDao;
import dao.PersonDao;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.hospitals.Hospital;
import model.hospitals.HospitalDir;
import model.persons.Patient;
import model.persons.encounters.Encounter;
import model.persons.encounters.EncountersHistory;
import utils.StringUtil;

/**
 *
 * @author Jiaf
 */
public class PatientHomeFrame extends javax.swing.JFrame {

    private Patient patient;
    
    public PatientHomeFrame() {
   
    }
    public PatientHomeFrame(Patient p) throws SQLException {
        
        
        initComponents();
        lblTitle1.setVisible(false);
        patient = p;
        showDetails();
        hospitalTable();
        encountersTable();
        

        
    }
    
    public void readonly(){
        btnSave.setEnabled(false);
        btnMale.setEnabled(false);
        btnFemale.setEnabled(false);
        cboxCity.setEnabled(false);
        cboxCom.setEnabled(false);
        cboxHome.setEnabled(false);
        
        txtName.setEditable(false);
        txtAge.setEditable(false);
        
    }
    
    public void showDetails(){
        readonly();
        txtName.setText(patient.getName());
        txtAge.setText(patient.getAge());

        if( patient.getGender().equals("male")){
            btnMale.setSelected(true);
            btnFemale.setSelected(false);
        }
        else if( patient.getGender().equals("female")){
            btnMale.setSelected(false);
            btnFemale.setSelected(true);
        }
        else{
            btnMale.setSelected(false);
            btnFemale.setSelected(false);
        }
        
        List<String> address = PersonDao.paHouse(patient);
        
        System.out.println(address);
        cboxHome.addItem(address.get(0));
        cboxCom.setSelectedItem(address.get(1));
        cboxCity.setSelectedItem(address.get(2));
        
        

    }
    
    public void editall(){
        txtName.setEditable(true);
        txtAge.setEditable(true);
        btnMale.setEnabled(true);
        btnFemale.setEnabled(true);
        btnSave.setEnabled(true);
        
        cboxHome.setEnabled(true);
        cboxCity.setEnabled(true);
        cboxCom.setEnabled(true);
        
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblAge = new javax.swing.JLabel();
        btnMale = new javax.swing.JRadioButton();
        lblName = new javax.swing.JLabel();
        btnFemale = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        cboxHome = new javax.swing.JComboBox<>();
        cboxCom = new javax.swing.JComboBox<>();
        cboxCity = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHospital = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEncounters = new javax.swing.JTable();
        btnEncounter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Home Page");
        setLocation(new java.awt.Point(440, 450));
        setResizable(false);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        jPanel3.setPreferredSize(new java.awt.Dimension(600, 600));

        btnUpdate.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFocusable(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Age:");

        bgGender.add(btnMale);
        btnMale.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnMale.setText("Male");

        lblName.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name:");

        bgGender.add(btnFemale);
        btnFemale.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnFemale.setText("Female");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGender.setText("Gender:");

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblAddress.setText("House Address:");

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

        cboxCom.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        cboxCity.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        jLabel1.setText("Edit information by click button.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblGender)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMale))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblAge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(txtName)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFemale, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAddress))
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboxCom, 0, 220, Short.MAX_VALUE)
                                .addComponent(cboxCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnUpdate))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(cboxHome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(btnMale)
                    .addComponent(btnFemale))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personal", jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(464, 300));

        tblHospital.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        tblHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Hospital", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHospital);

        lblTitle.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Find doctors in hospital close to you.");

        btnView.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnView.setText("Find Doctors");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        lblTitle1.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(204, 0, 51));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle1.setText("No close hospitals. Show all hospitals.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnView)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addContainerGap())
        );

        jTabbedPane1.addTab("My Hospital", jPanel1);

        lblTitle2.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle2.setText("See details by click 'More Information'.");

        tblEncounters.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        tblEncounters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hospital", "Doctor", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEncounters.setPreferredSize(new java.awt.Dimension(80, 80));
        jScrollPane2.setViewportView(tblEncounters);
        if (tblEncounters.getColumnModel().getColumnCount() > 0) {
            tblEncounters.getColumnModel().getColumn(1).setResizable(false);
        }

        btnEncounter.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnEncounter.setText("More Information");
        btnEncounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncounterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitle2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEncounter)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEncounter)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Medical History", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
    
        int selectedRowIndex = tblHospital.getSelectedRow();
        if (selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a hospital.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblHospital.getModel();
        Hospital selectedHospital = (Hospital) model.getValueAt(selectedRowIndex, 0);        // TODO add your handling code here:
        
        DoctorListFrame docsInHos;
        try {
            docsInHos = new DoctorListFrame(selectedHospital);
            docsInHos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PatientHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //show new window of information details
        
    }//GEN-LAST:event_btnViewActionPerformed
    
    
    
    private void btnEncounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncounterActionPerformed
        int selectedRowIndex = tblEncounters.getSelectedRow();
        if (selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a record.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblEncounters.getModel();
        Encounter selectedEncounter = (Encounter) model.getValueAt(selectedRowIndex, 0);        // TODO add your handling code here:
        
        EncountersFrame encountersFrame;
        encountersFrame = new EncountersFrame(selectedEncounter);
        encountersFrame.setVisible(true);
    }//GEN-LAST:event_btnEncounterActionPerformed

    private void cboxHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxHomeActionPerformed

    private void cboxHomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxHomeItemStateChanged

        String selectedHouse = (String) cboxHome.getSelectedItem();
        List<String> comNCity = PersonDao.getComNCity(selectedHouse);

        cboxCom.removeAllItems();
        cboxCity.removeAllItems();

        cboxCom.addItem(comNCity.get(0));
        cboxCity.addItem(comNCity.get(1));
    }//GEN-LAST:event_cboxHomeItemStateChanged

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(StringUtil.isEmpty(txtAge.getText())||StringUtil.isEmpty(txtName.getText())
            || bgGender.getSelection()==null||cboxHome.equals(null)){
            JOptionPane.showMessageDialog(this, "Please provide all required information.");
        }else{
            try{
                patient.setName(txtName.getText());
                patient.setAge(txtAge.getText());
                if(btnMale.isSelected()){
                    patient.setGender("male");
                }else
                patient.setGender("female");
                patient.setHouse((String)cboxHome.getSelectedItem());

                PersonDao.updatePatient(patient);

                JOptionPane.showMessageDialog(this, "Successfully update information.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Update personal information failed.");
            }

        }
        String[] arr={patient.getHouse()};
        cboxHome.setModel(new DefaultComboBoxModel<String> (arr));
        // TODO add your handling code here:
        readonly();
        showDetails();
        try {
            hospitalTable();
        } catch (SQLException ex) {
            Logger.getLogger(PatientHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked

        editall();

        List<String> houses = PersonDao.allHouse();
        for(String h : houses){
            cboxHome.addItem(h);
        }

        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void hospitalTable() throws SQLException{
        String userAccount = patient.getAccount();
        HospitalDir hospitals = HospitalDao.findHospitalDir(userAccount);
        DefaultTableModel model = (DefaultTableModel) tblHospital.getModel();
        
        if(hospitals.getHospitalDir().isEmpty()){
            
            lblTitle.setVisible(false);
            lblTitle1.setVisible(true);
            
            HospitalDir allHospital = HospitalDao.allHospital();
            
            model.setRowCount(0);

            for (Hospital h : allHospital.getHospitalDir()){

                Object [] row = new Object[2];
                row[0] = h;
                row[1] = h.getAddress();

                model.addRow(row);
            }
        }
        else{
            model.setRowCount(0);

            for (Hospital h : hospitals.getHospitalDir()){

                Object [] row = new Object[2];
                row[0] = h;
                row[1] = h.getAddress();

                model.addRow(row);
            }
            
        }           
        
    }
    
    private void encountersTable() throws SQLException{
            
            int id = patient.getId();
            EncountersHistory ens = EncounterDao.patientEncountersHistory(id);
            if(ens==null){
                lblTitle2.setText("Don't have health records yet.");
                lblTitle2.setForeground(Color.decode("#E63946"));
            }
            else{
    
                DefaultTableModel model = (DefaultTableModel) tblEncounters.getModel();
        
                model.setRowCount(0);

                for (Encounter e : ens.getEncounterHis()){

                    Object [] row = new Object[3];
                    row[0] = e;
                    row[1] = e.getDoctor();
                    row[2] = e.getDate();

                    model.addRow(row);
            }
        
    }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JButton btnEncounter;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboxCity;
    private javax.swing.JComboBox<String> cboxCom;
    private javax.swing.JComboBox<String> cboxHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tblEncounters;
    private javax.swing.JTable tblHospital;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
