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
public class ServiceAnesthesieRea extends ServiceMedicoTechnique {

    private String nom;

    public ServiceAnesthesieRea(){
        this.nom = "Anesthesie & Reanimation";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
}
