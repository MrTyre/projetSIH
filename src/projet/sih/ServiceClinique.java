/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class ServiceClinique extends Service {
    private String specialite;
    private static int compteur;

    /**
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }
    public static int getIDServiceClinique() throws SQLException{
        String sql="select * from service_clinique";
        ResultSet resultat=CHUPP.getRequete(sql);
        resultat.last();
        compteur = resultat.getInt("idsc") + 1;
        return compteur;
    }
    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
  
    /**
     * constructeur de la classe ServiceClinique
     */
    public ServiceClinique(){
        this.setChefDeService(new PH());
        this.setPraticiens(new DefaultListModel<PH>());
        this.setPatients(new DefaultListModel<Patient>());
        this.setInternes(new DefaultListModel<Interne>());
        this.setInfirmiers(new DefaultListModel<PersonnelInfirmier>());
    }
    
     /**
     * constructeur de la classe ServiceClinique
     */
    
    public ServiceClinique(String specialite, PH chefDeService, DefaultListModel<PH> praticiens, DefaultListModel<Patient> patients,DefaultListModel<PersonnelInfirmier> infirmiers, DefaultListModel<Interne> internes){
        this.setSpecialite(specialite);
        this.setChefDeService(chefDeService);
        this.setPraticiens(praticiens);
        this.setPatients(patients);
        this.setInternes(internes);
        this.setInfirmiers(infirmiers);
    }

    /**
     * crée un DM pour un patient s'il n'en a pas déjà un
     * @param p, le patient sujet du DM
     */
    public void creerDM(Patient p){
        if (p.getDpi().getDm() == null){
            p.getDpi().setDm(new DM());
        }
    }
}
