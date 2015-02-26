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
public class Secretaire extends PersonnelMedical {

    public Secretaire(String id, String nom, String prenom, String mdp, String specialite) {
        super(id, nom, prenom, mdp, specialite);
    }

    public String getID() {
        return getID();
    }

    /**
     * @param id the id to set
     */
    public void setID(String ID) {
        this.setID(ID);
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return getNom();
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
        return getPrenom();
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.setPrenom(prenom);
    }

}
