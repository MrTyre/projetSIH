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
public class Resultat {
    //attributs
    private Date date;
    private PH phWriter;
    private Prestation prestationAssociee;
    private String resultat;
  
    /**
     * constructeur de la classe Resultat
     * @param date
     * @param ph
     * @param p
     * @param resultat 
     */
    public Resultat(Date date, PH ph, Prestation p, String resultat){
        this.date= date;
        this.phWriter = ph;
        this.prestationAssociee = p;
        this.resultat = resultat;
    }
  
    /**
     * crée un ID pour chaque résultat de prestation 
     * @return compteur, l'ID du résultat
     */
    public static int getIDresultat() {
        try {
            String sql = "SELECT * FROM resultat";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            int compteur = resultat.getInt("idresultat") + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
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
     * @return the phWriter, le praticien hospitalier ayant rédigé le résultat de prestation
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
     * @return the presciptionAssociee, la prescription associée au résultat de prestation
     */
    public Prestation getPrestationAssociee() {
        return prestationAssociee;
    }

    /**
     * @param presciptionAssociee the presciptionAssociee to set
     */
    public void setPrestationAssociee(Prestation presciptionAssociee) {
        this.prestationAssociee = presciptionAssociee;
    }

    /**
     * @return the resultat
     */
    public String getResultat() {
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
