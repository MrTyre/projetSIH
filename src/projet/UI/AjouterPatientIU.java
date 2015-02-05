/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import projet.sih.*;

/**
 *
 * @author Tommy
 */
public class AjouterPatientIU extends javax.swing.JFrame {

    private CHUPP chupp;
    private Pays pays;
    private Sexe sexe;

    /**
     * Creates new form AjouterPatientIU
     */
    public AjouterPatientIU() {
        initComponents();
        setLocationRelativeTo(getParent());
        setVisible(true);
        jComboBoxPays.setModel((new DefaultComboBoxModel<>(Pays.values())));
        jComboBoxPays.setSelectedIndex(73);
        jComboBoxSexe.setModel((new DefaultComboBoxModel<>(Sexe.values())));
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
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelSexe = new javax.swing.JLabel();
        jLabelDateDeNaissance = new javax.swing.JLabel();
        jLabelAdresse = new javax.swing.JLabel();
        jTextFieldNomNewPatient = new javax.swing.JTextField();
        jTextFieldPrenomNewPatient = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabelNouveauPatient = new javax.swing.JLabel();
        jTextFieldAdresseNewPatient = new javax.swing.JTextField();
        jTextFieldCodePostalNewPatient = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldVilleNewPatient = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPays = new javax.swing.JComboBox();
        jTextFieldDateNaissJour = new javax.swing.JTextField();
        jTextFieldDateNaissMois = new javax.swing.JTextField();
        jTextFieldDateNaissAnnee = new javax.swing.JTextField();
        jComboBoxSexe = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNom.setText("Nom :");

        jLabelPrenom.setText("Prénom :");

        jLabelSexe.setText("Sexe :");

        jLabelDateDeNaissance.setText("Date de naissance :");

        jLabelAdresse.setText("Adresse :");

        jTextFieldNomNewPatient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNomNewPatient.setText(" ");
        jTextFieldNomNewPatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldPrenomNewPatient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldPrenomNewPatient.setText(" ");
        jTextFieldPrenomNewPatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldPrenomNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrenomNewPatientActionPerformed(evt);
            }
        });

        jButtonOK.setBackground(new java.awt.Color(0, 51, 153));
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonAnnuler.setBackground(new java.awt.Color(0, 51, 153));
        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabelNouveauPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNouveauPatient.setForeground(new java.awt.Color(0, 51, 153));
        jLabelNouveauPatient.setText("Nouveau Patient");

        jTextFieldAdresseNewPatient.setText(" ");

        jTextFieldCodePostalNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodePostalNewPatientActionPerformed(evt);
            }
        });

        jLabel1.setText("Code postal :");

        jLabel2.setText("Ville : ");

        jLabel3.setText("PAYS : ");

        jComboBoxPays.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPaysActionPerformed(evt);
            }
        });

        jTextFieldDateNaissJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateNaissJourActionPerformed(evt);
            }
        });

        jTextFieldDateNaissMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateNaissMoisActionPerformed(evt);
            }
        });

        jTextFieldDateNaissAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateNaissAnneeActionPerformed(evt);
            }
        });

        jComboBoxSexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexeActionPerformed(evt);
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
                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSexe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelNouveauPatient)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelNom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNomNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldVilleNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelAdresse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAdresseNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelDateDeNaissance)
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextFieldDateNaissJour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextFieldDateNaissMois, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextFieldDateNaissAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelPrenom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPrenomNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCodePostalNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNouveauPatient)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrenom)
                    .addComponent(jTextFieldPrenomNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexe)
                    .addComponent(jComboBoxSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDateDeNaissance)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDateNaissJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDateNaissMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDateNaissAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresse)
                    .addComponent(jTextFieldAdresseNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCodePostalNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVilleNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPrenomNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrenomNewPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrenomNewPatientActionPerformed

    private void jTextFieldCodePostalNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodePostalNewPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodePostalNewPatientActionPerformed

    private void jTextFieldDateNaissJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissJourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateNaissJourActionPerformed

    private void jTextFieldDateNaissAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissAnneeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateNaissAnneeActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        ajouterPatient();
        setVisible(false);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jComboBoxPaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPaysActionPerformed
        pays = (Pays) ((JComboBox) evt.getSource()).getSelectedItem();
    }//GEN-LAST:event_jComboBoxPaysActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldDateNaissMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissMoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateNaissMoisActionPerformed

    private void jComboBoxSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexeActionPerformed
        sexe = (Sexe) ((JComboBox) evt.getSource()).getSelectedItem();
    }//GEN-LAST:event_jComboBoxSexeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxPays;
    private javax.swing.JComboBox jComboBoxSexe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelDateDeNaissance;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNouveauPatient;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelSexe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAdresseNewPatient;
    private javax.swing.JTextField jTextFieldCodePostalNewPatient;
    private javax.swing.JTextField jTextFieldDateNaissAnnee;
    private javax.swing.JTextField jTextFieldDateNaissJour;
    private javax.swing.JTextField jTextFieldDateNaissMois;
    private javax.swing.JTextField jTextFieldNomNewPatient;
    private javax.swing.JTextField jTextFieldPrenomNewPatient;
    private javax.swing.JTextField jTextFieldVilleNewPatient;
    // End of variables declaration//GEN-END:variables

    public void ajouterPatient() {
        if ((jTextFieldNomNewPatient.getText().equals(""))
                || (jTextFieldPrenomNewPatient.getText().equals(""))
                || (jTextFieldAdresseNewPatient.getText().equals(""))
                || (jTextFieldCodePostalNewPatient.getText().equals(""))
                || (jTextFieldVilleNewPatient.getText().equals(""))
                || (jTextFieldDateNaissJour.getText().equals(""))
                || (jTextFieldDateNaissMois.getText().equals(""))
                || (jTextFieldDateNaissAnnee.getText().equals(""))) {
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Il manque des informations relatives au patient", "Attention", JOptionPane.WARNING_MESSAGE);
        }
        
        if((jTextFieldCodePostalNewPatient.getText().length() != 5) && !(jTextFieldCodePostalNewPatient.getText().equals(""))){
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null,"Mauvais code postal","Attention",JOptionPane.WARNING_MESSAGE);
        }
        
        String nom = jTextFieldNomNewPatient.getText();
        String prenom = jTextFieldPrenomNewPatient.getText();
        Date d = new Date(Integer.parseInt(jTextFieldDateNaissJour.getText()), Integer.parseInt(jTextFieldDateNaissMois.getText()), Integer.parseInt(jTextFieldDateNaissAnnee.getText()));
        Adresse adresse = new Adresse(jTextFieldAdresseNewPatient.getText(), Integer.parseInt(jTextFieldCodePostalNewPatient.getText()), jTextFieldVilleNewPatient.getText(), pays);
        Patient p = new Patient(nom, prenom, d, sexe, adresse);
        //ajouter le patient à la BD !!
    }

    /**
     * @param chupp the chupp to set
     */
    public void setChupp(CHUPP chupp) {
        this.chupp = chupp;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }
}
