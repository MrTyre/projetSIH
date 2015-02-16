/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class ServiceClinique extends Service {
    private String specialite;

    /**
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    public ServiceClinique(){
        this.setChefDeService(new PH());
        this.setPraticiens(new DefaultListModel<PH>());
        this.setPatients(new DefaultListModel<Patient>());
        this.setInternes(new DefaultListModel<Interne>());
    }
    
    public ServiceClinique(String specialite, PH chefDeService, DefaultListModel<PH> praticiens, DefaultListModel<Patient> patients,DefaultListModel<PersonnelInfirmier> infirmiers, DefaultListModel<Interne> internes){
        this.setSpecialite(specialite);
        this.setChefDeService(chefDeService);
        this.setPraticiens(praticiens);
        this.setPatients(patients);
        this.setInternes(internes);
        this.setInfirmiers(infirmiers);
    }
    
    public void creerDM(Patient p){
        if (p.getDpi().getDm() == null){
            p.getDpi().setDm(new DM());
        }
    }
}
