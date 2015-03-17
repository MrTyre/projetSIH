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
public abstract class PersonnelMedical {

    protected String ID;
    protected String nom;
    protected String prenom;
    protected String mdp;
    protected String specialite;

    /**
     * constructeur de la classe PersonnelMedical
     */
    public PersonnelMedical() {
        ID = "000000";
        nom = "DefaultName";
        prenom = "DefaultFirstName";
        mdp = "DefaultMdp";
        specialite = "DefaultSpeciality";
    }

    public PersonnelMedical(String id, String nom, String prenom, String mdp) {
        this.ID = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }
    
    public PersonnelMedical(String id,String nom, String prenom){
        this.ID=id;
        this.nom=nom;
        this.prenom=prenom;
    }
    public PersonnelMedical(String id, String nom, String prenom, String mdp, String specialite) {
        this.ID = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.specialite = specialite;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
