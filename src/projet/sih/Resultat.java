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
public class Resultat {
    private Date date;
    private PH phWriter;
    private Prestation prestationAssociee;
    private String resultat;
    
    public Resultat(Date date, PH ph, Prestation p, String resultat){
        this.date= date;
        this.phWriter = ph;
        this.prestationAssociee = p;
        this.resultat = resultat;
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
     * @return the presciptionAssociee
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
