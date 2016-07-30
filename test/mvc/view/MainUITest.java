/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import javax.swing.JTextArea;
import mvc.model.DataCyclomatic;
import mvc.model.DataHalstead;
import mvc.model.DataParsingCode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredy Revolusioner
 */
public class MainUITest {
    
    public MainUITest() {
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
     * Test of logArea method, of class MainUI.
     */
    /*@Test
    public void testLogArea() {
        System.out.println("logArea");
        MainUI instance = new MainUI();
        JTextArea expResult = null;
        JTextArea result = instance.logArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of showParsingCode method, of class MainUI.
     */
    @Test
    public void testShowParsingCode() {
        System.out.println("showParsingCode");
        DataParsingCode dataPC = null;
        MainUI instance = new MainUI();
        instance.showParsingCode(dataPC);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of showLogHalstead method, of class MainUI.
     */
    /*@Test
    public void testShowLogHalstead() {
        System.out.println("showLogHalstead");
        DataHalstead dataHV = null;
        MainUI instance = new MainUI();
        instance.showLogHalstead(dataHV);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of showLogCyclomatic method, of class MainUI.
     */
    /*@Test
    public void testShowLogCyclomatic() {
        System.out.println("showLogCyclomatic");
        DataCyclomatic dataCC = null;
        MainUI instance = new MainUI();
        instance.showLogCyclomatic(dataCC);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of main method, of class MainUI.
     */
    /*@Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        MainUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
