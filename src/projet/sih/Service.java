/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.util.List;

/**
 *
 * @author Tommy
 */
public abstract class Service {
    private PH chefDeService;
    private List<PH> praticiens;
    private List<Etudiant> etudiants;
    private List<Patient> patients;
    private ServiceClinique sc;
    private ServiceMedicoTechnique smt;

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
    public List<PH> getPraticiens() {
        return praticiens;
    }

    /**
     * @param praticiens the praticiens to set
     */
    public void setPraticiens(List<PH> praticiens) {
        this.praticiens = praticiens;
    }

    /**
     * @return the etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * @param etudiants the etudiants to set
     */
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
