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
public class CHUPP {

    private DefaultListModel<ServiceClinique> scs;
    private DefaultListModel<ServiceMedicoTechnique> smts;
    private ServiceAdmission sa;
    private ServiceInformatique si;
    private Archives a;
    private static double compteur;
    //private ServiceUrgences su;

    public CHUPP(){
        compteur = 1;
        scs = new DefaultListModel<ServiceClinique>();
        smts = new DefaultListModel<ServiceMedicoTechnique>();
        
        scs.addElement(new ServiceBacteriologie());
        scs.addElement(new ServiceCardiologie());
        scs.addElement(new ServiceCytologie());
        scs.addElement(new ServiceChirurgieGenerale());
        scs.addElement(new ServiceDermatologie());
        scs.addElement(new ServiceEndocrinologie());
        scs.addElement(new ServiceGeriatrie());
        scs.addElement(new ServiceGynecologie());
        scs.addElement(new ServiceNeurologie());
        scs.addElement(new ServicePediatrie());
        scs.addElement(new ServiceOncologie());
        scs.addElement(new ServicePsychiatrie());
        scs.addElement(new ServicePneumologie());
        
        smts.addElement(new LaboImmunologie());
        smts.addElement(new LaboMicrobiologie());
        smts.addElement(new LaboHematologie());
        smts.addElement(new LaboAnapathologie());
        smts.addElement(new ServiceRadiologie());
        smts.addElement(new ServiceAnesthesieRea());
        
        sa = new ServiceAdmission();
        si = new ServiceInformatique();
        a = new Archives();
        
       //su = new ServiceUrgences();
    }

    /**
     * @return the scs
     */
    public DefaultListModel<ServiceClinique> getScs() {
        return scs;
    }

    /**
     * @return the smts
     */
    public DefaultListModel<ServiceMedicoTechnique> getSmts() {
        return smts;
    }

    /**
     * @return the sa
     */
    public ServiceAdmission getSa() {
        return sa;
    }

    /**
     * @return the a
     */
    public Archives getA() {
        return a;
    }
    
    
    /**
     * @return the compteur
     */
    public static double getCompteur() {
        return compteur;
    }

    /**
     * @param aCompteur the compteur to set
     */
    public static void setCompteur(double aCompteur) {
        compteur = aCompteur;
    }
    
    public void creerServiceClinique(String specialite, PH chefDeService, DefaultListModel<PH> praticiens, DefaultListModel<Patient> patients,DefaultListModel<PersonnelInfirmier> infirmiers, DefaultListModel<Interne> internes){
        ServiceClinique sc = new ServiceClinique(specialite,chefDeService,praticiens,patients,infirmiers,internes);
        scs.addElement(sc);
    }

    /**
     * @return the si
     */
    public ServiceInformatique getSi() {
        return si;
    }
}
