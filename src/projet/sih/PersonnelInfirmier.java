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
public class PersonnelInfirmier extends PersonnelMedical{
    private static int compteur = 0;
    
    public PersonnelInfirmier(String id, String nom, String prenom, String mdp, String specialite){
        super(id,nom,prenom,mdp,specialite);
    }
    /**
     * @return the id
     */
    public String getID() {
        return super.getID();
    }
    
    public static int getIDInf() {
        try {
            String sql = "SELECT * FROM infirmier";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            compteur = resultat.getInt("idinf") + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * @param id the id to set
     */
    public void setID(String ID) {
        super.setID(ID);
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return super.getNom();
    }
    
    public String getSpecialite(){
        return super.getSpecialite();
    }
    
    public void setSpecialite(String specialite){
        super.setSpecialite(specialite);
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        super.setNom(nom);
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return super.getPrenom();
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }
}
