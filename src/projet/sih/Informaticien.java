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
public class Informaticien extends PersonnelMedical{


    public Informaticien(String id, String nom, String prenom, String mdp) {
        super(id, nom, prenom, mdp);
        super.specialite = "Technicien Informaticien";
    }
    
}
