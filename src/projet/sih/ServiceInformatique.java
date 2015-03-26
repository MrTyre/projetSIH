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
public class ServiceInformatique {
    //attributs
    private DefaultListModel<Informaticien> informaticiens;

    /**
     * @return the informaticiens
     */
    public DefaultListModel<Informaticien> getInformaticiens() {
        return informaticiens;
    }

    /**
     * @param informaticiens the informaticiens to set
     */
    public void setInformaticiens(DefaultListModel<Informaticien> informaticiens) {
        this.informaticiens = informaticiens;
    }
    
    
}
