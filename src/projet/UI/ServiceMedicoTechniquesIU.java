package projet.UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
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
    private PersonnelMedical currentConnected;
    private ResultatPrestationLaboIU rplaUI;
    private ResultatPrestationRadiologieIU rprUI;

    private DefaultListModel dlm;
    //attribut base de donnée
    MyDBConnection connection = new MyDBConnection();
    private String sql;
    private JList1ActionPerformed jll;
    private DefaultTableModel dtm;

    /**
     * Creates new form ServiceMedicoTechniquesIU
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ServiceMedicoTechniquesIU() throws FileNotFoundException, IOException {
        initComponents();
        FileInputStream input = new FileInputStream("src/Images/GenesisHealthCareSolution.png");
        BufferedImage myPicture = ImageIO.read(input);
        ImageIcon image = new ImageIcon(myPicture);
        jLabel1.setIcon(image);
        jLabel1.setVisible(true);
        jll = new JList1ActionPerformed();
        jListPatients.addListSelectionListener(jll);
        dtm = new DefaultTableModel(0, 0);
        getjTablePrestations().setModel(dtm);
        dtm.addColumn("ID PH");
        dtm.addColumn("Service demandeur");
        dtm.addColumn("Date");
        dtm.addColumn("Nature de la demande");
        dtm.addColumn("Résultat");
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
        dlm = new DefaultListModel();
        String sql = "select DISTINCT patient.nom, patient.prenom, patient.date_naissance from patient,"
                + "prestation, service_medico_technique "
                + "where patient.ipp=prestation.ipp "
                + " and prestation.service_destinataire=service_medico_technique.specialite and"
                + " prestation.etat=0"
                + " and service_medico_technique.specialite='"
                + ConnexionUI.getCurrentConnected().getSpecialite() + "'";

        try {
            ResultSet resultat = CHUPP.getRequete(sql);
            while (resultat.next()) {

                dlm.addElement(resultat.getString("patient.nom") + " " + resultat.getString("patient.prenom") + " / " + resultat.getString("patient.date_naissance"));

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
        jLabelListePatients = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPatients = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelPatient4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonDeconnexion3 = new javax.swing.JButton();
        jLabelCurrentPatient3 = new javax.swing.JLabel();
        jLabelIPP3 = new javax.swing.JLabel();
        jLabelDemandePrestation = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePrestations = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1095, 644));

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 620));

        jLabelListePatients.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelListePatients.setForeground(new java.awt.Color(0, 51, 153));
        jLabelListePatients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListePatients.setText("Liste des patients");

        jListPatients.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListPatients.setMinimumSize(new java.awt.Dimension(100, 85));
        jScrollPane1.setViewportView(jListPatients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelListePatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabelService, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelListePatients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabelPatient4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPatient4.setText("Patient :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("IPP :");

        jButtonDeconnexion3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonDeconnexion3.setForeground(new java.awt.Color(204, 0, 0));
        jButtonDeconnexion3.setText("Deconnexion");
        jButtonDeconnexion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        jLabelDemandePrestation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDemandePrestation.setText("Demandes de prestations :");

        jTablePrestations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTablePrestations.setRowHeight(80);
        jScrollPane5.setViewportView(jTablePrestations);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDemandePrestation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelPatient4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCurrentPatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIPP3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                        .addComponent(jButtonDeconnexion3)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonDeconnexion3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIPP3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelPatient4)
                                .addComponent(jLabel5)
                                .addComponent(jLabelCurrentPatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(57, 57, 57)
                .addComponent(jLabelDemandePrestation, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeconnexion3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCurrentPatient3;
    private javax.swing.JLabel jLabelDemandePrestation;
    private javax.swing.JLabel jLabelIPP3;
    private javax.swing.JLabel jLabelListePatients;
    private javax.swing.JLabel jLabelPatient4;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JList jListPatients;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTablePrestations;
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
     * @param currentConnected the currentConnected to set
     */
    public void setCurrentConnected(PersonnelMedical currentConnected) {
        this.currentConnected = currentConnected;
    }

    /**
     * @param currentPatient the currentPatient to set
     */
    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    /**
     * @return the dlm
     */
    public DefaultListModel getDlm() {
        return dlm;
    }

    /**
     * @param dlm the dlm to set
     */
    public void setDlm(DefaultListModel dlm) {
        this.dlm = dlm;
    }

    public ServiceMedicoTechniquesIU getLocalInstance() {
        return this;
    }

    /**
     * @return the jListPatients
     */
    public javax.swing.JList getjListPatients() {
        return jListPatients;
    }

    /**
     * @return the jTablePrestations
     */
    public javax.swing.JTable getjTablePrestations() {
        return jTablePrestations;
    }

    public class JList1ActionPerformed implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent lse) {

            try {
                String sql2 = "select DISTINCT patient.* from patient,"
                        + "prestation, service_medico_technique "
                        + "where patient.ipp=prestation.ipp "
                        + " and prestation.service_destinataire=service_medico_technique.specialite and"
                        + " prestation.etat=0"
                        + " and service_medico_technique.specialite='"
                        + ConnexionUI.getCurrentConnected().getSpecialite() + "'";
                ResultSet result = CHUPP.getRequete(sql2);
                while (result.next()) {
                    if (getjListPatients().getSelectedValue().equals(result.getString("nom") + " " + result.getString("prenom") + " / " + result.getString("date_naissance"))) {
                        setCurrentPatient(new Patient(result.getDouble("ipp"), result.getString("nom"), result.getString("prenom"), result.getDate("date_naissance"), result.getString("sexe"), result.getString("adresse")));
                        jLabelIPP3.setText(currentPatient.getIPP());
                        jLabelCurrentPatient3.setText(currentPatient.getNom());
                        repaint();

                        ResultSet result2 = CHUPP.getRequete("SELECT DISTINCT * FROM prestation WHERE ipp =" + currentPatient.getIPP() + " and etat=0");
                        result2.last();
                        if (result2.getRow() != 0) {
                            result2.beforeFirst();
                            dtm = new DefaultTableModel() {

                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    if (column == 4) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            };
                            dtm.addColumn("ID PH");
                            dtm.addColumn("Service demandeur");
                            dtm.addColumn("Date");
                            dtm.addColumn("Nature de la demande");
                            dtm.addColumn("Résultat");
                            while (result2.next()) {
                                if (result2.getString("service_destinataire").equals("Radiologie")) {
                                    ResultSet result3 = CHUPP.getRequete("SELECT DISTINCT practicien_hospitalier.specialite FROM practicien_hospitalier WHERE idph=" + result2.getInt("idph"));
                                    result3.last();
                                    dtm.addRow(new Object[]{result2.getInt("idph"), result3.getString("practicien_hospitalier.specialite"), result2.getDate("date"), result2.getString("nature_prestation"), "Envoyer"});
                                    final String naturePrestation = result2.getString("nature_prestation");
                                    final Date date = result2.getDate("date");
                                    final int idprestation = result2.getInt("idprestation");
                                    getjTablePrestations().setModel(dtm);
                                    Action delete = new AbstractAction() {
                                        public void actionPerformed(ActionEvent e) {
                                            int selectedRow = Integer.valueOf(e.getActionCommand());
                                            rprUI = new ResultatPrestationRadiologieIU();
                                            rprUI.setLocationRelativeTo(null);
                                            rprUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            rprUI.setCurrentConnected(currentConnected);
                                            rprUI.setCurrentPatient(currentPatient);
                                            rprUI.getjLabelNomPatient().setText(currentPatient.getNom() + " " + currentPatient.getPrenom());
                                            rprUI.getjLabelIPP().setText(currentPatient.getIPP());
                                            rprUI.getjLabelNature().setText(naturePrestation);
                                            rprUI.getjLabelDatePrestation().setText(date.toString());
                                            rprUI.setIdPrestation(idprestation);
                                            rprUI.setSmt(getLocalInstance());
                                            rprUI.setSelectedRow(selectedRow);
                                            rprUI.setVisible(true);
                                        }
                                    };
                                    ButtonColumn buttonColumn = new ButtonColumn(getjTablePrestations(), delete, 4);
                                    buttonColumn.setMnemonic(KeyEvent.VK_D);
                                } else {
                                    ResultSet result3 = CHUPP.getRequete("SELECT DISTINCT practicien_hospitalier.specialite FROM practicien_hospitalier WHERE idph=" + result2.getInt("idph"));
                                    result3.last();
                                    dtm.addRow(new Object[]{result2.getInt("idph"), result3.getString("practicien_hospitalier.specialite"), result2.getDate("date"), result2.getString("nature_prestation"), "Envoyer"});
                                    final String naturePrestation = result2.getString("nature_prestation");
                                    final Date date = result2.getDate("date");
                                    final int idprestation = result2.getInt("idprestation");
                                    final String currentService = result2.getString("service_destinataire");
                                    getjTablePrestations().setModel(dtm);
                                    Action delete = new AbstractAction() {
                                        public void actionPerformed(ActionEvent e) {
                                            int selectedRow = Integer.valueOf(e.getActionCommand());
                                            rplaUI = new ResultatPrestationLaboIU();
                                            rplaUI.setLocationRelativeTo(null);
                                            rplaUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            rplaUI.setCurrentConnected(currentConnected);
                                            rplaUI.setCurrentPatient(currentPatient);
                                            rplaUI.getjLabelNomPatient().setText(currentPatient.getNom() + " " + currentPatient.getPrenom());
                                            rplaUI.getjLabelIPP().setText(currentPatient.getIPP());
                                            rplaUI.getjLabelNature().setText(naturePrestation);
                                            rplaUI.getjLabelDatePrestation().setText(date.toString());
                                            rplaUI.getjLabelCurrentService().setText(currentService);
                                            rplaUI.setIdPrestation(idprestation);
                                            rplaUI.setSmt(getLocalInstance());
                                            rplaUI.setSelectedRow(selectedRow);
                                            rplaUI.setVisible(true);
                                        }
                                    };

                                    ButtonColumn buttonColumn = new ButtonColumn(getjTablePrestations(), delete, 4);
                                    buttonColumn.setMnemonic(KeyEvent.VK_D);
                                }
                            }
                        } else {
                            dtm = new DefaultTableModel(0, 0);
                            getjTablePrestations().setModel(dtm);
                            dtm.addColumn("ID PH");
                            dtm.addColumn("Service demandeur");
                            dtm.addColumn("Date");
                            dtm.addColumn("Nature de la demande");
                            dtm.addColumn("Résultat");
                        }
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCliniqueIU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
