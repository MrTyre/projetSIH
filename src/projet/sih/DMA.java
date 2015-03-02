/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class DMA {

    private DefaultListModel<Consultation> consultations;
    private DefaultListModel<Hospitalisation> hospitalisations;

    public DMA() {
        consultations = new DefaultListModel<Consultation>();
        hospitalisations = new DefaultListModel<Hospitalisation>();
    }

    /**
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

    public String afficherConsultations(Patient patient) {
        String s = "";
        try {
            String sql = "SELECT * FROM consultation WHERE consultation.ipp=" + patient.getIPP();
            String sql2 = "SELECT observation.* FROM observation, consultation WHERE observation.idch = consultation.idconsult AND consultation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            resultat.last();
            int nbrow = resultat.getRow();
            resultat.first();
            s += "CONSULTATIONS :";
            if (nbrow == 0) {
                s += "\nLa partie \"Consultations\" du DMA du patient " + patient.getNom() + " " + patient.getPrenom() + " est pour le moment inaccessible.";
            } else {
                String sql3 = "SELECT DISTINCT * FROM practicien_hospitalier WHERE practicien_hospitalier.idph=" + resultat.getInt("consultation.idph");
                ResultSet resultat3 = CHUPP.getRequete(sql3);
                resultat3.first();
                resultat.beforeFirst();
                while (resultat.next()) {
                    s += "\nConsultation du " + resultat.getDate("consultation.date") + ", faite par le Dr. " + resultat3.getString("nom") + " " + resultat3.getString("prenom") + "\t\tN° de séjour : " + resultat.getInt("consultation.idconsult");
                    s += "\n\nNature de la prestation :   ";
                    s += resultat.getString("consultation.nature_prestation");
                    while (resultat2.next()) {
                        s += "\n\tObservation du " + resultat2.getDate("observation.datel")+":\t" + resultat2.getString("observation.contenu");
                    }
                    s += "\n------------------------------------------------------------------------------------------------------------------\n";
                }
            }
            return s;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return "erreur";
        }
    }

    public String afficherHospitalisations(Patient patient) {
        String s = "";
        try {
            String sql = "SELECT * FROM hospitalisation WHERE hospitalisation.ipp=" + patient.getIPP();
            ResultSet resultat = CHUPP.getRequete(sql);
            while (resultat.next()) {
                s += "Hospitalisation du " + resultat.getDate("hospitalisation.date") + " au " + resultat.getDate("hospitalisation.date_sortie") + ", dans le service " + resultat.getString("specialite") + "\t\tN° de séjour : " + resultat.getInt("hospitalisation.idhosp");
                s += "\tNature de l'hospitalisation :";
                s += "\n" + resultat.getString("hospitalisation.nature_prestation");
                //s += "\n" + resultat.getString("hospitalisation.contenu");
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
