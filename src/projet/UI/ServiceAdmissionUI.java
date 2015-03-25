/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projet.sih.*;

/**
 *
 * @author Marina
 */
public class ServiceAdmissionUI extends javax.swing.JFrame {
    //attributs
    private AjouterPatientIU apIU;
    private AjoutRdvUI ardvUI;
    private AjouterHospitalisationUI ahUI;
    private CHUPP chupp;
    private ConnexionUI connexionUI;
    private static Patient currentPatient;
    private PersonnelMedical currentPers;
    private JList1ActionPerformed jll;
    private DemandeConsHospUI dchUI;

    private DefaultListModel dlm = new DefaultListModel();
    //attribut base de donnée
    MyDBConnection connection = new MyDBConnection();

    /**
     * Creates new form ServiceCliniqueSecretaire
     */
    public ServiceAdmissionUI() throws FileNotFoundException, IOException, SQLException {
        initComponents();
        FileInputStream input = new FileInputStream("src/Images/GenesisHealthCareSolution.png");
        BufferedImage myPicture = ImageIO.read(input);
        ImageIcon image = new ImageIcon(myPicture);
        jLabel6.setIcon(image);
        jLabel6.setVisible(true);
        jll = new JList1ActionPerformed();
        jList1.addListSelectionListener(jll);
        JMenuBar jmb = new JMenuBar();
        JMenu menu1 = new JMenu("Fichier");
        JMenu menu2 = new JMenu("Aide");
        JMenuItem deco = new JMenuItem("Deconnexion");
        JMenuItem leave = new JMenuItem("Quitter");
        JMenuItem javadoc = new JMenuItem("Documentation technique");
        JMenuItem helputil = new JMenuItem("Aide utilisateur");
        menu1.add(deco);
        menu1.add(leave);
        menu2.add(javadoc);
        menu2.add(helputil);
        jmb.add(menu1);
        jmb.add(menu2);
        setJMenuBar(jmb);
        //remplissage des modèles
        jComboBoxServiceTri.setModel(CHUPP.getListeServiceClinique());
        ((DefaultComboBoxModel) jComboBoxServiceTri.getModel()).addElement("Archives");
        ((DefaultComboBoxModel) jComboBoxServiceTri.getModel()).addElement("Tous");
        ((DefaultComboBoxModel) jComboBoxServiceTri.getModel()).addElement("DMA Fermés");
        jComboBoxServiceTri.setSelectedItem("Tous");
        //on définit les actions des JMenuItem
        deco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    connexionUI = new ConnexionUI();
                } catch (IOException ex) {
                    Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
                }
                connexionUI.setLocationRelativeTo(null);
                connexionUI.setVisible(true);
                setVisible(false);
            }
        });
        leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        javadoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("dist/javadoc/index.html");
                    java.awt.Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        helputil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("src/Aide/Manuel utilisateur.odt");
                    java.awt.Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        jList1.setModel(dlm);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jButtonEditDMA = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButtonAjoutRDV = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButtonAjoutHospitalisation = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Patient = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IPP = new javax.swing.JTextField();
        AjoutPatient = new javax.swing.JButton();
        jButtonDeconnexion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTransfert = new javax.swing.JComboBox();
        jButtonTransfert = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        ListePatient = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxServiceTri = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setMinimumSize(new java.awt.Dimension(200, 102));
        jSplitPane2.setPreferredSize(new java.awt.Dimension(1278, 648));

        jTabbedPane1.setForeground(new java.awt.Color(0, 51, 153));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.setName("Prescriptions"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Observations", new javax.swing.ImageIcon(getClass().getResource("/Images/observationchecklist.png")), jPanel5); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Résultats", new javax.swing.ImageIcon(getClass().getResource("/Images/résultats-médicaux-30214840.png")), jPanel6); // NOI18N

        jButtonEditDMA.setBackground(new java.awt.Color(153, 153, 255));
        jButtonEditDMA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEditDMA.setText("Editer DMA");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(942, Short.MAX_VALUE)
                .addComponent(jButtonEditDMA)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEditDMA)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("DMA", new javax.swing.ImageIcon(getClass().getResource("/Images/img_dossier_page_sante_10061.png")), jPanel7); // NOI18N

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane7.setViewportView(jTextArea4);

        jButtonAjoutRDV.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAjoutRDV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjoutRDV.setText("+ RDV");
        jButtonAjoutRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutRDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAjoutRDV, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjoutRDV)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestion RDV", new javax.swing.ImageIcon(getClass().getResource("/Images/rdv.png")), jPanel8); // NOI18N

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane6.setViewportView(jTextArea5);

        jButtonAjoutHospitalisation.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAjoutHospitalisation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjoutHospitalisation.setText("+ Hospitalisation");
        jButtonAjoutHospitalisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutHospitalisationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAjoutHospitalisation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjoutHospitalisation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hospitalisations", new javax.swing.ImageIcon(getClass().getResource("/Images/CDT64-tfinal-Hopital.jpg")), jPanel9); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Patient : ");

        Patient.setBackground(new java.awt.Color(240, 240, 240));
        Patient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Patient.setBorder(null);
        Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("IPP : ");

        IPP.setBackground(new java.awt.Color(240, 240, 240));
        IPP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IPP.setBorder(null);
        IPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPPActionPerformed(evt);
            }
        });

        AjoutPatient.setBackground(new java.awt.Color(153, 153, 255));
        AjoutPatient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AjoutPatient.setText("+ Patient");
        AjoutPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutPatientActionPerformed(evt);
            }
        });

        jButtonDeconnexion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonDeconnexion.setForeground(new java.awt.Color(204, 0, 0));
        jButtonDeconnexion.setText("Deconnexion");
        jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tranfert du patient dans le service : ");

        jComboBoxTransfert.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTransfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTransfertActionPerformed(evt);
            }
        });

        jButtonTransfert.setBackground(new java.awt.Color(153, 153, 255));
        jButtonTransfert.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonTransfert.setText("Transférer");
        jButtonTransfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransfertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxTransfert, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonTransfert, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Patient, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IPP, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AjoutPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDeconnexion)))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(IPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeconnexion)
                    .addComponent(AjoutPatient))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTransfert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTransfert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane2.setRightComponent(jPanel1);

        jList1.setMinimumSize(new java.awt.Dimension(250, 434));
        jList1.setPreferredSize(new java.awt.Dimension(250, 434));
        jScrollPane1.setViewportView(jList1);

        ListePatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ListePatient.setForeground(new java.awt.Color(0, 51, 153));
        ListePatient.setText("Liste des patients");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Service : ");

        jComboBoxServiceTri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxServiceTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxServiceTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(ListePatient)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxServiceTri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jLabelService, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(ListePatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxServiceTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientActionPerformed

    }//GEN-LAST:event_PatientActionPerformed

    private void IPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPPActionPerformed

    private void AjoutPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutPatientActionPerformed
        //on ne peut ajouter un patient que si l'on se trouve dans la liste de tous les patients de l'hopital. 
        //Le service ou il est envoyé est demandé juste après l'ajout
        if (jComboBoxServiceTri.getSelectedItem().equals("Tous")) {
            apIU = new AjouterPatientIU();
            apIU.setVisible(true);
            apIU.setServiceAdmission(this);
            apIU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane j = new JOptionPane();
            j.showMessageDialog(null, "Veuillez sélectionner \"Tous\" dans le choix des services pour ajouter un patient.", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_AjoutPatientActionPerformed

    private void jComboBoxTransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTransfertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTransfertActionPerformed

    private void jButtonDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnexionActionPerformed
        JOptionPane j = new JOptionPane();
        int retour = j.showConfirmDialog(this, "Êtes-vous sûr de vouloir vous déconnecter ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        if (retour == JOptionPane.OK_OPTION) {
            setVisible(false);
            try {
                connexionUI = new ConnexionUI();
            } catch (IOException ex) {
                Logger.getLogger(ServiceAdmissionUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            connexionUI.setVisible(true);

        } else {
            j.setVisible(false);
        }
    }//GEN-LAST:event_jButtonDeconnexionActionPerformed

    private void jButtonAjoutRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutRDVActionPerformed
        //on vérifie qu'un patient est sélectionné pour ajouter un rdv
        if (currentPatient != null) {
            try {
                ardvUI = new AjoutRdvUI();
                ardvUI.setLocationRelativeTo(null);
                ardvUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                ardvUI.setCurrentPatient(currentPatient);
                ardvUI.setServiceAdmission(this);
                ardvUI.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ServiceAdmissionUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane j2 = new JOptionPane();
            j2.showMessageDialog(null, "Aucun patient sélectionné", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAjoutRDVActionPerformed

    private void jButtonAjoutHospitalisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutHospitalisationActionPerformed
        //on vérifie qu'un patient est sélectionné pour ajouter une hospitalisation
        if (currentPatient != null) {
            try {
                ahUI = new AjouterHospitalisationUI();
                ahUI.setCurrentPatient(currentPatient);
                ahUI.setLocationRelativeTo(null);
                ahUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                ahUI.setServiceAdmission(this);
                ahUI.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ServiceAdmissionUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane j2 = new JOptionPane();
            j2.showMessageDialog(null, "Aucun patient sélectionné", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAjoutHospitalisationActionPerformed

    private void jComboBoxServiceTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxServiceTriActionPerformed
        //on récupère le service sélectionné
        String spe = (String) ((JComboBox) evt.getSource()).getSelectedItem();
        try {
            jComboBoxTransfert.setModel(CHUPP.getListeServiceClinique());
            ((DefaultComboBoxModel) jComboBoxTransfert.getModel()).removeElement(spe);
            java.sql.Date currentDate = new Date(System.currentTimeMillis());
            //on récupère tous les patients de la base de données dans différents cas
            //lorsque les patients sont en hospitalisation
            String sqlc = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient,"
                    + "hospitalisation, practicien_hospitalier, service_clinique "
                    + "where patient.ipp=hospitalisation.ipp "
                    + "and patient.etat = 0"
                    + " and hospitalisation.idph=practicien_hospitalier.idph and"
                    + " practicien_hospitalier.specialite=service_clinique.specialite and (hospitalisation.date_sortie>='"
                    + currentDate + "' or hospitalisation.date_sortie='1111-11-11') and service_clinique.specialite='"
                    + spe + "'";
            //lorsque les patients ont un rendez vous prévus dans un service
            String sqlh = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient,"
                    + " consultation, practicien_hospitalier, service_clinique "
                    + "where patient.ipp=consultation.ipp "
                    + "and patient.etat = 0"
                    + " and consultation.idph=practicien_hospitalier.idph and"
                    + " practicien_hospitalier.specialite=service_clinique.specialite and consultation.date>='"
                    + currentDate + "' and service_clinique.specialite='"
                    + spe + "'";
            //lorsque les patients sont décédés pour les 'Archives'
            String sql2 = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient where etat = 2";
            //lorsque les patients sont présents dans l'hopital pour 'Tous'
            String sql0 = "SELECT distinct patient.nom, patient.prenom, patient.date_naissance FROM Patient where etat = 0";
            //lorsque les patients ont déjà été à l'hopital mais n'y sont pas actuellement pour 'DMA Fermés'
            String sql1 = "SELECT distinct patient.nom, patient.prenom, patient.date_naissance FROM Patient where etat = 1";

            ResultSet resultat0 = CHUPP.getRequete(sql0);
            ResultSet resultat1 = CHUPP.getRequete(sql1);
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            ResultSet resultatc = CHUPP.getRequete(sqlc);
            ResultSet resultath = CHUPP.getRequete(sqlh);

            dlm = new DefaultListModel();
            //cas de l'affichage des patients archivés
            if (spe.equals("Archives")) {
                resultat2.last();
                if (resultat2.getRow() != 0) {
                    resultat2.beforeFirst();
                    while (resultat2.next()) {
                        if (!dlm.contains(resultat2.getString("patient.nom") + " " + resultat2.getString("patient.prenom") + " / " + resultat2.getString("patient.date_naissance"))) {
                            dlm.addElement(resultat2.getString("patient.nom") + " " + resultat2.getString("patient.prenom") + " / " + resultat2.getString("patient.date_naissance"));
                        }
                        jList1.setModel(dlm);
                        repaint();
                    }
                } else {
                    jList1.setModel(new DefaultListModel());
                    repaint();
                }
            //cas de l'affichage des patients ayant un DMA mais non présents à l'hopital
            } else if (spe.equals("DMA Fermés")) {
                resultat1.last();
                if (resultat1.getRow() != 0) {
                    resultat1.beforeFirst();
                    while (resultat1.next()) {
                        if (!dlm.contains(resultat1.getString("patient.nom") + " " + resultat1.getString("patient.prenom") + " / " + resultat1.getString("patient.date_naissance"))) {
                            dlm.addElement(resultat1.getString("patient.nom") + " " + resultat1.getString("patient.prenom") + " / " + resultat1.getString("patient.date_naissance"));
                        }
                        jList1.setModel(dlm);
                        repaint();
                    }
                } else {
                    jList1.setModel(new DefaultListModel());
                    repaint();
                }
            //cas de l'affichage de tous les patients de l'hopital
            } else if (spe.equals("Tous")) {
                resultat0.last();
                if (resultat0.getRow() != 0) {
                    resultat0.beforeFirst();
                    while (resultat0.next()) {
                        if (!dlm.contains(resultat0.getString("patient.nom") + " " + resultat0.getString("patient.prenom") + " / " + resultat0.getString("patient.date_naissance"))) {
                            dlm.addElement(resultat0.getString("nom") + " " + resultat0.getString("prenom") + " / " + resultat0.getString("date_naissance"));
                        }
                        jList1.setModel(dlm);
                        repaint();
                    }
                } else {
                    jList1.setModel(new DefaultListModel());
                    repaint();
                }
            //cas de l'affichage des patients du service sélectionné dans la jComboBoxServiceTri
            } else {
                resultatc.last();
                //on cherche les patients ayant un rendez vous à venir, présents dans l'hopital
                if (resultatc.getRow() != 0) {
                    resultatc.beforeFirst();
                    while (resultatc.next()) {
                        if (!dlm.contains(resultatc.getString("patient.nom") + " " + resultatc.getString("patient.prenom") + " / " + resultatc.getString("patient.date_naissance"))) {
                            dlm.addElement(resultatc.getString("patient.nom") + " " + resultatc.getString("patient.prenom") + " / " + resultatc.getString("patient.date_naissance"));
                        }
                    }
                } else {
                    jList1.setModel(new DefaultListModel());
                    repaint();
                }
                resultath.last();
                //on cherche les patients ayant une hospitalisation en cours dans le service
                if (resultath.getRow() != 0) {
                    resultath.beforeFirst();
                    while (resultath.next()) {
                        if (!dlm.contains(resultath.getString("patient.nom") + " " + resultath.getString("patient.prenom") + " / " + resultath.getString("patient.date_naissance"))) {
                            dlm.addElement(resultath.getString("patient.nom") + " " + resultath.getString("patient.prenom") + " / " + resultath.getString("patient.date_naissance"));
                        }

                    }
                } else {
                    jList1.setModel(new DefaultListModel());
                    repaint();
                }
                jList1.setModel(dlm);
                repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmissionUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxServiceTriActionPerformed

    private void jButtonTransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransfertActionPerformed

        //on vérifie qu'un patient est selectionné avant de le transférer
        if (currentPatient != null) {
            //pour le transfert on demande si le patient doit être envoyé en consultation ou en hospitalisation
            dchUI = new DemandeConsHospUI();
            dchUI.setLocationRelativeTo(null);
            dchUI.setServiceAdmissionUI(this);
            dchUI.setServiceTransmis((String) jComboBoxTransfert.getSelectedItem());
            dchUI.setCurrentPatient(currentPatient);
            dchUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dchUI.setVisible(true);
        } else {
            JOptionPane j2 = new JOptionPane();
            j2.showMessageDialog(null, "Aucun patient sélectionné", "Attention", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonTransfertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjoutPatient;
    private javax.swing.JTextField IPP;
    private javax.swing.JLabel ListePatient;
    private javax.swing.JTextField Patient;
    private javax.swing.JButton jButtonAjoutHospitalisation;
    private javax.swing.JButton jButtonAjoutRDV;
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JButton jButtonEditDMA;
    private javax.swing.JButton jButtonTransfert;
    private javax.swing.JComboBox jComboBoxServiceTri;
    private javax.swing.JComboBox jComboBoxTransfert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chupp
     */
    public CHUPP getChupp() {
        return chupp;
    }

    /**
     * @param chupp the chupp to set
     */
    public void setChupp(CHUPP chupp) {
        this.chupp = chupp;
    }

    /**
     * @return the jLabelService
     */
    public javax.swing.JLabel getjLabelService() {
        return jLabelService;
    }

    public JList getJList1() {
        return jList1;
    }

    /**
     * @return the dlm
     */
    public DefaultListModel getDlm() {
        return dlm;
    }

    /**
     * @return the jPanel8
     */
    public javax.swing.JPanel getJPanel8() {
        return jPanel8;
    }    
    
    /**
     * @param aCurrentPatient the currentPatient to set
     */
    public static void setCurrentPatient(Patient aCurrentPatient) {
        currentPatient = aCurrentPatient;
    }

    /**
     * @param currentPers the currentPers to set
     */
    public void setCurrentPers(PersonnelMedical currentPers) {
        this.currentPers = currentPers;
    }

    public class JList1ActionPerformed implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            //on n'effectue une action que lorsqu'un nom est selectionné, pas quand on rajoute ou enlève un patient de la liste
            if (lse.getValueIsAdjusting()) {
                try {
                    ResultSet result = CHUPP.getRequete("SELECT * FROM patient");
                    while (result.next()) {
                        //en cas d'action on vérifie chaque patient
                        if (jList1.getSelectedValue().equals(result.getString("nom") + " " + result.getString("prenom") + " / " + result.getString("date_naissance"))) {
                            //le patient sélectionné devient le patient courant
                            setCurrentPatient(new Patient(result.getInt("ipp"), result.getString("nom"), result.getString("prenom"), result.getDate("date_naissance"), result.getString("sexe"), result.getString("adresse")));
                            //affichage de l'IPP du patient
                            IPP.setText(currentPatient.getIPP());
                            //affichage du nom de patient
                            Patient.setText(currentPatient.getNom());
                            //on remplis les onglets du jTabbedPane avec les informations relatives au patient sélectionné
                            jTextArea1.setText(currentPatient.getDpi().getDm().afficherObservationsPH(currentPatient));
                            jTextArea2.setText(currentPatient.getDpi().getDm().afficherResultats(currentPatient));
                            jTextArea3.setText(currentPatient.getDpi().getDma().afficherConsultations(currentPatient) + "\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••\n\n" + currentPatient.getDpi().getDma().afficherHospitalisations(currentPatient));
                            jTextArea4.setText(currentPatient.getDpi().getDm().afficherRDV(currentPatient));
                            jTextArea5.setText(currentPatient.getDpi().getDma().afficherHospitalisations(currentPatient));
                            //on place le curseur de défilement en haut
                            jTextArea1.setCaretPosition(0);
                            jTextArea2.setCaretPosition(0);
                            jTextArea3.setCaretPosition(0);
                            jTextArea4.setCaretPosition(0);
                            jTextArea5.setCaretPosition(0);
                            //on modifie la couleur d'arrière-plan
                            jTextArea1.setBackground(new Color(240, 240, 255));
                            jTextArea2.setBackground(new Color(240, 240, 255));
                            jTextArea3.setBackground(new Color(240, 240, 255));
                            jTextArea4.setBackground(new Color(240, 240, 255));
                            jTextArea5.setBackground(new Color(240, 240, 255));
                            repaint();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
