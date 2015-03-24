/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sih;

import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tommy
 */
public class DMTest {
    
    public DMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getObservationsPH method, of class DM.
     */
    @Test
    public void testGetObservationsPH() {
        System.out.println("getObservationsPH");
        DM instance = new DM();
        DefaultListModel<Observation> expResult = null;
        DefaultListModel<Observation> result = instance.getObservationsPH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrescriptionsPH method, of class DM.
     */
    @Test
    public void testGetPrescriptionsPH() {
        System.out.println("getPrescriptionsPH");
        DM instance = new DM();
        DefaultListModel<Prescription> expResult = null;
        DefaultListModel<Prescription> result = instance.getPrescriptionsPH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultatsPH method, of class DM.
     */
    @Test
    public void testGetResultatsPH() {
        System.out.println("getResultatsPH");
        DM instance = new DM();
        DefaultListModel<String> expResult = null;
        DefaultListModel<String> result = instance.getResultatsPH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLettreSortie method, of class DM.
     */
    @Test
    public void testGetLettreSortie() {
        System.out.println("getLettreSortie");
        DM instance = new DM();
        String expResult = "";
        String result = instance.getLettreSortie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherPrescriptions method, of class DM.
     */
    @Test
    public void testAfficherPrescriptions() {
        System.out.println("afficherPrescriptions");
        Patient patient = null;
        DM instance = new DM();
        String expResult = "";
        String result = instance.afficherPrescriptions(patient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherObservationsPH method, of class DM.
     */
    @Test
    public void testAfficherObservationsPH() {
        System.out.println("afficherObservationsPH");
        Patient patient = null;
        DM instance = new DM();
        String expResult = "";
        String result = instance.afficherObservationsPH(patient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherRDV method, of class DM.
     */
    @Test
    public void testAfficherRDV() {
        System.out.println("afficherRDV");
        Patient patient = null;
        DM instance = new DM();
        String expResult = "";
        String result = instance.afficherRDV(patient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherResultats method, of class DM.
     */
    @Test
    public void testAfficherResultats() {
        System.out.println("afficherResultats");
        Patient patient = null;
        DM instance = new DM();
        String expResult = "";
        String result = instance.afficherResultats(patient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
