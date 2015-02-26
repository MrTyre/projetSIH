/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import projet.sih.*;

/**
 *
 * @author Tommy
 */
public class TestFonctionnalCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
//        CHUPP chupp = new CHUPP();
//        Date date = new Date(new java.util.Date().getTime());
//        Patient p1 = new Patient("Riviere", "Tommy", new Date(94, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
//        System.out.println(p1.getIPP());
//        Patient p2 = new Patient("Riviere", "Tommy", new Date(1985, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
//        System.out.println(p2.getIPP());
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);
    }
}
