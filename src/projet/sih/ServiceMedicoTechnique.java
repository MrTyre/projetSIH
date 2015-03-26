/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tommy
 */
public abstract class ServiceMedicoTechnique extends Service {
    //attributs
    private String nom;
    private static int compteur;
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * méthode pour donner un nouvel ID unique à un nouveau service médico technique
     * @return compteur
     * @throws SQLException 
     */
    public static int getIDServiceMedicoTechnique() throws SQLException{
        String sql="select * from service_medico_technique";
        ResultSet resultat=CHUPP.getRequete(sql);
        resultat.last();
        compteur = resultat.getInt("idsmt") + 1;
        return compteur;
    }
    /*

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
