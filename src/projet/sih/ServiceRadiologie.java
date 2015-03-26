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
public class ServiceRadiologie extends ServiceMedicoTechnique {
    //attributs
    private String nom;

    //constructeur
    public ServiceRadiologie(){
        this.nom = "Radiologie";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
}
