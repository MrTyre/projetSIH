/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import projet.UI.ConnexionUI;

/**
 *
 * @author Tommy
 */
public class DM {

    private DefaultListModel<Observation> observationsPH;
    private DefaultListModel<Prescription> prescriptionsPH;
    private DefaultListModel<String> resultatsPH;
    private String lettreSortie;
/** constructeur de la classe DM
 */
    public DM() {
        observationsPH = new DefaultListModel<Observation>();
        prescriptionsPH = new DefaultListModel<Prescription>();
        resultatsPH = new DefaultListModel<String>();
        lettreSortie = null;
    }

    /**
     * crée une liste d'observations
     * @return the observationsPH
     * qui sont les observations du praticien hospitalier
     */
    public DefaultListModel<Observation> getObservationsPH() {
        return observationsPH;
    }

    /**
     * @return the prescriptionsPH
     */
    public DefaultListModel<Prescription> getPrescriptionsPH() {
        return prescriptionsPH;
    }

    /**
     * crée une liste de resultats de prestations ecrits par un praticien hospitalier
     * @return the resultatsPH
     * qui sont les resultats de prestation ecrits par un praticien hospitalier
     */
    public DefaultListModel<String> getResultatsPH() {
        return resultatsPH;
    }

    /**
     * @return the lettreSortie
     */
    public String getLettreSortie() {
        return lettreSortie;
    }
/**
 * affiche la liste des prescriptions pour la patient sélectionné
 * @param patient
 * @return s, les chaines de caractères correspondant aux prescriptions
 */
    public String afficherPrescriptions(Patient patient) {
        String s = "";
        try {
            String sql = "SELECT * FROM prescription WHERE prescription.ipp=" + patient.getIPP();

            ResultSet resultat = CHUPP.getRequete(sql);
            while (resultat.next()) {
                String sql2 = "SELECT medicament.* FROM medicament, prescription, patient WHERE medicament.idpresc= prescription.idpresc and prescription.ipp=patient.ipp and prescription.ipp=" + patient.getIPP();

                ResultSet resultat2 = CHUPP.getRequete(sql2);
                s += "Prescription du " + resultat.getDate("prescription.date") + ", Dr. " + ConnexionUI.getCurrentConnected().getNom() + "  numero de prescription: " + resultat.getString("idpresc");
                while (resultat2.next()) {
                    if (resultat2.getInt("idpresc") == resultat.getInt("idpresc")) {
                        s += "\n\t\t- " + resultat2.getString("nom");
                        s += "\t\t\t" + resultat2.getString("dose") + " " + resultat2.getString("unite") + "/j  jusqu'au " + resultat2.getString("date_fin");
                    }
                }
                s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }
/** affiche la liste des observations (relatives à une consultation et/ou une hospitalisation) du patient sélectionné
 * 
 * @param patient
 * @return les chaines de caractères correspondant à la liste des observations du patient sélectionné. S'il
 * n'y à pas d'obervation pour ce patient, la chaine de caractères retournée est : "Il n'y a pas d'obervations relatives
 * à une consultation/hospitalisation pour ce patient.
 */
    public String afficherObservationsPH(Patient patient) {
        String s = "";
        try {
            s += "OBSERVATIONS RELATIVES A UNE CONSULTATION :";
            String sqlc = "SELECT observation.* FROM observation, consultation WHERE observation.idch=consultation.idconsult AND consultation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sqlc);
            resultat.last();
            int nbrow = resultat.getRow();
            resultat.beforeFirst();
            if (nbrow == 0) {
                s += "\nIl n'y a pas d'observations relatives à une consultation pour ce patient.";
            } else {
                while (resultat.next()) {
                    String sqlc2 = "SELECT DISTINCT practicien_hospitalier.*,consultation.date FROM practicien_hospitalier, consultation WHERE consultation.idph=practicien_hospitalier.idph AND consultation.idconsult=" + resultat.getInt("observation.idch");
                    ResultSet resultat2 = CHUPP.getRequete(sqlc2);
                    resultat2.first();
                    s += "\nObservation du " + resultat.getDate("observation.date") + ", faite par le Dr. " + resultat2.getString("practicien_hospitalier.nom") + " " + resultat2.getString("practicien_hospitalier.prenom") + ", se référant à la consultation du " + resultat2.getDate("consultation.date") + " :";
                    s += "\n\tContenu : " + resultat.getString("observation.contenu");
                    s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                }
            }

            s += "\n\nOBSERVATIONS RELATIVES A UNE HOSPITALISATION :";
            String sqlh = "SELECT observation.* FROM observation, hospitalisation WHERE observation.idch=hospitalisation.idhosp AND hospitalisation.ipp=" + patient.getIPP();
            ResultSet resultat3 = CHUPP.getRequete(sqlh);
            resultat3.last();
            nbrow = resultat3.getRow();
            resultat3.beforeFirst();
            if (nbrow == 0) {
                s += "\nIl n'y a pas d'observations relatives à une hospitalisation pour ce patient.";
            } else {
                while (resultat3.next()) {
                    String sqlh2 = "SELECT practicien_hospitalier.*,hospitalisation.date, hospitalisation.date_sortie FROM practicien_hospitalier, hospitalisation WHERE hospitalisation.idph=practicien_hospitalier.idph AND hospitalisation.idhosp=" + resultat3.getInt("observation.idch");
                    ResultSet resultat4 = CHUPP.getRequete(sqlh2);
                    resultat4.first();
                    s += "\nObservation du " + resultat3.getDate("observation.date") + ", faite par le Dr. " + resultat4.getString("practicien_hospitalier.nom") + " " + resultat4.getString("practicien_hospitalier.prenom") + ", se référant à l'hospitalisation du " + resultat4.getDate("hospitalisation.date") + " au " + resultat4.getDate("hospitalisation.date_sortie") + " :";
                    s += "\n\tContenu : " + resultat3.getString("observation.contenu");
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
 * affiche la liste des RDV pour un patient sélectionné
 * @param patient
 * @return s, les chaines de caractères correspondant aux RDV du patient sélectionné
 */
    public String afficherRDV(Patient patient) {
        String s = "";
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        int heure = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        try {
            String sql = "SELECT * FROM consultation WHERE consultation.date>='" + date + "' AND consultation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            resultat.last();
            int nbrow = resultat.getRow();
            resultat.first();
            s += "RENDEZ-VOUS :";
            if (nbrow == 0) {
                s += "\nIl n'y a pas de rendez-vous prévus pour le patient " + patient.getNom() + " " + patient.getPrenom() + ".";
            } else {
                String sql3 = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultat.getInt("consultation.idph");
                ResultSet resultat3 = CHUPP.getRequete(sql3);
                resultat3.first();
                resultat.beforeFirst();
                while (resultat.next()) {
                    if ((resultat.getString("date").equals(date.toString()))) {
                        if ((resultat.getInt("heure") == heure)) {
                            if (resultat.getInt("minute") > min) {
                                s += "\n\nRendez-vous prévu le " + resultat.getDate("consultation.date") + " à " + resultat.getInt("heure") + "h" + resultat.getInt("minute") + ", avec le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom");
                                s += "\n\nNature de la prestation :   ";
                                s += resultat.getString("consultation.nature_prestation");
                                s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                            } else {
                                s += "\nIl n'y a pas de rendez-vous prévus pour le patient " + patient.getNom() + " " + patient.getPrenom() + ".";
                            }
                        } else if (resultat.getInt("heure") > heure) {
                            s += "\n\nRendez-vous prévu le " + resultat.getDate("consultation.date") + " à " + resultat.getInt("heure") + "h" + resultat.getInt("minute") + ", avec le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom");
                            s += "\n\nNature de la prestation :   ";
                            s += resultat.getString("consultation.nature_prestation");
                            s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                        }
                    } else if (resultat.getDate("date").compareTo(date) > 0) {
                        s += "\n\nRendez-vous prévu le " + resultat.getDate("consultation.date") + " à " + resultat.getInt("heure") + "h" + resultat.getInt("minute") + ", avec le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom");
                        s += "\n\nNature de la prestation :   ";
                        s += resultat.getString("consultation.nature_prestation");
                        s += "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    }
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
 * affiche la liste des résultats de prestation pour le patient sélectionné
 * @param patient
 * @return s, les chaines de caractères correspondant aux résultats de prestation du patient sélectionné
 */
    public String afficherResultats(Patient patient) {
        String s = "";
        try {
            String sql = "SELECT * FROM resultat WHERE resultat.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            resultat.last();
            int nbrow = resultat.getRow();
            resultat.first();
            s += "RÉSULTATS :";
            if (nbrow == 0) {
                s += "\nIl n'y a pas de résultats concernant le patient " + patient.getNom() + " " + patient.getPrenom() + ".";
            } else {
                String sql3 = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultat.getInt("resultat.idph");
                ResultSet resultat3 = CHUPP.getRequete(sql3);
                resultat3.first();
                resultat.beforeFirst();
                while (resultat.next()) {
                    String sql2 = "SELECT DISTINCT observation.* FROM resultat,observation WHERE observation.idch =" + resultat.getInt("idresultat") + " AND observation.idobs=" + resultat.getInt("idobs");
                    ResultSet resultat2 = CHUPP.getRequete(sql2);
                    s += "\n\nRésultat n° : " + resultat.getInt("idresultat") + ", effectuée par le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom") + " , rédigé le " + resultat.getDate("date");
                    s += "\n\nNature de la prestation :   ";
                    s += resultat.getString("resultat.nature_prestation");
                    s += "\nRésultat de la prestation :   ";
                    s += resultat.getString("resultat.resultat_prestation");
                    resultat2.last();
                    int nbrow2 = resultat2.getRow();
                    resultat2.beforeFirst();
                    if (nbrow2 != 0) {
                        while (resultat2.next()) {
                            s += "\n\tObservation relative à ce résultat :\t" + resultat2.getString("observation.contenu");
                        }
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
