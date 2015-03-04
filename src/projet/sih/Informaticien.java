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
public class Informaticien extends PersonnelMedical{
    private static int compteur =0 ;

    public Informaticien(String id, String nom, String prenom, String mdp,String specialite) {
        super(id, nom, prenom, mdp,specialite);
    }
    
    public static int getIDInfo() {
        try {
            String sql = "SELECT * FROM prescription";
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
    
}
