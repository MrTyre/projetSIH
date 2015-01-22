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
public class DM {
    private DefaultListModel<String> observationsPH;
    private DefaultListModel<String> prescriptionsPH;
    private DefaultListModel<String> observationsPI;
    private DefaultListModel<String> resultatsPH;
    private String lettreSortie;
    
    public DM(){
        observationsPH = new DefaultListModel<String>();
        prescriptionsPH = new DefaultListModel<String>();
        observationsPI = new DefaultListModel<String>();
        resultatsPH = new DefaultListModel<String>();
        lettreSortie = null;
    }

    /**
     * @return the observationsPH
     */
    public DefaultListModel<String> getObservationsPH() {
        return observationsPH;
    }

    /**
     * @return the prescriptionsPH
     */
    public DefaultListModel<String> getPrescriptionsPH() {
        return prescriptionsPH;
    }

    /**
     * @return the observationsPI
     */
    public DefaultListModel<String> getObservationsPI() {
        return observationsPI;
    }

    /**
     * @return the resultatsPH
     */
    public DefaultListModel<String> getResultatsPH() {
        return resultatsPH;
    }

    /**
     * @return the lettreSortie
     */
    public String getLettreSortie() {
        return lettreSortie;
    }
}
