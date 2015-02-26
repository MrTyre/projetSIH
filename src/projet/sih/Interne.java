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
        return this.getID();
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.setID(ID);
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return this.getNom();
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.setNom(nom);
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return this.getPrenom();
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.setPrenom(prenom);
    }
}
