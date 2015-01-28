/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.sih;

import java.util.Date;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tommy
 */
public class Prescription {
    private String nomPrescription;
    private PH phPrescripteur;
    private Date datePrescription;
    private DefaultListModel<Medicament> medicaments;

    /**
     * @return the phPrescripteur
     */
    public PH getPhPrescripteur() {
        return phPrescripteur;
    }

    /**
     * @param phPrescripteur the phPrescripteur to set
     */
    public void setPhPrescripteur(PH phPrescripteur) {
        this.phPrescripteur = phPrescripteur;
    }

    /**
     * @return the datePrescription
     */
    public Date getDatePrescription() {
        return datePrescription;
    }

    /**
     * @param datePrescription the datePrescription to set
     */
    public void setDatePrescription(Date datePrescription) {
        this.datePrescription = datePrescription;
    }

    /**
     * @return the nomPrescription
     */
    public String getNomPrescription() {
        return nomPrescription;
    }

    /**
     * @param nomPrescription the nomPrescription to set
     */
    public void setNomPrescription(String nomPrescription) {
        this.nomPrescription = nomPrescription;
    }

    /**
     * @return the medicaments
     */
    public DefaultListModel<Medicament> getMedicaments() {
        return medicaments;
    }

    /**
     * @param medicaments the medicaments to set
     */
    public void setMedicaments(DefaultListModel<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
