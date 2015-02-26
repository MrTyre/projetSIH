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
    private String sql;
    private String sql2;

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
            sql = "SELECT * FROM prescription WHERE prescription.ipp=" + patient.getIPP();

            ResultSet resultat = CHUPP.getRequete(sql);
            while (resultat.next()) {
                sql2 = "SELECT medicament.* FROM medicament, prescription, patient WHERE medicament.idpresc= prescription.idpresc and prescription.ipp=patient.ipp and prescription.ipp=" + patient.getIPP();

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

    public String afficherObservationsPH() {
        String s = "";
        for (int i = 0; i < this.observationsPH.getSize(); i++) {
            s += "Observation du " + this.observationsPH.get(i).getDate() + ", Dr." + this.observationsPH.get(i).getPhWriter().toString();
            s += "\n-----------------------------------------------------------------------------------";
        }
        return s;
    }
}
