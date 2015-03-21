package projet.UI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import projet.sih.*;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Tommy
 */
public class ServiceCliniqueIU extends javax.swing.JFrame {

    /**
     * @param aCurrentPatient the currentPatient to set
     */
    public static void setCurrentPatient(Patient aCurrentPatient) {
        currentPatient = aCurrentPatient;
    }

    private CHUPP chupp;
    private String directory;
    private DemandePrestationUI dpUI;
    private AjouterPrescriptionIU aprIU;
    private DefaultListModel dlm = new DefaultListModel();
    private JList1ActionPerformed jll;
    private ConnexionUI connexionUI;
    private LettreSortieUI lettreSortieUI;
    private static Patient currentPatient;
    private PersonnelMedical currentPH;

    private String sql;

    public ServiceCliniqueIU() throws FileNotFoundException, IOException {
        initComponents();
        setTitle("Bienvenue dans Genesis HealthCare Solutions");
        FileInputStream input = new FileInputStream("src/Images/GenesisHealthCareSolution.png");
        BufferedImage myPicture = ImageIO.read(input);
        ImageIcon image = new ImageIcon(myPicture);
        jLabel2.setIcon(image);
        System.out.println(ConnexionUI.getCurrentConnected().getSpecialite());
        jLabel2.setVisible(true);
        jll = new JList1ActionPerformed();
        jList1.addListSelectionListener(jll);
        JMenuBar jmb = new JMenuBar();
        JMenu menu1 = new JMenu("Fichier");
        JMenu menu2 = new JMenu("Aide");
        JMenuItem deco = new JMenuItem("Deconnexion");
        JMenuItem leave = new JMenuItem("Quitter");
        JMenuItem letterDirectory = new JMenuItem("Spécifier le dossier de stockage des lettres de sorties");
        JMenuItem javadoc = new JMenuItem("Documentation technique");
        JMenuItem helputil = new JMenuItem("Aide utilisateur");
        menu1.add(deco);
        menu1.add(leave);
        menu2.add(letterDirectory);
        menu2.add(javadoc);
        menu2.add(helputil);
        jmb.add(menu1);
        jmb.add(menu2);
        setJMenuBar(jmb);
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
        directory = "";
        letterDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    directory = chooser.getSelectedFile().getPath();
                }
                String update = "update pracitien_hospitaliser set accesslettre='" + directory + "' where nom='" + currentPH.getNom() + "' and prenom='" + currentPH.getPrenom() + "'";
                try {
                    CHUPP.getInsert(update);
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        java.sql.Date currentDate = new Date(System.currentTimeMillis());
        String currentDateString = currentDate.toString();
        sql = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient,"
                + "hospitalisation, practicien_hospitalier, service_clinique "
                + "where patient.ipp=hospitalisation.ipp "
                + "and patient.etat = 0"
                + " and hospitalisation.idph=practicien_hospitalier.idph and"
                + " practicien_hospitalier.specialite=service_clinique.specialite and hospitalisation.date_sortie>='"
                + currentDate + "' and service_clinique.specialite='"
                + ConnexionUI.getCurrentConnected().getSpecialite() + "'";
        String sql2 = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient,"
                + " consultation, practicien_hospitalier, service_clinique "
                + "where patient.ipp=consultation.ipp "
                + "and patient.etat = 0"
                + " and consultation.idph=practicien_hospitalier.idph and"
                + " practicien_hospitalier.specialite=service_clinique.specialite and consultation.date>='"
                + currentDate + "' and service_clinique.specialite='"
                + ConnexionUI.getCurrentConnected().getSpecialite() + "'";

        try {
            ResultSet resultat = CHUPP.getRequete(sql);
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            while (resultat.next()) {
                if (!dlm.contains(resultat.getString("patient.nom") + " " + resultat.getString("patient.prenom") + " / " + resultat.getString("patient.date_naissance"))) {
                    dlm.addElement(resultat.getString("patient.nom") + " " + resultat.getString("patient.prenom") + " / " + resultat.getString("patient.date_naissance"));
                }
            }
            while (resultat2.next()) {
                if (!dlm.contains(resultat2.getString("patient.nom") + " " + resultat2.getString("patient.prenom") + " / " + resultat2.getString("patient.date_naissance"))) {
                    dlm.addElement(resultat2.getString("patient.nom") + " " + resultat2.getString("patient.prenom") + " / " + resultat2.getString("patient.date_naissance"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
        }
        jList1.setModel(dlm);
        repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonAjouterPrescriptions = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonAjouterObservation = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabelPatient = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelIPP = new javax.swing.JTextField();
        jButtonDeconnexion = new javax.swing.JButton();
        jButtonSortiePatient = new javax.swing.JButton();
        jButtonDemandePrestation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        ListePatient = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setMinimumSize(new java.awt.Dimension(200, 102));
        jSplitPane2.setPreferredSize(new java.awt.Dimension(701, 750));

        jTabbedPane1.setForeground(new java.awt.Color(0, 51, 153));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.setName("Prescriptions"); // NOI18N

        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 621));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButtonAjouterPrescriptions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjouterPrescriptions.setForeground(new java.awt.Color(0, 51, 153));
        jButtonAjouterPrescriptions.setText("+ Prescription");
        jButtonAjouterPrescriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterPrescriptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAjouterPrescriptions))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAjouterPrescriptions)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prescriptions", new javax.swing.ImageIcon(getClass().getResource("/Images/prescriptions.png")), jPanel4); // NOI18N

        jButtonAjouterObservation.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAjouterObservation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjouterObservation.setText("+ Observation");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(917, Short.MAX_VALUE)
                .addComponent(jButtonAjouterObservation)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjouterObservation)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Observations", new javax.swing.ImageIcon(getClass().getResource("/Images/observationchecklist.png")), jPanel5); // NOI18N

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Résultats", new javax.swing.ImageIcon(getClass().getResource("/Images/résultats-médicaux-30214840.png")), jPanel6); // NOI18N

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("DMA", new javax.swing.ImageIcon(getClass().getResource("/Images/img_dossier_page_sante_10061.png")), jPanel7); // NOI18N

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RDV", new javax.swing.ImageIcon(getClass().getResource("/Images/rdv.png")), jPanel8); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Patient : ");

        jLabelPatient.setBorder(null);
        jLabelPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelPatientActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("IPP : ");

        jLabelIPP.setBorder(null);
        jLabelIPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelIPPActionPerformed(evt);
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

        jButtonSortiePatient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSortiePatient.setForeground(new java.awt.Color(0, 51, 153));
        jButtonSortiePatient.setText("Sortie du patient");
        jButtonSortiePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortiePatientActionPerformed(evt);
            }
        });

        jButtonDemandePrestation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonDemandePrestation.setForeground(new java.awt.Color(0, 51, 153));
        jButtonDemandePrestation.setText("Demander une prestation");
        jButtonDemandePrestation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDemandePrestationActionPerformed(evt);
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
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIPP, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDemandePrestation)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonSortiePatient)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonDeconnexion)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelIPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDemandePrestation))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonDeconnexion)
                            .addComponent(jButtonSortiePatient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jSplitPane2.setRightComponent(jPanel1);

        jList1.setMinimumSize(new java.awt.Dimension(250, 434));
        jList1.setPreferredSize(new java.awt.Dimension(250, 434));
        jScrollPane1.setViewportView(jList1);

        ListePatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ListePatient.setForeground(new java.awt.Color(0, 51, 153));
        ListePatient.setText("Liste des patients");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(ListePatient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelService, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListePatient)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelPatientActionPerformed

    }//GEN-LAST:event_jLabelPatientActionPerformed

    private void jLabelIPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelIPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelIPPActionPerformed

    private void jButtonDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnexionActionPerformed
        JOptionPane j = new JOptionPane();
        int retour = j.showConfirmDialog(this, "Êtes-vous sûr de vouloir vous déconnecter ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        if (retour == JOptionPane.OK_OPTION) {
            setVisible(false);
            try {
                connexionUI = new ConnexionUI();
            } catch (IOException ex) {
                Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
            }
            connexionUI.setVisible(true);

        } else {
            j.setVisible(false);
        }
    }//GEN-LAST:event_jButtonDeconnexionActionPerformed

    private void jButtonSortiePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortiePatientActionPerformed
        lettreSortieUI = new LettreSortieUI();
        lettreSortieUI.getjLabelPatient().setText(currentPatient.getNom() + " " + currentPatient.getPrenom());
        lettreSortieUI.getjLabelMedecin().setText("Dr. " + currentPH.getNom() + " " + currentPH.getPrenom());
        lettreSortieUI.setCurrentPatient(currentPatient);
        lettreSortieUI.setCurrentPH(currentPH);
        lettreSortieUI.setScIU(this);
        lettreSortieUI.setLocationRelativeTo(null);
        lettreSortieUI.setVisible(true);
    }//GEN-LAST:event_jButtonSortiePatientActionPerformed

    private void jButtonDemandePrestationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDemandePrestationActionPerformed
        try {
            dpUI = new DemandePrestationUI();
            dpUI.setLocationRelativeTo(null);
            dpUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dpUI.setCurrentPatient(currentPatient);
            dpUI.setCurrentConnected(currentPH);
            dpUI.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDemandePrestationActionPerformed

    private void jButtonAjouterPrescriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterPrescriptionsActionPerformed
        aprIU = new AjouterPrescriptionIU();
        aprIU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aprIU.setCurrentPatient(currentPatient);
        aprIU.setScUI(this);
        aprIU.setLocationRelativeTo(null);
        aprIU.setVisible(true);
    }//GEN-LAST:event_jButtonAjouterPrescriptionsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ListePatient;
    private javax.swing.JButton jButtonAjouterObservation;
    private javax.swing.JButton jButtonAjouterPrescriptions;
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JButton jButtonDemandePrestation;
    private javax.swing.JButton jButtonSortiePatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jLabelIPP;
    private javax.swing.JTextField jLabelPatient;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    // End of variables declaration//GEN-END:variables

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

    /**
     * @param currentPH the currentPH to set
     */
    public void setCurrentPH(PersonnelMedical currentPH) {
        this.currentPH = currentPH;
    }

    /**
     * @return the jTabbedPane1
     */
    public javax.swing.JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    /**
     * @return the dlm
     */
    public DefaultListModel getDlm() {
        return dlm;
    }

    /**
     * @return the jList1
     */
    public javax.swing.JList getjList1() {
        return jList1;
    }

    /**
     * @return the jLabelIPP
     */
    public javax.swing.JTextField getjLabelIPP() {
        return jLabelIPP;
    }

    /**
     * @return the jLabelPatient
     */
    public javax.swing.JTextField getjLabelPatient() {
        return jLabelPatient;
    }

    public class JList1ActionPerformed implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (lse.getValueIsAdjusting()) {
                try {
                    ResultSet result = CHUPP.getRequete("SELECT * FROM patient");
                    while (result.next()) {
                        if (getjList1().getSelectedValue().equals(result.getString("nom") + " " + result.getString("prenom") + " / " + result.getString("date_naissance"))) {
                            setCurrentPatient(new Patient(result.getDouble("ipp"), result.getString("nom"), result.getString("prenom"), result.getDate("date_naissance"), result.getString("sexe"), result.getString("adresse"), result.getString("medecin_generaliste"), result.getString("adresse_med_gen")));
                            getjLabelIPP().setText(currentPatient.getIPP());
                            getjLabelPatient().setText(currentPatient.getNom());
                            jTextArea1.setText(currentPatient.getDpi().getDm().afficherPrescriptions(currentPatient));
                            jTextArea2.setText(currentPatient.getDpi().getDm().afficherObservationsPH(currentPatient));
                            jTextArea3.setText(currentPatient.getDpi().getDma().afficherConsultations(currentPatient) + "\n\n•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••\n\n" + currentPatient.getDpi().getDma().afficherHospitalisations(currentPatient));
                            jTextArea4.setText(currentPatient.getDpi().getDm().afficherRDV(currentPatient));
                            jTextArea5.setText(currentPatient.getDpi().getDm().afficherResultats(currentPatient));
                            jTextArea1.setCaretPosition(0);
                            jTextArea2.setCaretPosition(0);
                            jTextArea3.setCaretPosition(0);
                            jTextArea4.setCaretPosition(0);
                            jTextArea5.setCaretPosition(0);
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
