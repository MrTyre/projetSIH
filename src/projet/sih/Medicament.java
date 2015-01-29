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
public class Medicament {
    private String nomMedoc;
    private double posologie;
    private UnitePosologie unitePosologie;
    private Date dateFin;

    /**
     * @return the nomMedoc
     */
    public String getNomMedoc() {
        return nomMedoc;
    }

    /**
     * @param nomMedoc the nomMedoc to set
     */
    public void setNomMedoc(String nomMedoc) {
        this.nomMedoc = nomMedoc;
    }

    /**
     * @return the posologie
     */
    public double getPosologie() {
        return posologie;
    }

    /**
     * @param posologie the posologie to set
     */
    public void setPosologie(double posologie) {
        this.posologie = posologie;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the unitePosologie
     */
    public UnitePosologie getUnitePosologie() {
        return unitePosologie;
    }
}
