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

    private DefaultListModel<Observation> observationsPH;
    private DefaultListModel<Prescription> prescriptionsPH;
    private DefaultListModel<Resultat> resultatsPH;
    private String lettreSortie;

    public DM() {
        observationsPH = new DefaultListModel<Observation>();
        prescriptionsPH = new DefaultListModel<Prescription>();
        resultatsPH = new DefaultListModel<Resultat>();
        lettreSortie = null;
    }

    /**
     * @return the observationsPH
     */
    public DefaultListModel<Observation> getObservationsPH() {
        return observationsPH;
    }

    /**
     * @return the prescriptionsPH
     */
    public DefaultListModel<Prescription> getPrescriptionsPH() {
        return prescriptionsPH;
    }

    /**
     * @return the resultatsPH
     */
    public DefaultListModel<Resultat> getResultatsPH() {
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
            s += "Prescription du " + this.prescriptionsPH.get(i).getDatePrescription().getDate()+"/"+this.prescriptionsPH.get(i).getDatePrescription().getMonth()+"/"+this.prescriptionsPH.get(i).getDatePrescription().getYear() + ", Dr. " + this.prescriptionsPH.get(i).getPhPrescripteur().toString()+"  : "+this.prescriptionsPH.get(i).getNomPrescription();
            for (int j = 0; j < this.prescriptionsPH.get(i).getMedicaments().getSize(); j++) {
                s += "\n\t\t- " + this.prescriptionsPH.get(i).getMedicaments().get(j).getNomMedoc();
                s += "\t\t\t" + this.prescriptionsPH.get(i).getMedicaments().get(j).getPosologie() +" "+ this.prescriptionsPH.get(i).getMedicaments().get(j).getUnitePosologie() + "/j  jusqu'au " + this.prescriptionsPH.get(i).getMedicaments().get(j).getDateFin().getDate()+"/"+this.prescriptionsPH.get(i).getMedicaments().get(j).getDateFin().getMonth()+"/"+this.prescriptionsPH.get(i).getMedicaments().get(j).getDateFin().getYear();
            }
            s += "\n------------------------------------------------------------------------------------------------------------------\n";
        }
        return s;
    }

    public String afficherObservationsPH() {
        String s = "";
        for (int i = 0; i < this.observationsPH.getSize(); i++) {
            s += "Observation du " + this.observationsPH.get(i).getDate() + ", Dr." + this.observationsPH.get(i).getPhWriter().toString();
            s += "\n------------------------------------------------------------------------------------------------------------------\n";
        }
        return s;
    }
    
    public String afficherResultatsPH(){
        String s ="";
        for (int i= 0; i <this.resultatsPH.getSize();i++){
            s += "Résultat de la prestation du " + this.resultatsPH.get(i).getPrestationAssociee().getDatePrestation().getDate()+"/"+this.resultatsPH.get(i).getPrestationAssociee().getDatePrestation().getMonth()+"/"+this.resultatsPH.get(i).getPrestationAssociee().getDatePrestation().getYear()+" : "+this.resultatsPH.get(i).getPrestationAssociee().getNaturePrestation();
            s += "\nSpécialiste : Dr."+this.resultatsPH.get(i).getPhWriter().toString();
            s += "\t\tDate de publication du résultat : "+this.resultatsPH.get(i).getDate().getDate()+"/"+this.resultatsPH.get(i).getDate().getMonth()+"/"+this.resultatsPH.get(i).getDate().getYear();
            s += "\n" + this.resultatsPH.get(i).getResultat();
            s += "\n------------------------------------------------------------------------------------------------------------------\n";
        }
        return s;
    }
}
