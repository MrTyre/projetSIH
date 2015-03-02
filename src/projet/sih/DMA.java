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
            ResultSet resultat = CHUPP.getRequete(sql);
            String sql2 = "SELECT * FROM practicien_hospitalier, consultation WHERE practicien_hospitalier.idph=" + resultat.getInt("consultation.idph");
            ResultSet resultat2 = CHUPP.getRequete(sql2);
            while (resultat.next()) {
                s += "Consultation du " + resultat.getDate("consultation.date") + ", faite par le Dr. " + resultat2.getString("nom") + " " + resultat2.getString("prenom") + "\t\tN° de séjour : " + resultat.getInt("consultation.num_sejour_incr");
                s += "\tNature de la prestation :";
                s += "\n" + resultat.getString("consultation.nature_prestation");
                //s += "\n" + resultat.getString("consultation.contenu");
                s += "\n------------------------------------------------------------------------------------------------------------------\n";
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
                s += "Hospitalisation du " + resultat.getDate("hospitalisation.date") + " au " + resultat.getDate("hospitalisation.date_sortie")+ ", dans le service "+resultat.getString("specialite") + "\t\tN° de séjour : " + resultat.getInt("hospitalisation.num_sejour_incr");
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
