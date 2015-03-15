/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;

/**
 *
 * @author Tommy
 */
public class Prestation {

    private String naturePrestation;
    private String resultatPrestation;

    /**
     * @return the naturePrestation
     */
    public String getNaturePrestation() {
        return naturePrestation;
    }

    public static int getIDPrest() {
        try {
            String sql = "SELECT * FROM prestation";
            ResultSet resultat = CHUPP.getRequete(sql);
            resultat.last();
            if (resultat.getRow() == 0) {
                int compteur = 400000001;
                return compteur;
            } else {
                int compteur = resultat.getInt("idprestation") + 1;
                return compteur;
            }
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
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
    public String getResultatPrestation() {
        return resultatPrestation;
    }

    /**
     * @param resultatPrestation the resultatPrestation to set
     */
    public void setResultatPrestation(String resultatPrestation) {
        this.resultatPrestation = resultatPrestation;
    }
}
