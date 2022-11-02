/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import dao.EncounterDao;
import dao.PersonDao;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.tools.DiagnosticCollector;
import model.persons.Doctor;
import model.persons.Patient;
import model.persons.Person;
import model.persons.encounters.Encounter;
import model.persons.encounters.EncountersHistory;
import model.persons.encounters.VitalSign;
import utils.StringUtil;

/**
 *
 * @author Jiaf
 */
public class DoctorHomeFrame extends javax.swing.JFrame {

    private Doctor doctor;
    private List<Patient> patients = new ArrayList<>();
    private List<String> selectedPaInfo = new ArrayList<>();
    /**
     * Creates new form DoctorHomeFrame
     */
    public DoctorHomeFrame(Doctor d) throws SQLException {
        initComponents();
        doctor = d;
        showDetails();
        tblEncounters();
        allPatient();

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
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnMale = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblName = new javax.swing.JLabel();
        btnFemale = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtMajor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEncounters = new javax.swing.JTable();
        btnEncounter = new javax.swing.JButton();
        lblTitle2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        cboxPatient = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtTemperature = new javax.swing.JTextField();
        txtPulse = new javax.swing.JTextField();
        txtBreath = new javax.swing.JTextField();
        txtBloodHigh = new javax.swing.JTextField();
        txtBloodLow = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnNewDiagosis = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblPaAge = new javax.swing.JLabel();
        lblPaGender = new javax.swing.JLabel();
        lblPaAccount = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Community Home Page");
        setLocation(new java.awt.Point(420, 480));
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

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

        lblAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Age:");

        jLabel1.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        jLabel1.setText("Edit information by click button.");

        jLabel2.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel2.setText("Major:");

        btnSave.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFocusable(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        txtMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMajorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGender)
                                    .addComponent(lblAge)
                                    .addComponent(lblName)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnMale)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                                .addComponent(btnFemale))
                                            .addComponent(txtAge)
                                            .addComponent(txtName)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(txtMajor)))
                                .addGap(136, 136, 136))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(btnMale)
                    .addComponent(btnFemale))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Personal", jPanel1);

        tblEncounters.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        tblEncounters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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

        btnEncounter.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnEncounter.setText("More Information");
        btnEncounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncounterActionPerformed(evt);
            }
        });

        lblTitle2.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle2.setText("See details by click 'More Information'.");

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("Interview records", jPanel2);

        jLabel5.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel5.setText("Body temperature (F)");

        jLabel9.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel9.setText("Patietnt:");

        jLabel6.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel6.setText("Pulse rate (bpm)");

        jLabel7.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel7.setText("Respiration rate");

        jLabel8.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel8.setText("Blood pressure (mm Hg)");

        jLabel11.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jLabel11.setText("Doctor Advice:");

        cboxPatient.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxPatientItemStateChanged(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("--Leave your advice here--");
        jScrollPane1.setViewportView(jTextArea1);

        txtTemperature.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        txtPulse.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        txtBreath.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        txtBloodHigh.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        txtBloodLow.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N

        jLabel4.setText("-");

        btnNewDiagosis.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        btnNewDiagosis.setText("Create Diagosis");
        btnNewDiagosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDiagosisActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Monaco", 0, 8)); // NOI18N
        jLabel10.setText("Please check Patient details.");

        lblPaAge.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblPaAge.setText("Age:");

        lblPaGender.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblPaGender.setText("Gender:");

        lblPaAccount.setFont(new java.awt.Font("Monaco", 0, 12)); // NOI18N
        lblPaAccount.setText("Account:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBreath, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtBloodHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBloodLow, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator4)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblPaAge)
                                    .addGap(48, 48, 48)
                                    .addComponent(lblPaGender)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPaAccount))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboxPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnNewDiagosis)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboxPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaAge)
                    .addComponent(lblPaGender)
                    .addComponent(lblPaAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBreath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBloodHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBloodLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnNewDiagosis)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("New Diagnosis", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void readonly(){
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnMale.setEnabled(false);
        btnFemale.setEnabled(false);
        
        txtMajor.setEditable(false);
        
        txtName.setEditable(false);
        txtAge.setEditable(false);
        
    }
    
    public void showDetails(){
        readonly();
        txtName.setText(doctor.getName());
        txtAge.setText(doctor.getAge());
        txtMajor.setText(doctor.getMajor());

        if( doctor.getGender().equals("male")){
            btnMale.setSelected(true);
            btnFemale.setSelected(false);
        }
        else if( doctor.getGender().equals("female")){
            btnMale.setSelected(false);
            btnFemale.setSelected(true);
        }
        else{
            btnMale.setSelected(false);
            btnFemale.setSelected(false);
        }
   
        
        
        
//        photo_path = patient.getPhoto();
//        ImageIcon photo = new ImageIcon(new ImageIcon(photo_path).getImage().getScaledInstance(110, 130, Image.SCALE_SMOOTH));
//        lblPhoto.setIcon(photo);

    }
    
    public void editall(){
        txtName.setEditable(true);
        txtAge.setEditable(true);
        btnMale.setEnabled(true);
        btnFemale.setEnabled(true);
        btnSave.setEnabled(true);
        
        txtMajor.setEditable(true);

        
    }
    
    public void allPatient() throws SQLException{
        patients = PersonDao.allPatientName();
                
        for(Patient p : patients){
            cboxPatient.addItem(p.getName());
        }
    }
    
    public void tblEncounters() throws SQLException{
            int id = doctor.getId();
            EncountersHistory ens = EncounterDao.docEncountersHistory(id);
            if(ens==null){
                lblTitle2.setText("Don't have patient visit records yet.");
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
    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(StringUtil.isEmpty(txtAge.getText())||StringUtil.isEmpty(txtName.getText())
            || bgGender.getSelection()==null||StringUtil.isEmpty(txtMajor.getText())){
            JOptionPane.showMessageDialog(this, "Please provide all required information.");
        }else{
            try{
                doctor.setName(txtName.getText());
                doctor.setAge(txtAge.getText());
                if(btnMale.isSelected()){
                    doctor.setGender("male");
                }else
                doctor.setGender("female");
                doctor.setMajor(txtMajor.getText());

                PersonDao.updateDoctor(doctor);

                JOptionPane.showMessageDialog(this, "Successfully update information.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Update personal information failed.");
            }

        }
        // TODO add your handling code here:
        readonly();
        showDetails();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked

        editall();

        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateMouseClicked

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

    private void txtMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMajorActionPerformed

    private void cboxPatientItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxPatientItemStateChanged
        
        String selectedPatient = (String) cboxPatient.getSelectedItem();
        try {
            this.selectedPaInfo = PersonDao.selectedPaDetails(selectedPatient);
            
            lblPaAge.setText("Age: "+selectedPaInfo.get(0));
            lblPaGender.setText("Gender: "+selectedPaInfo.get(1));
            lblPaAccount.setText("Account: "+selectedPaInfo.get(2));
        } catch (SQLException ex) {
            Logger.getLogger(DoctorHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_cboxPatientItemStateChanged

    private void btnNewDiagosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDiagosisActionPerformed
        int patientId = Integer.parseInt(selectedPaInfo.get(3));
        int docId = doctor.getId();
        int hosId = doctor.getHospitalId();
        LocalDate date = LocalDate.now( ZoneId.of( "America/Montreal" ) );;
        String docAdvice = jTextArea1.getText();
        
        Encounter newEncounter = new Encounter();
        newEncounter.setPatientId(patientId);
        newEncounter.setDocId(docId);
        newEncounter.setHosId(hosId);
        newEncounter.setDate(date);
        newEncounter.setDocAdvice(docAdvice);
        
        VitalSign newVitalSign = new VitalSign();
        newVitalSign.setTemperature(txtTemperature.getText());
        newVitalSign.setPulseRate(txtPulse.getText());
        newVitalSign.setBloodPressure(txtBloodHigh.getText()+"-"+txtBloodLow.getText());
        newVitalSign.setRespirationRate(txtBreath.getText());
        
        EncounterDao.createNewEcounter(newEncounter,newVitalSign);
    }//GEN-LAST:event_btnNewDiagosisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JButton btnEncounter;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnNewDiagosis;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPaAccount;
    private javax.swing.JLabel lblPaAge;
    private javax.swing.JLabel lblPaGender;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tblEncounters;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodHigh;
    private javax.swing.JTextField txtBloodLow;
    private javax.swing.JTextField txtBreath;
    private javax.swing.JTextField txtMajor;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPulse;
    private javax.swing.JTextField txtTemperature;
    // End of variables declaration//GEN-END:variables
}
