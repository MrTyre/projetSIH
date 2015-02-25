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
import org.odftoolkit.odfdom.doc.OdfTextDocument;
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
        CHUPP chupp = new CHUPP();
        Date date = new Date(new java.util.Date().getTime());
        Patient p1 = new Patient("Riviere", "Tommy", new Date(94, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
        System.out.println(p1.getIPP());
        Patient p2 = new Patient("Riviere", "Tommy", new Date(1985, 9, 23), Sexe.H, new Adresse("27 rue de la Poterie", 44690, "Chateauthebaud", Pays.France));
        System.out.println(p2.getIPP());
        PH ph1 = new PH("10000005","Albou","Léon","test","Cardiologie");
        GenererLettreSortie(ph1,p1,date);
    }
    
    static public void GenererLettreSortie(PH ph1,Patient p1,Date d) throws Exception{
        DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat df2 = new SimpleDateFormat("hh:mm");
        // Create a text document from a standard template (empty documents within the JAR)
        OdfTextDocument odt = OdfTextDocument.newTextDocument();

        // Append text to the end of the document. 
        odt.newImage(new File("C:/Users/Tommy/Documents/GitHub/Images/CHUPP.jpg").toURI());
        odt.newParagraph();
        odt.addText("Dr."+ph1.getNom()+" "+ph1.getPrenom());
        odt.newParagraph();
        odt.addText("CHU de Princeton-Plainsboro");
        odt.newParagraph();
        odt.addText("Tel : XX.XX.XX.XX.XX");
        odt.newParagraph();
        odt.newParagraph();
        odt.newParagraph();
        odt.newParagraph();
        odt.addText("__________________________________________________________________ le "+df1.format(d)+",");
        odt.newParagraph();
        odt.newParagraph();
        odt.newParagraph();
        odt.addText("\n\nObjet : Sortie de Mr."+p1.getNom()+" "+p1.getPrenom());
        odt.newParagraph();        
        odt.newParagraph();
        odt.addText("\n\nJe soussigné Dr."+ph1.getNom()+" "+ph1.getPrenom()+", autorise le patient "+p1.getNom()+" "+p1.getPrenom()+" a sortir du Service "+ph1.getSpecialite()+" à compter du "+df1.format(d)+" à "+df2.format(d)+"h.");
        odt.newParagraph();
        odt.addText("Cette sortie intervient suite au diagnostic suivant :");
        odt.newParagraph();
        //odt.addText(jTextFieldDiagnostic.getText());
        odt.newParagraph();
        odt.addText("Le patient "+p1.getNom()+" "+p1.getPrenom()+" est autorisé à sortir du Service "+ph1.getSpecialite()+" suite à l'administration du traitement suivant :");
        odt.newParagraph();
        //odt.addText(jTextFieldTraitement.getText());
        odt.newParagraph();
        odt.newParagraph();
        odt.newParagraph();
        odt.newParagraph();
        odt.addText("Cordialement,");
        odt.newParagraph();
        odt.newParagraph();
        odt.addText("Dr "+ph1.getNom()+" "+ph1.getPrenom());
        odt.newParagraph();
        //odt.addText("Signature :"+jTextFieldSignature.getText());       

        // Save document
        odt.save("C:/Users/Tommy/Documents/GitHub/Projet SIH - Netbeans/Lettres/Lettre de sortie de Mr " + p1.getNom() +" " + p1.getPrenom() +", né le "+df1.format(p1.getDateNaissance())+".odt");
    }

}
