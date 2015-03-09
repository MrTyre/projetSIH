/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static projet.UI.ServiceCliniqueIU.setCurrentPatient;
import projet.sih.*;

/**
 *
 * @author Tommy
 */
public class ServiceMedicoTechniquesIU extends javax.swing.JFrame {
    private CHUPP chupp;
    private ConnexionUI connexionUI;
    private Patient currentPatient;
    
    private DefaultListModel dlm;
    //attribut base de donnée
    MyDBConnection connection = new MyDBConnection();
    private String sql;
    /**
     * Creates new form ServiceMedicoTechniquesIU
     */
    public ServiceMedicoTechniquesIU() throws FileNotFoundException, IOException {
        initComponents();
        FileInputStream input = new FileInputStream("src/Images/GenesisHealthCareSolution.png");
        BufferedImage myPicture = ImageIO.read(input);
        ImageIcon image = new ImageIcon(myPicture);
        jLabel2.setIcon(image);
        jLabel2.setVisible(true);
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
        dlm=new DefaultListModel();
        sql = "SELECT nom, prenom, date_naissance FROM Patient";
        try {
            ResultSet resultat =CHUPP.getRequete(sql);
            while(resultat.next()) {
                dlm.addElement(resultat.getString("nom") + " " + resultat.getString("prenom") + " / " + resultat.getString("date_naissance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("bla");
        }
        jListPatients.setModel(dlm);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanelLogo = new javax.swing.JPanel();
        jLabelService = new javax.swing.JLabel();
        jLabelListePatients = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPatients = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDemandesPrestations = new javax.swing.JTextArea();
        jLabelPatient1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonDeconnexion = new javax.swing.JButton();
        jLabelPatient = new javax.swing.JTextField();
        jLabelIPP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoLayout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabelService, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelListePatients.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelListePatients.setForeground(new java.awt.Color(0, 51, 153));
        jLabelListePatients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListePatients.setText("Liste des patients");

        jListPatients.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPatients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelListePatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelListePatients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jTextAreaDemandesPrestations.setEditable(false);
        jTextAreaDemandesPrestations.setColumns(20);
        jTextAreaDemandesPrestations.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextAreaDemandesPrestations.setRows(5);
        jTextAreaDemandesPrestations.setText("Demandes de prestations");
        jScrollPane2.setViewportView(jTextAreaDemandesPrestations);

        jLabelPatient1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPatient1.setText("Patient :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("IPP :");

        jButtonDeconnexion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonDeconnexion.setForeground(new java.awt.Color(204, 0, 0));
        jButtonDeconnexion.setText("Deconnexion");
        jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        jLabelPatient.setBorder(null);
        jLabelPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelPatientActionPerformed(evt);
            }
        });

        jLabelIPP.setBorder(null);
        jLabelIPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelIPPActionPerformed(evt);
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
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelPatient1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIPP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jButtonDeconnexion))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPatient1)
                            .addComponent(jLabel2)
                            .addComponent(jLabelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonDeconnexion)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabelPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelPatientActionPerformed

    }//GEN-LAST:event_jLabelPatientActionPerformed

    private void jLabelIPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelIPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelIPPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jLabelIPP;
    private javax.swing.JLabel jLabelListePatients;
    private javax.swing.JTextField jLabelPatient;
    private javax.swing.JLabel jLabelPatient1;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JList jListPatients;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextAreaDemandesPrestations;
    // End of variables declaration//GEN-END:variables

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
     * @param currentPatient the currentPatient to set
     */
    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }
    
    public class JList1ActionPerformed implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {

            try {
                ResultSet result = CHUPP.getRequete("SELECT * FROM patient");
                while (result.next()) {
                    if (jListPatients.getSelectedValue().equals(result.getString("nom") + " " + result.getString("prenom") + " / " + result.getString("date_naissance"))) {
                        setCurrentPatient(new Patient(result.getDouble("ipp"), result.getString("nom"), result.getString("prenom"), result.getDate("date_naissance"), result.getString("sexe"), result.getString("adresse")));
                        jLabelIPP.setText(currentPatient.getIPP());
                        jLabelPatient1.setText(currentPatient.getNom());
                        repaint();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
