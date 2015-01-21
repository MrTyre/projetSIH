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
    private Archives a;
    //private ServiceUrgences su;

    public CHUPP(){
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
        
        a = new Archives();
        
       //su = new ServiceUrgences();
    }

}
