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
public abstract class Service {
    //attributs
    private PH chefDeService;
    private DefaultListModel<PH> praticiens;
    private DefaultListModel<Interne> internes;
    private DefaultListModel<PersonnelInfirmier> infirmiers;
    private DefaultListModel<Patient> patients;   

    /**
     * @return the chefDeService, le chef du service 
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
     * @return la liste des praticiens du service
     */
    public DefaultListModel<PH> getPraticiens() {
        return praticiens;
    }

    /**
     * @param praticiens the praticiens to set
     */
    public void setPraticiens(DefaultListModel<PH> praticiens) {
        this.praticiens = praticiens;
    }

    /**
     * @return la liste des internes du service
     */
    public DefaultListModel<Interne> getInternes() {
        return internes;
    }

    /**
     * @param internes internes to set
     */
    public void setInternes(DefaultListModel<Interne> internes) {
        this.internes = internes;
    }

    /**
     * @return la liste des patients du service
     */
    public DefaultListModel<Patient> getPatients() {
        return patients;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(DefaultListModel<Patient> patients) {
        this.patients = patients;
    }


    /**
     * @return la liste des infirmiers du service
     */
    public DefaultListModel<PersonnelInfirmier> getInfirmiers() {
        return infirmiers;
    }

    /**
     * @param infirmiers the infirmiers to set
     */
    public void setInfirmiers(DefaultListModel<PersonnelInfirmier> infirmiers) {
        this.infirmiers = infirmiers;
    }
}
