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
public class Hospitalisation {
    private double numSejour;
    private Date dateEntree;
    private Date dateSortie;
    private PH phResp;
    private String lettreSortie;
    private String naturePrestation;

    /**
     * crée un ID d'hopitalisation pour chaque hospitalisation via un compteur
     * @return 
     */
    
    public static int getIDHosp() {
        try {
            String sql = "SELECT * FROM hospitalisation";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            int compteur = resultat.getInt("idhosp") + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * @return the numSejour (numéro de séjour)
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
     * @return the phResp (le praticien hospitalier responsable)
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

    /**
     * @return the dateEntree 
     */
    public Date getDateEntree() {
        return dateEntree;
    }

    /**
     * @param dateEntree the dateEntree to set
     */
    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    /**
     * @return the dateSortie
     */
    public Date getDateSortie() {
        return dateSortie;
    }

    /**
     * @param dateSortie the dateSortie to set
     */
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
    
   /**
    * définit la durée d'une hospitalisation
    * @return la durée d'une hospitalisation 
    */ 
    public long dureeHospitalisation(){
        long duree;
        duree = (dateEntree.getTime()-dateSortie.getTime()/86400000); //conversion ms en jours
        return duree;
    }
}
