/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class CHUPP {

    //attributs
    private DefaultListModel<ServiceClinique> scs;
    private DefaultListModel<ServiceMedicoTechnique> smts;
    private ServiceAdmission sa;
    private ServiceInformatique si;
    private Archives a;
    private static double compteur;
    //vattribut base de donnée
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
    }

    /**
     * définit les valeurs prises par la comboBox "liste de services"
     *
     * @return dcbm, les valeurs prises par la comboBox "liste de services"
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
     *
     * @return dcbm, les valeurs prises par la comboBox "liste de services
     * cliniques"
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
     * définit une liste modèle comportant la "liste de services cliniques" sous
     * forme de String
     *
     * @return dcbm, les valeurs prises par la comboBox "liste de services
     * cliniques"
     * @throws SQLException
     */
    public static DefaultListModel getListeServiceCliniqueDLM() throws SQLException {
        DefaultListModel dlm = new DefaultListModel();
        String sql = "SELECT specialite FROM service_clinique";
        ResultSet resultat = CHUPP.getRequete(sql);
        while (resultat.next()) {
            dlm.addElement(resultat.getString("specialite"));
        }
        return dlm;
    }

    /**
     * definit les valeurs prises par la comboBox "liste de services
     * médico-techniques
     *
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
     * définit une liste modèle comportant la "liste de services
     * médico-techniques" sous forme de String
     *
     * @return les valeurs prises par la comboBox "liste de services"
     * @throws SQLException
     */
    public static DefaultListModel getListeServiceMedicoTechniqueDLM() throws SQLException {
        DefaultListModel dlm = new DefaultListModel();
        String sql = "SELECT specialite FROM service_medico_technique";
        ResultSet resultat = CHUPP.getRequete(sql);
        while (resultat.next()) {
            dlm.addElement(resultat.getString("specialite"));
        }
        return dlm;
    }

    /**
     * méthode statique pour récupérer un résultat d'une requête depuis
     * n'importe ou.
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

    /**
     * méthode statique pour mettre à jour la base de données     *
     * @param sql
     * @return statut, l'état de la base de données
     * @throws SQLException
     */
    public static int getInsert(String sql) throws SQLException {
        MyDBConnection connection = new MyDBConnection();
        //connexion a la BD
        connection.init();
        connection.getMyConnection();
        int statut = connection.getStatement().executeUpdate(sql);
        return statut;
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
}
