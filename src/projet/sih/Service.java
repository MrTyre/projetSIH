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
    private PH chefDeService;
    private DefaultListModel<PH> praticiens;
    private DefaultListModel<Interne> internes;
    private DefaultListModel<Patient> patients;
        

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
     * @return the praticiens
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
     * @return the etudiants
     */
    public DefaultListModel<Interne> getInternes() {
        return internes;
    }

    /**
     * @param etudiants the etudiants to set
     */
    public void setInternes(DefaultListModel<Interne> internes) {
        this.internes = internes;
    }

    /**
     * @return the patients
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
    
    public void creerServiceClinique(String specialite, PH chefDeService, DefaultListModel<PH> praticiens, DefaultListModel<Patient> patients, DefaultListModel<Interne> internes){
        ServiceClinique sc = new ServiceClinique(specialite,chefDeService,praticiens,patients,internes);
    }
}
