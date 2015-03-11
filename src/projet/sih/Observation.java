/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Tommy
 */
public class Observation {
    private Date date;
    private PH phWriter;
    private String observation;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    public static int getIDObs() {
        try {
            String sql = "SELECT * FROM observation";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            int compteur = resultat.getRow() + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the phWriter
     */
    public PH getPhWriter() {
        return phWriter;
    }

    /**
     * @param phWriter the phWriter to set
     */
    public void setPhWriter(PH phWriter) {
        this.phWriter = phWriter;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }
}
