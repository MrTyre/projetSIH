/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.util.Date;

/**
 *
 * @author Tommy
 */
public class Prestation {
    private Date datePrestation;
    private String naturePrestation;
    private Resultat resultatPrestation;

    public Prestation(Date date, String nP, Resultat rP){
        this.datePrestation = date;
        this.naturePrestation = nP;
        this.resultatPrestation = rP;
    }
    /**
     * @return the naturePrestation
     */
    public String getNaturePrestation() {
        return naturePrestation;
    }

    /**
     * @param naturePrestation the naturePrestation to set
     */
    public void setNaturePrestation(String naturePrestation) {
        this.naturePrestation = naturePrestation;
    }

    /**
     * @return the resultatPrestation
     */
    public Resultat getResultatPrestation() {
        return resultatPrestation;
    }

    /**
     * @param resultatPrestation the resultatPrestation to set
     */
    public void setResultatPrestation(Resultat resultatPrestation) {
        this.resultatPrestation = resultatPrestation;
    }

    /**
     * @return the date
     */
    public Date getDatePrestation() {
        return datePrestation;
    }

    /**
     * @param date the date to set
     */
    public void setDatePrestation(Date date) {
        this.datePrestation = date;
    }
}
