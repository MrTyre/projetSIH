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
public class Location {
    private Chambre chambre;
    private Lit lit;
/**
 * constructeur de la classe Location
 * @param chambre
 * @param lit 
 */
    public Location(Chambre chambre, Lit lit) {
        this.chambre = chambre;
        this.lit = lit;
    }

    /**
     * @return the chambre
     */
    public Chambre getChambre() {
        return chambre;
    }

    /**
     * @param chambre the chambre to set
     */
    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    /**
     * @return the lit
     */
    public Lit getLit() {
        return lit;
    }

    /**
     * @param lit the lit to set
     */
    public void setLit(Lit lit) {
        this.lit = lit;
    }
}
