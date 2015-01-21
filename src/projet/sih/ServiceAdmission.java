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
public class ServiceAdmission {
    private PH chefDeService;
    private DefaultListModel<Secretaire> secretaires;

    /**
     * @return the chefDeService
     */
    public PH getChefDeService() {
        return chefDeService;
    }

    /**
     * @param chefDeService the chefDeService to set
     */
    public void setChefDeService(PH chefDeService) {
        this.chefDeService = chefDeService;
    }

    /**
     * @return the secretaires
     */
    public DefaultListModel<Secretaire> getSecretaires() {
        return secretaires;
    }

    /**
     * @param secretaires the secretaires to set
     */
    public void setSecretaires(DefaultListModel<Secretaire> secretaires) {
        this.secretaires = secretaires;
    }    
}
