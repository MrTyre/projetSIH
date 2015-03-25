/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class DMA {
    //attributs
    private DefaultListModel<Consultation> consultations;
    private DefaultListModel<Hospitalisation> hospitalisations;

    /**
     * constructeur de la classe DMA
     */
    public DMA() {
        consultations = new DefaultListModel<Consultation>();
        hospitalisations = new DefaultListModel<Hospitalisation>();
    }

    /**
     * crée une liste de consultations
     *
     * @return the consultations
     */
    public DefaultListModel<Consultation> getConsultations() {
        return consultations;
    }

    /**
     * @param consultations the consultations to set
     */
    public void setConsultations(DefaultListModel<Consultation> consultations) {
        this.consultations = consultations;
    }

    /**
     * crée une liste d'hospitalisations
     *
     * @return the hospitalisations
     */
    public DefaultListModel<Hospitalisation> getHospitalisations() {
        return hospitalisations;
    }

    /**
     * @param hospitalisations the hospitalisations to set
     */
    public void setHospitalisations(DefaultListModel<Hospitalisation> hospitalisations) {
        this.hospitalisations = hospitalisations;
    }

    /**
     * affiche la liste des consultations du patient sélectionné
     *
     * @param patient
     * @return s, les chaines de caractères correspondant aux consultations du
     * patient sélectionné
     */
    public String afficherConsultations(Patient patient) {
        String s = "";
        try {
            //on récupère la date du système ainsi que les consultations relatives au patient courant (qui sont déjà passées), et leurs observations associées
            Date date = new Date(System.currentTimeMillis());
            String sql = "SELECT * FROM consultation WHERE consultation.date <'" + date + "' AND consultation.ipp=" + patient.getIPP();
            String sql2 = "SELECT observation.* FROM observation, consultation WHERE observation.idch = consultation.idconsult AND consultation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            resultat.last();
            int nbrow = resultat.getRow();
            resultat.first();
            s += "CONSULTATIONS :";
            //cas ou il n'y a pas de consultations
            if (nbrow == 0) {
                s += "\nIl n'y a pas de consultations répertoriées pour le patient " + patient.getNom() + " " + patient.getPrenom() + ".";
            } else {
                 //récupération des infos nécessaires à l'affichage               
                String sql3 = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultat.getInt("consultation.idph");
                ResultSet resultat3 = CHUPP.getRequete(sql3);
                resultat3.first();
                resultat.beforeFirst();
                //on écrit les consultations = RDV du patient déjç passés : trace mémoire
                while (resultat.next()) {
                    s += "\n\nConsultation du " + resultat.getDate("consultation.date") + ", faite par le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom") + "\t\tN° de séjour : " + resultat.getInt("consultation.idconsult");
                    s += "\n\nNature de la prestation :   ";
                    s += resultat.getString("consultation.nature_prestation");
                    while (resultat2.next()) {
                        s += "\n\tObservation du " + resultat2.getDate("observation.date") + ":\t" + resultat2.getString("observation.contenu");
                    }
                    s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                }
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }

    /**
     * affiche la liste des hospitalisations du patient sélectionné
     *
     * @param patient
     * @return s, les chaines de caractères correspondant aux hospitalisations
     * du patient sélectionné
     */
    public String afficherHospitalisations(Patient patient) {
        String s = "";
        try {
            //récupération des hospitalisations du patient (date de sortie connue ET date de sortie inconnue) ainsi que les observations relatives à ces hospitalisations
            String sql = "SELECT * FROM hospitalisation WHERE hospitalisation.ipp=" + patient.getIPP() + " and hospitalisation.date_sortie != '1111-11-11'";
            String sqlbis = "SELECT * FROM hospitalisation WHERE hospitalisation.ipp=" + patient.getIPP() + " and hospitalisation.date_sortie = '1111-11-11'";
            String sql2 = "SELECT observation.* FROM observation, hospitalisation WHERE observation.idch = hospitalisation.idhosp AND hospitalisation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            ResultSet resultatbis = CHUPP.getRequete(sqlbis);
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            resultat.last();
            resultatbis.last();
            int nbrow = resultat.getRow();
            int nbrowbis = resultatbis.getRow();
            resultat.first();
            resultatbis.first();
            s += "HOSPITALISATIONS :";
            //cas ou le patient n'a aucune hospitalisation
            if (nbrow == 0 && nbrowbis == 0) {
                s += "\nIl n'y a pas d'hospitalisations répertoriées pour le patient " + patient.getNom() + " " + patient.getPrenom() + ".";
            } else {
                resultat.beforeFirst();
                resultatbis.beforeFirst();
                //on écrit les hospitalisations courantes dont la date de sortie est connue
                while (resultat.next()) {
                     //récupération des infos nécessaires à l'affichage               
                    String sql3 = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultat.getInt("hospitalisation.idph");
                    ResultSet resultat3 = CHUPP.getRequete(sql3);
                    resultat3.first();
                    s += "\n\nHospitalisation du " + resultat.getDate("hospitalisation.date") + " au " + resultat.getDate("hospitalisation.date_sortie") + ", faite par le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom") + "\t\tN° de séjour : " + resultat.getInt("hospitalisation.idhosp");
                    s += "\n\nNature de la prestation :   ";
                    s += resultat.getString("hospitalisation.raison_sejour");
                    //on écrit les observations reliées
                    while (resultat2.next()) {
                        s += "\n\tObservation du " + resultat2.getDate("observation.date") + ":\t" + resultat2.getString("observation.contenu");
                    }
                    s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                }
                //on écrit les hospitalisation courantes dont la date de sortie est inconnue
                while (resultatbis.next()) {
                     //récupération des infos nécessaires à l'affichage               
                    String sql3bis = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultatbis.getInt("hospitalisation.idph");
                    ResultSet resultat3bis = CHUPP.getRequete(sql3bis);
                    resultat3bis.first();
                    s += "\n\nHospitalisation du " + resultatbis.getDate("hospitalisation.date") + " au <date de sortie inconnue>, faite par le Dr. " + resultat3bis.getString("nom") + " " + resultat3bis.getString("prenom") + "\t\tN° de séjour : " + resultatbis.getInt("hospitalisation.idhosp");
                    s += "\n\nNature de la prestation :   ";
                    s += resultatbis.getString("hospitalisation.raison_sejour");
                    //on écrit les observations reliées
                    while (resultat2.next()) {
                        s += "\n\tObservation du " + resultat2.getDate("observation.date") + ":\t" + resultat2.getString("observation.contenu");
                    }
                    s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                }
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }
}
