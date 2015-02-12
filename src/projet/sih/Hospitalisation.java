/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.sql.Date;

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
     * @return the phResp
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
    
    public long dureeHospitalisation(){
        long duree;
        duree = (dateEntree.getTime()-dateSortie.getTime()/86400000); //conversion ms en jours
        return duree;
    }
}
