/*
 * MyDBConnection.java
 *
 * Created on 2005/01/16, 10:50
 */
package projet.sih;

import java.sql.*;

/**
 * Cette classe permet de connecter la base de données à notre projet
 * @author Marina
 */

public class MyDBConnection {
    //attributs
    private ResultSet resultat;
    private Connection myConnection;
    private Statement statement;
    
    //constructeur par défaut
    public MyDBConnection() {

    }
    
    //initation de la connexion à la base de données
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //on instancie la connexion en passant en paramètre l'hébergeur voulu
            myConnection = DriverManager.getConnection(
                    //adresse de connexion en local
                   "jdbc:mysql://localhost:3306/mydb", "root", "Genesis2014");
                   //adresse de connexion au serveur
                   // "jdbc:mysql://192.168.1.1:3306/mydb", "genesis" , "" );
            statement = myConnection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @return resultat
     */
    public ResultSet getResultat() {
        return resultat;
    }
    
    /**
     * 
     * @return statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * 
     * @return myConnection
     */
    public Connection getMyConnection() {
        return myConnection;
    }

    /**
     * 
     * @param rs 
     */
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }

        }
    }
    
    /**
     * 
     * @param stmt 
     */
    public void close(java.sql.Statement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }

        }
    }
    
    /**
     * 
     */
    public void destroy() {
        if (myConnection != null) {
            try {
                myConnection.close();
            } catch (Exception e) {
            }

        }
    }

}
