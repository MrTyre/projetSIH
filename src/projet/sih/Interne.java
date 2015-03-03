/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

/**
 *
 * @author Tommy
 */
public class Interne extends PersonnelMedical{

    /**
     * @return the ID
     */
    
    public Interne(String id, String nom, String prenom, String mdp, String specialite) {
        super(id, nom, prenom, mdp, specialite);
    }

    public String getID() {
        return super.getID();
    }

    /**
     * @param ID the ID to set
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
