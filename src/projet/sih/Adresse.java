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
public class Adresse {
    private String libelleRue;
    private int codePostal;
    private String ville;
    private String pays;
    
    public Adresse(String libelle, int codePostal, String ville, String pays){
        this.libelleRue = libelle;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    /**
     * @return the libelleRue
     */
    public String getLibelleRue() {
        return libelleRue;
    }

    /**
     * @param libelleRue the libelleRue to set
     */
    public void setLibelleRue(String libelleRue) {
        this.libelleRue = libelleRue;
    }

    /**
     * @return the codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
}
