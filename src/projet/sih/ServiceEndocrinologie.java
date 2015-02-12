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
public class ServiceEndocrinologie extends ServiceClinique {
    
    public ServiceEndocrinologie(){
        this.setSpecialite("Endocrinologie");
        this.setChambres(new DefaultListModel<Chambre>());
        this.getChambres().setSize(15);
    }
}
