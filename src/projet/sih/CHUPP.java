/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import projet.UI.*;

/**
 *
 * @author Tommy
 */
public class CHUPP {

    private DefaultListModel<ServiceClinique> scs;
    private DefaultListModel<ServiceMedicoTechnique> smts;
    private ServiceAdmission sa;
    private ServiceInformatique si;
    private Archives a;
    private static double compteur;
    //private ServiceUrgences su;
    //attribut base de donnée
    MyDBConnection connection = new MyDBConnection();

    /**
     * Constructeur de la classe CHUPP
     */
    public CHUPP() {
        //connexion a la BD
        connection.init();
        connection.getMyConnection();

        //initialisation du compteur pour les IPP
        try {
            String sql = "SELECT * FROM patient";
            ResultSet resultat = connection.getStatement().executeQuery(sql);
            resultat.last();
            compteur = (double) resultat.getRow() + 1;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
        }

        //initialisation des services
        scs = new DefaultListModel<ServiceClinique>();
        smts = new DefaultListModel<ServiceMedicoTechnique>();

        scs.addElement(new ServiceBacteriologie());
        scs.addElement(new ServiceCardiologie());
        scs.addElement(new ServiceCytologie());
        scs.addElement(new ServiceChirurgieGenerale());
        scs.addElement(new ServiceDermatologie());
        scs.addElement(new ServiceEndocrinologie());
        scs.addElement(new ServiceGeriatrie());
        scs.addElement(new ServiceGynecologie());
        scs.addElement(new ServiceNeurologie());
        scs.addElement(new ServicePediatrie());
        scs.addElement(new ServiceOncologie());
        scs.addElement(new ServicePsychiatrie());
        scs.addElement(new ServicePneumologie());

        smts.addElement(new LaboImmunologie());
        smts.addElement(new LaboMicrobiologie());
        smts.addElement(new LaboHematologie());
        smts.addElement(new LaboAnapathologie());
        smts.addElement(new ServiceRadiologie());
        smts.addElement(new ServiceAnesthesieRea());

        sa = new ServiceAdmission();
        si = new ServiceInformatique();
        a = new Archives();

        //su = new ServiceUrgences();        
        //test pour se connecter avec un practicien
        try {
            String sql = "SELECT * FROM practicien_hospitalier";
            ResultSet resultat = connection.getStatement().executeQuery(sql);
            while (resultat.next()) {
                String id = Integer.toString(resultat.getInt(1));
                String nom = resultat.getString(2);
                String prenom = resultat.getString(3);
                String specialite = resultat.getString(4);
                String mdp = "test";
                PH doc = new PH(id, nom, prenom, mdp, specialite);
                scs.get(1).getPraticiens().addElement(doc);
            }
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
        }
    }

    /**
     * définit les valeurs prises par la comboBox "liste de services"
     * @return les valeurs prises par la comboBox "liste de services"
     * @throws SQLException 
     */
    public static DefaultComboBoxModel getListeService() throws SQLException {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
        String sql = "SELECT specialite FROM service_clinique";
        String sql2 = "SELECT specialite FROM service_medico_technique";

        ResultSet resultat = CHUPP.getRequete(sql);
        ResultSet resultat2 = CHUPP.getRequete(sql2);
        while (resultat.next()) {
            dcbm.addElement(resultat.getString("specialite"));
        }
        while (resultat2.next()) {
            dcbm.addElement(resultat2.getString("specialite"));
        }
        return dcbm;
    }

    /**
     * définit les valeurs prises par la comboBox "liste de services cliniques"
     * @return les valeurs prises par la comboBox "liste de services cliniques"
     * @throws SQLException 
     */
    public static DefaultComboBoxModel getListeServiceClinique() throws SQLException {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        String sql = "SELECT specialite FROM service_clinique";
        ResultSet resultat = CHUPP.getRequete(sql);
        while (resultat.next()) {
            dcbm.addElement(resultat.getString("specialite"));
        }
        return dcbm;
    }
  
    /**
     * definit les valeurs prises par la comboBox "liste de services médico-techniques
     * @return les valeurs prises par la comboBox "liste de services"
     * @throws SQLException 
     */
    public static DefaultComboBoxModel getListeServiceMedicoTechnique() throws SQLException {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        String sql = "SELECT specialite FROM service_medico_technique";
        ResultSet resultat = CHUPP.getRequete(sql);
        while (resultat.next()) {
            dcbm.addElement(resultat.getString("specialite"));
        }
        return dcbm;
    }

    /**
     * 
     * @param sql, la chaine de caractère correspondant à la requête sql
     * @return resultat
     * @throws SQLException 
     */
    public static ResultSet getRequete(String sql) throws SQLException {
        MyDBConnection connection = new MyDBConnection();
        //connexion a la BD
        connection.init();
        connection.getMyConnection();
        ResultSet resultat = connection.getStatement().executeQuery(sql);
        return resultat;
    }

    public static int getInsert(String sql) throws SQLException {
        MyDBConnection connection = new MyDBConnection();
        //connexion a la BD
        connection.init();
        connection.getMyConnection();
        int statut = connection.getStatement().executeUpdate(sql);
        return statut;
    }

    public DefaultListModel<ServiceClinique> getScs() {
        return scs;
    }

    /**
     * @return the smts
     */
    public DefaultListModel<ServiceMedicoTechnique> getSmts() {
        return smts;
    }

    /**
     * @return the sa
     */
    public ServiceAdmission getSa() {
        return sa;
    }

    /**
     * @return the a
     */
    public Archives getA() {
        return a;
    }

    /**
     * @return the compteur
     */
    public static double getCompteur() {
        return compteur;
    }

    /**
     * @param aCompteur the compteur to set
     */
    public static void setCompteur(double aCompteur) {
        compteur = aCompteur;
    }

    public void creerServiceClinique(String specialite, PH chefDeService, DefaultListModel<PH> praticiens, DefaultListModel<Patient> patients, DefaultListModel<PersonnelInfirmier> infirmiers, DefaultListModel<Interne> internes) {
        ServiceClinique sc = new ServiceClinique(specialite, chefDeService, praticiens, patients, infirmiers, internes);
        scs.addElement(sc);
    }

    /**
     * @return the si, le service informatique
     */
    public ServiceInformatique getSi() {
        return si;
    }
}
