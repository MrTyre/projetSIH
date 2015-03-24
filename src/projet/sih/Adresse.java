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
    private String codePostal;
    private String ville;
    private Pays pays;

    /** constructeur de la classe Adresse
     * 
     * @param libelle
     * @param codePostal
     * @param ville
     * @param pays 
     */
    public Adresse(String libelle, String codePostal, String ville, Pays pays) {
        this.libelleRue = libelle;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    /**
     * @return the libelleRue
     *          le nom de la rue
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
     *          le code postal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal(String codePostal) {
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
    public Pays getPays() {
        return pays;
    }
/** crée une chaine de caractères correspondant à l'adresse
 * 
 * @return adresse 
 */
    public String getAdresse() {
        String adresse = libelleRue+ "  "+ codePostal+"  "+ville+"  "+pays;
        return adresse;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
