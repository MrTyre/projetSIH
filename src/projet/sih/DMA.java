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
public class DMA {

    private DefaultListModel<Consultation> consultations;
    private DefaultListModel<Hospitalisation> hospitalisations;

    public DMA() {
        consultations = new DefaultListModel<Consultation>();
        hospitalisations = new DefaultListModel<Hospitalisation>();
    }

    /**
     * @return the consultations
     */
    public DefaultListModel<Consultation> getConsultations() {
        return consultations;
    }

    /**
     * @param consultations the consultations to set
     */
    public void setConsultations(DefaultListModel<Consultation> consultations) {
        this.consultations = consultations;
    }

    /**
     * @return the hospitalisations
     */
    public DefaultListModel<Hospitalisation> getHospitalisations() {
        return hospitalisations;
    }

    /**
     * @param hospitalisations the hospitalisations to set
     */
    public void setHospitalisations(DefaultListModel<Hospitalisation> hospitalisations) {
        this.hospitalisations = hospitalisations;
    }

    public String afficherConsultations() {
        String s = "";
        for (int i = 0; i < this.consultations.getSize(); i++) {
            s += "n° de séjour : " + this.consultations.get(i).getNumSejour() + "\t\t\tDate : " + this.consultations.get(i).getDate().toString();
            s += "\nPH Responsable : " + this.consultations.get(i).getPhResp().toString();
            s += "\nNature de la prestation : " + this.consultations.get(i).getNaturePrestation();
            s += "\n-----------------------------------------------------------------------------------";
        }
        return s;
    }
    
    public String afficherHospitalisations() {
        String s = "";
        for (int i = 0; i < this.hospitalisations.getSize(); i++) {
            s += "n° de séjour : " + this.hospitalisations.get(i).getNumSejour() + "\t\t\tDurée hospitalisation : " + this.hospitalisations.get(i).dureeHospitalisation();
            s += "\nPH Responsable : " + this.hospitalisations.get(i).getPhResp().toString();
            s += "\nNature de la prestation : " + this.hospitalisations.get(i).getNaturePrestation();
            s += "\n-----------------------------------------------------------------------------------";
        }
        return s;
    }
}
