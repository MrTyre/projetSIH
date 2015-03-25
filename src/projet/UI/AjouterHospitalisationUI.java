/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.UI;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import projet.sih.*;

/**
 *
 * @author Marina
 */
public class AjouterHospitalisationUI extends javax.swing.JFrame {

    //attributs
    private ServiceAdmissionUI serviceAdmission;
    private Patient currentPatient;
    private PH medecinConcerne;
    private String serviceConcerne;
    private DefaultComboBoxModel dcbm;
    private DefaultListModel<PH> dlm;
    private ServiceCliniqueIU scUI;

    /**
     * Creates new form AjouterHospitalisation
     */
    public AjouterHospitalisationUI() throws SQLException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        //on définit le modèles de la jComboBox
        jComboBoxService.setModel(CHUPP.getListeServiceClinique());
        jComboBoxService.setSelectedIndex(0);
        //tant que l'utilisateur n'a pas coché "date de sortie connue", ces champs ne s'affichent pas
        jLabelDateHosp.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jTextFieldJour.setVisible(false);
        jTextFieldMois.setVisible(false);
        jTextFieldAnnee.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNouveauRDV = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jComboBoxService = new javax.swing.JComboBox();
        jButtonOK = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNatureHospitalisation = new javax.swing.JTextField();
        jLabelDateHosp = new javax.swing.JLabel();
        jTextFieldJour = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMois = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAnnee = new javax.swing.JTextField();
        jLabelMedecin = new javax.swing.JLabel();
        jComboBoxMedecin = new javax.swing.JComboBox();
        jCheckBoxDateSortie = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(267, 244));

        jLabelNouveauRDV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNouveauRDV.setForeground(new java.awt.Color(0, 51, 153));
        jLabelNouveauRDV.setText("Nouvelle hospitalisation");

        jLabelService.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelService.setText("Service : ");

        jComboBoxService.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxServiceActionPerformed(evt);
            }
        });

        jButtonOK.setBackground(new java.awt.Color(153, 153, 255));
        jButtonOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonAnnuler.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAnnuler.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Raison du séjour :");

        jTextFieldNatureHospitalisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNatureHospitalisationActionPerformed(evt);
            }
        });

        jLabelDateHosp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDateHosp.setText("Date de sortie : ");

        jTextFieldJour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJourActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("/");

        jTextFieldMois.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMoisActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("/");

        jTextFieldAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnneeActionPerformed(evt);
            }
        });

        jLabelMedecin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMedecin.setText("Médecin :");

        jComboBoxMedecin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMedecinActionPerformed(evt);
            }
        });

        jCheckBoxDateSortie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxDateSortie.setText("    Date de sortie connue");
        jCheckBoxDateSortie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDateSortieActionPerformed(evt);
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
                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 139, Short.MAX_VALUE)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelService)
                            .addComponent(jLabelMedecin))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMedecin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxService, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNatureHospitalisation))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNouveauRDV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDateHosp)
                                .addGap(25, 25, 25)
                                .addComponent(jTextFieldJour, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldMois, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBoxDateSortie))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNouveauRDV)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelService)
                    .addComponent(jComboBoxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMedecin)
                    .addComponent(jComboBoxMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jCheckBoxDateSortie)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateHosp)
                    .addComponent(jTextFieldJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNatureHospitalisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonOK))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxServiceActionPerformed
        //on récupère le service sélectionné
        serviceConcerne = (String) getjComboBoxService().getSelectedItem();
        try {
            //on affiche les praticiens du service
            String sql = "select * from practicien_hospitalier where specialite='" + serviceConcerne + "'";
            ResultSet resultat = CHUPP.getRequete(sql);
            dcbm = new DefaultComboBoxModel();
            dlm = new DefaultListModel<>();
            while (resultat.next()) {
                //on remplit les modèles
                medecinConcerne = new PH(resultat.getString("idph"), resultat.getString("nom"), resultat.getString("prenom"));
                dlm.addElement(medecinConcerne);
                dcbm.addElement(medecinConcerne.getNom() + " " + medecinConcerne.getPrenom());
            }
            jComboBoxMedecin.setModel(dcbm);
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxServiceActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        JOptionPane j = new JOptionPane();
        int retour = j.showConfirmDialog(this, "Êtes-vous sûr de vouloir ajouter cette hospitalisation ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        if (retour == JOptionPane.OK_OPTION) {
            try {
                ajouterHospitalisation();
                serviceAdmission.revalidate();
                serviceAdmission.repaint();
            } catch (SQLException ex) {
                Logger.getLogger(AjouterHospitalisationUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            j.setVisible(false);
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldNatureHospitalisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNatureHospitalisationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNatureHospitalisationActionPerformed

    private void jTextFieldAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnneeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnneeActionPerformed

    private void jTextFieldMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMoisActionPerformed

    private void jTextFieldJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJourActionPerformed

    private void jComboBoxMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMedecinActionPerformed
        for (int i = 0; i < dlm.size(); i++) {
            if ((dlm.get(i).getNom() + " " + dlm.get(i).getPrenom()).equals((String) ((JComboBox) evt.getSource()).getSelectedItem())) {
                medecinConcerne = dlm.get(i);
            }
        }
    }//GEN-LAST:event_jComboBoxMedecinActionPerformed

    private void jCheckBoxDateSortieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDateSortieActionPerformed
        if (jCheckBoxDateSortie.isSelected()) {
            //affichae des champs dans la cas ou la date de sortie est connue
            jLabelDateHosp.setVisible(true);
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jTextFieldJour.setVisible(true);
            jTextFieldMois.setVisible(true);
            jTextFieldAnnee.setVisible(true);
        } else {
            jLabelDateHosp.setVisible(false);
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jTextFieldJour.setVisible(false);
            jTextFieldMois.setVisible(false);
            jTextFieldAnnee.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxDateSortieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxDateSortie;
    private javax.swing.JComboBox jComboBoxMedecin;
    private javax.swing.JComboBox jComboBoxService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDateHosp;
    private javax.swing.JLabel jLabelMedecin;
    private javax.swing.JLabel jLabelNouveauRDV;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAnnee;
    private javax.swing.JTextField jTextFieldJour;
    private javax.swing.JTextField jTextFieldMois;
    private javax.swing.JTextField jTextFieldNatureHospitalisation;
    // End of variables declaration//GEN-END:variables

    public void ajouterHospitalisation() throws SQLException {
        String sql = "";
        //récupération date système
        Date d = new Date(System.currentTimeMillis());
        String date_debut = (d.getYear() + 1900) + "-" + (d.getMonth() + 1) + "-" + d.getDate();
        //cas ou la date de sortie est connue
        if (jCheckBoxDateSortie.isSelected()) {
            //on récupère les infos utilisateur
            String date_fin = jTextFieldAnnee.getText() + "-" + jTextFieldMois.getText() + "-" + jTextFieldJour.getText();
            int jour = Integer.parseInt(jTextFieldJour.getText());
            int mois = Integer.parseInt(jTextFieldMois.getText());
            int annee = Integer.parseInt(jTextFieldAnnee.getText());
            //on vérifie que la date entrée par l'utilisateur est correcte
            if ((jour > 31)
                    || (mois > 12)
                    || (annee < d.getYear() + 1900)
                    || ((annee == d.getYear() + 1900) && (mois < d.getMonth() + 1))
                    || ((annee == d.getYear() + 1900) && (mois == d.getMonth() + 1) && (jour < d.getDate()))) {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Attention, la date n'est pas correcte", "Attention", JOptionPane.WARNING_MESSAGE);
                jTextFieldJour.setText("");
                jTextFieldMois.setText("");
                jTextFieldAnnee.setText("");
                jTextFieldNatureHospitalisation.setText("");
                //on vérifie que tous les champs nécessaires sont remplis
            } else if ((jTextFieldJour.getText().equals(""))
                    || (jTextFieldMois.getText().equals(""))
                    || (jTextFieldAnnee.getText().equals(""))
                    || (jTextFieldNatureHospitalisation.getText().equals(""))) {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Il manque des informations relatives à l'hospitalisation", "Attention", JOptionPane.WARNING_MESSAGE);
                jTextFieldJour.setText("");
                jTextFieldMois.setText("");
                jTextFieldAnnee.setText("");
                jTextFieldNatureHospitalisation.setText("");
                //on ajoute l'hospitalisation
            } else {
                sql = "INSERT INTO hospitalisation values ("
                        + Hospitalisation.getIDHosp() + ","
                        + medecinConcerne.getID()
                        + "," + currentPatient.getIPP()
                        + ",'" + date_debut + "','"
                        + jTextFieldNatureHospitalisation.getText().replaceAll("'", "''")
                        + "','" + date_fin + "')";
                CHUPP.getInsert(sql);
                JOptionPane j = new JOptionPane();
                j.showMessageDialog(null, "Sejour confirmé !", "Hospitalisation", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            }
            //cas ou la date de fin n'est pas connue
        } else {
            //formalisation pour la base de données
            String date_fin = "1111-11-11";
            //on vérifie la complétion des champs
            if ((jTextFieldNatureHospitalisation.getText().equals(""))) {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Il manque des informations relatives à l'hospitalisation", "Attention", JOptionPane.WARNING_MESSAGE);;
                jTextFieldNatureHospitalisation.setText("");
                //on ajoute l'hospitalisation
            } else {
                sql = "INSERT INTO hospitalisation values ("
                        + Hospitalisation.getIDHosp() + ","
                        + medecinConcerne.getID()
                        + "," + currentPatient.getIPP()
                        + ",'" + date_debut + "','"
                        + jTextFieldNatureHospitalisation.getText().replaceAll("'", "''")
                        + "','" + date_fin + "')";
                CHUPP.getInsert(sql);
                JOptionPane j = new JOptionPane();
                j.showMessageDialog(null, "Sejour confirmé !", "Hospitalisation", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                //on réactualise l'affichage si la demande vient d'un service clinique
                if (scUI != null) {
                    scUI.getjTextArea3().setText(currentPatient.getDpi().getDma().afficherConsultations(currentPatient) + "\n\n••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••\n\n" + currentPatient.getDpi().getDma().afficherHospitalisations(currentPatient));
                    scUI.revalidate();
                    scUI.repaint();
                }
            }
        }
    }

    /**
     * @param currentPatient the currentPatient to set
     */
    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    /**
     * @param serviceAdmission the serviceAdmission to set
     */
    public void setServiceAdmission(ServiceAdmissionUI serviceAdmission) {
        this.serviceAdmission = serviceAdmission;
    }

    /**
     * @return the jComboBoxService
     */
    public javax.swing.JComboBox getjComboBoxService() {
        return jComboBoxService;
    }
}
