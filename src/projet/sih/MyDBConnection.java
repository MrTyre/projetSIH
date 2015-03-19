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

    private ResultSet resultat;
    private Connection myConnection;
    private Statement statement;
    public MyDBConnection() {

    }

    public void init() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            myConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/MyDB", "root", "Genesis2014");
            statement = myConnection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);

        } catch (Exception e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }

    public ResultSet getResultat() {
        return resultat;
    }
    
    public Statement getStatement() {
        return statement;
    }

    public Connection getMyConnection() {
        return myConnection;
    }

    public void close(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }

        }
    }

    public void close(java.sql.Statement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void destroy() {

        if (myConnection != null) {

            try {
                myConnection.close();
            } catch (Exception e) {
            }

        }
    }

}
