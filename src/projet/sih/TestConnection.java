/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
//public class TestConnection {
    //thomas = pd
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws SQLException {
//
//        MyDBConnection connection = new MyDBConnection();
//        connection.init();
//        connection.getMyConnection();
//
//
//        
//        try {
//            String sql = "SELECT * FROM Patient";
//            ResultSet resultat = connection.getStatement().executeQuery(sql);
//            while (resultat.next()) {
//            int id = resultat.getInt(1);
//            String nom = resultat.getString(2);
//            String prenom = resultat.getString(3);
//            java.sql.Date date = resultat.getDate(4);
//            String sexe =resultat.getString(5);
//            String adresse=resultat.getString(6);
//            int row = resultat.getRow();
//            System.out.println("Données contenues dans la ligne " + row);
//            System.out.println("ipp : " + id + " nom : " + nom
//                    + " prenom : " + prenom + " date de naissance : " + date 
//                    + " sexe : " + sexe +" adresse : " + adresse);
//        }
//        } catch (Exception e) {
//            System.out.println("Failed to get Statement");
//            e.printStackTrace();
//        }
////        while (resultat.next()) {
////            int id = resultat.getInt(1);
////            String nom = resultat.getString(2);
////            double prix = resultat.getDouble(3);
////            java.sql.Date date = resultat.getDate(4);
////            int row = resultat.getRow();
////            System.out.println("Données contenues dans la ligne " + row);
////            System.out.println("id : " + id + " nom : " + nom
////                    + " prix : " + prix + " date : " + date);
////        }
//    }
//
//}
