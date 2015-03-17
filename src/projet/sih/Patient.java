/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author Tommy
 */
public class Patient {
    private DPI dpi;
    private double IPP;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private Location location;
    private String medGen;
    private String adGen;
 
    /**
     * constructeur de classe Patient
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param sexe
     * @param adresse
     * @param medGen
     * @param adGen 
     */
    public Patient(String nom, String prenom, Date dateNaissance, Sexe sexe, String adresse,String medGen, String adGen){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        if(sexe == Sexe.F){
            this.sexe = "F";
        }
        if(sexe == Sexe.H){
            this.sexe = "H";
        }
        this.adresse=adresse; 
        this.medGen = medGen;
        this.adGen = adGen;
        this.dpi = new DPI();
        //récupérer les 2 derniers chiffres de l'année de naissance
        int dizaines = (this.dateNaissance.getYear() % 100) / 10;
        int unites = this.dateNaissance.getYear() % 10;
        CHUPP.setCompteur(CHUPP.getCompteur()+1);
        this.IPP = ((dizaines*10+unites)*Math.pow(10,7))+CHUPP.getCompteur();
    }

    public Patient(double IPP, String nom, String prenom, Date dateNaissance, String sexe, String adresse) {
        this.IPP = IPP;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse=adresse;        
        this.dpi = new DPI();
    }

    /**
     * @return the IPP
     */
    public String getIPP() {        
        DecimalFormat decimalPrintFormat = new DecimalFormat("###0");
        return decimalPrintFormat.format(this.IPP);
    }

    /**
     * @param IPP the IPP to set
     */
    public void setIPP(double IPP) {
        this.IPP = IPP;
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
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getDateNaissanceString() {
        String s;
        if(dateNaissance.getMonth()<=9){
            if(dateNaissance.getDate()>=10){
            s=(dateNaissance.getYear()+1900)+"-0"+(dateNaissance.getMonth()+1)+"-"+dateNaissance.getDate();
            }else{
                s=(dateNaissance.getYear()+1900)+"-0"+(dateNaissance.getMonth()+1)+"-0"+dateNaissance.getDate();
            }
        }else{
            if(dateNaissance.getDate()>=10){
            s=(dateNaissance.getYear()+1900)+"-"+(dateNaissance.getMonth()+1)+"-"+dateNaissance.getDate();
            }else{
                s=(dateNaissance.getYear()+1900)+"-"+(dateNaissance.getMonth()+1)+"-0"+dateNaissance.getDate();
            }
        }
        return s;
    }
    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the dpi
     */
    public DPI getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(DPI dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the medGen
     */
    public String getMedGen() {
        return medGen;
    }

    /**
     * @return the adGen
     */
    public String getAdGen() {
        return adGen;
    }
}
