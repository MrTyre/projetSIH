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

public class PH extends PersonnelMedical {
    //attributs
    private static int compteur =0;
  /**
   * constructeur de la classe PH, praticien hospitalier
   */ 
    
    public PH(){
        super();
        specialite="DefaultSpeciality";
    }
    
    /**
     * constructeur n°2
     * @param id
     * @param nom
     * @param prenom 
     */
    public PH(String id,String nom, String prenom){
        super(id,nom, prenom);
        
    }
    
    /**
     * constructeur n°3
     * @param id
     * @param nom
     * @param prenom
     * @param mdp
     * @param specialite 
     */
    public PH(String id, String nom, String prenom, String mdp, String specialite){
        super(id,nom,prenom,mdp,specialite);
    }

    /**
     * @return the id, l'ID du praticien hospitalier
     */
    public String getID() {
        return super.ID;
    }

    /**
     * @param ID the id to set
     */
    public void setID(String ID) {
        super.setID(ID);
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return super.nom;
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
        return super.prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }
/**
 * crée une chaine de caractères avec le nom et le prénom du praticien hospitalier
 * @return s, la chaine de caractère correspondant au nom et prenom du praticien hospitalier 
 */
    public String toString() {
        String s = this.getNom() + " " + this.getPrenom();
        return s;
    }
    
  /**
   * crée un ID pour chaque praticien hospitalier
   * @return compteur, l'ID du praticien hospitalier
   */  
    public static int getIDPH() {
        try {
            String sql = "SELECT * FROM practicien_hospitalier";
            ResultSet resultat=CHUPP.getRequete(sql);
            resultat.last();
            compteur = resultat.getInt("idph") + 1;
            return compteur;
        } catch (Exception e) {
            System.out.println("Failed to get Statement");
            e.printStackTrace();
            return 0;
        }
    }
}
