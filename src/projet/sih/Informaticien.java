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
/** 
 * constructeur de la classe Informaticien
 * @param id
 * @param nom
 * @param prenom
 * @param mdp
 * @param specialite 
 */
    public Informaticien(String id, String nom, String prenom, String mdp,String specialite) {
        super(id, nom, prenom, mdp,specialite);
    }
 /**
  * crée un ID pour chaque informaticien 
  * @return compteur, l'ID de l'informaticien
  */   
    public static int getIDInfo() {
        try {
            String sql = "SELECT * FROM informaticien";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            compteur = resultat.getInt("idinfo") + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
    
}
