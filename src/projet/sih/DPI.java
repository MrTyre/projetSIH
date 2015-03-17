/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class DPI {
    private DMA dma;
    private DM dm;
    private DefaultListModel<Prestation> prestations;
 /**
  * constructeur de la classe DPI
  */
    public DPI(){
        dma = new DMA();
        dm = new DM();
    }

    /**
     * @return the dma
     */
    public DMA getDma() {
        return dma;
    }

    /**
     * @param dma the dma to set
     */
    public void setDma(DMA dma) {
        this.dma = dma;
    }

    /**
     * @return the dm
     */
    public DM getDm() {
        return dm;
    }

    /**
     * @param dm the dm to set
     */
    public void setDm(DM dm) {
        this.dm = dm;
    }

    /**
     * crée une liste de prestations
     * @return the prestations
     */
    public DefaultListModel<Prestation> getPrestations() {
        return prestations;
    }

    /**
     * @param prestations the prestations to set
     */
    public void setPrestations(DefaultListModel<Prestation> prestations) {
        this.prestations = prestations;
    }
}
