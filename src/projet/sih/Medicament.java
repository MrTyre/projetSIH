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
public class Medicament {

    private String nomMedoc;
    private double posologie;
    private UnitePosologie unitePosologie;
    private Date dateFin;
    private static int compteur=0;

    public Medicament(String nomMedoc, double posologie, UnitePosologie up, Date date) {
        this.nomMedoc = nomMedoc;
        this.posologie = posologie;
        this.unitePosologie = up;
        this.dateFin = date;
    }

    public static int getIDMed() {
        try {
            String sql = "SELECT * FROM medicament";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            compteur = resultat.getRow() + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }

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
    
    public String getUnitePosoString(UnitePosologie u){
        
        String doseString = "";
        if (u == UnitePosologie.cc) {
            doseString = "cc";
        }
        if (u == UnitePosologie.comprimés) {
            doseString = "comprimés";
        }
        if (u == UnitePosologie.cs) {
            doseString = "cs";
        }
        if (u == UnitePosologie.dL) {
            doseString = "dL";
        }
        if (u == UnitePosologie.g) {
            doseString = "g";
        }
        if (u == UnitePosologie.mL) {
            doseString = "mL";
        }
        if (u == UnitePosologie.mg) {
            doseString = "mg";
        }
        if (u == UnitePosologie.pulvérisations) {
            doseString = "pulvérisations";
        } 
        return doseString;
    }
}
