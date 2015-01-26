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
    private DefaultListModel<Prescription> prescriptionsPH;
    private DefaultListModel<String> observationsPI;
    private DefaultListModel<String> resultatsPH;
    private String lettreSortie;

    public DM() {
        observationsPH = new DefaultListModel<String>();
        prescriptionsPH = new DefaultListModel<Prescription>();
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
    public DefaultListModel<Prescription> getPrescriptionsPH() {
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

    public String afficherPrescriptions() {
        String s = "";
        for (int i = 0; i < this.prescriptionsPH.getSize(); i++) {
            s += "Prescription du " + this.prescriptionsPH.get(i).getDatePrescription() + ", Dr." + this.prescriptionsPH.get(i).getPhPrescripteur().toString();
            for (int j = 0; j < this.prescriptionsPH.get(i).getMedicaments().getSize(); j++) {
                s += "\n\t\t-" + this.prescriptionsPH.get(i).getMedicaments().get(j).getNomMedoc();
                s += "\t\t\t" + this.prescriptionsPH.get(i).getMedicaments().get(j).getPosologie() + this.prescriptionsPH.get(i).getMedicaments().get(j).getUnitePosologie() + " jusqu'au " + this.prescriptionsPH.get(i).getMedicaments().get(j).getDateFin().toString();
            }
            s += "\n-----------------------------------------------------------------------------------";
        }
        return s;
    }
}
