/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.sql.Date;
import java.text.DecimalFormat;
import projet.UI.*;
import projet.sih.*;

/**
 *
 * @author Tommy
 */
public class TestFonctionnalCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CHUPP chupp = new CHUPP();
        Patient p1 = new Patient("Riviere", "Tommy", new Date(1994, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
        System.out.println(p1.getIPP());
        Patient p2 = new Patient("Riviere", "Tommy", new Date(1985, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
        System.out.println(p2.getIPP());
    }

}
