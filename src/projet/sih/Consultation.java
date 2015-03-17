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
public class Consultation {
    private double numSejour;
    private Date date;
    private PH phResp;
    private String lettreSortie;
    private String naturePrestation;
    private static int compteur=0;
    
    /** 
     * crée un ID pour chaque consultation
     * @return compteur
     * compteur est l'ID de la consultations
     */
    public static int getIDConsult() {
        try {
            String sql = "SELECT * FROM consultation";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            compteur =resultat.getInt("idconsult")+1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * @return the numSejour
     */
    public double getNumSejour() {
        return numSejour;
    }

    /**
     * @param numSejour the numSejour to set
     */
    public void setNumSejour(double numSejour) {
        this.numSejour = numSejour;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the phResp
     * phResp est le praticien hospitalier responsable
     */
    public PH getPhResp() {
        return phResp;
    }

    /**
     * @param phResp the phResp to set
     */
    public void setPhResp(PH phResp) {
        this.phResp = phResp;
    }

    /**
     * @return the lettreSortie
     */
    public String getLettreSortie() {
        return lettreSortie;
    }

    /**
     * @param lettreSortie the lettreSortie to set
     */
    public void setLettreSortie(String lettreSortie) {
        this.lettreSortie = lettreSortie;
    }

    /**
     * @return the prestation
     */
    public String getNaturePrestation() {
        return naturePrestation;
    }

    /**
     * @param prestation the prestation to set
     */
    public void setNaturePrestation(String prestation) {
        this.naturePrestation = prestation;
    }
}
