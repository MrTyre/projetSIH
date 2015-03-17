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
public class Chambre {
    private Lit litC;
    private Lit litF;
/** constructeur de la classe Chambre
 */
    public Chambre() {
        this.litC.setEmplacement("Coté Couloir");
        this.litF.setEmplacement("Coté Fenêtre");
    }

    /**
     * @return the litC, un lit coté couloir
     */
    public Lit getLitC() {
        return litC;
    }

    /**
     * @param litC the litC to set
     */
    public void setLitC(Lit litC) {
        this.litC = litC;
    }

    /**
     * @return the litF, un lit coté fenetre
     */
    public Lit getLitF() {
        return litF;
    }

    /**
     * @param litF the litF to set
     */
    public void setLitF(Lit litF) {
        this.litF = litF;
    }
}
