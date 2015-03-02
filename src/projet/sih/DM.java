/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;
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

    public DM() {
        observationsPH = new DefaultListModel<Observation>();
        prescriptionsPH = new DefaultListModel<Prescription>();
        resultatsPH = new DefaultListModel<String>();
        lettreSortie = null;
    }

    /**
     * @return the observationsPH
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
     * @return the resultatsPH
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
                    if (resultat2.getInt("idpresc") ==resultat.getInt("idpresc")) {
                        s += "\n\t\t- " + resultat2.getString("nom");
                        s += "\t\t\t" + resultat2.getString("dose") + " " + resultat2.getString("unite") + "/j  jusqu'au " + resultat2.getString("date_fin");
                    }
                }
                s += "\n------------------------------------------------------------------------------------------------------------------\n";
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }

    public String afficherObservationsPH(Patient patient) {
        String s = "";
        try {
            s += "OBSERVATIONS RELATIVES A UNE CONSULTATION :";
            String sqlc = "SELECT observation.* FROM observation, consultation WHERE observation.idch=consultation.idhosp AND consultation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sqlc);
            while (resultat.next()) {
            String sqlc2 = "SELECT practicien_hospitalier.*,consultation.date FROM practicien_hospitalier, consultation, observation WHERE consultation.idph=practicien_hospitalier.idph AND consultation.idhosp=" + resultat.getInt("observation.idch");            
            ResultSet resultat2 = CHUPP.getRequete(sqlc2);
                s += "Observation du " + resultat.getDate("observation.date") + ", faite par le Dr. " + resultat2.getString("practicien_hospitalier.nom") +" "+ resultat2.getString("practicien_hospitalier.prenom")+ "se référant à la consultation du "+resultat.getDate("consultation.date");
                s += resultat.getString("observation.contenu");
                s += "\n------------------------------------------------------------------------------------------------------------------\n";
            }
            s += "OBSERVATIONS RELATIVES A UNE HOSPITALISATION :";
            String sqlh = "SELECT observation.* FROM observation, hospitalisation WHERE observation.idch=hospitalisation.idhosp AND hospitalisation.ipp=" + patient.getIPP();
            ResultSet resultat3 = CHUPP.getRequete(sqlh);
            while (resultat3.next()) {
            String sqlc2 = "SELECT practicien_hospitalier.*,hospitalisation.date, hospitalisation.date_sortie FROM practicien_hospitalier, hospitalisation, observation WHERE hospitalisation.idph=practicien_hospitalier.idph AND hospitalisation.idhosp=" + resultat3.getInt("observation.idch");            
            ResultSet resultat4 = CHUPP.getRequete(sqlc2);
                s += "Observation du " + resultat.getDate("observation.date") + ", faite par le Dr. " + resultat4.getString("practicien_hospitalier.nom") +" "+ resultat4.getString("practicien_hospitalier.prenom")+ "se référant à l'hospitalisation du "+resultat4.getDate("hospitalisation.date")+" au "+resultat4.getDate("hospitalisation.date_sortie");
                s += resultat3.getString("observation.contenu");
                s += "\n------------------------------------------------------------------------------------------------------------------\n";
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }
}
