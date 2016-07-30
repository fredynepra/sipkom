/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import mvc.view.MainUI;
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
public class DataCyclomaticTest {
    
    public DataCyclomaticTest() {
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
     * Test of readLogCyclomatic method, of class DataCyclomatic.
     */
    /*@Test
    public void testReadLogCyclomatic() {
        System.out.println("readLogCyclomatic");
        MainUI view = null;
        DataCyclomatic instance = new DataCyclomatic();
        instance.readLogCyclomatic(view);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of deleteLogCyclomatic method, of class DataCyclomatic.
     */
    /*@Test
    public void testDeleteLogCyclomatic() {
        System.out.println("deleteLogCyclomatic");
        DataCyclomatic instance = new DataCyclomatic();
        instance.deleteLogCyclomatic();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getFileExistCC method, of class DataCyclomatic.
     */
    @Test
    public void testGetFileExistCC() {
        System.out.println("getFileExistCC");
        DataCyclomatic instance = new DataCyclomatic();
        boolean expResult = true;
        boolean result = instance.getFileExistCC();
        assertEquals(expResult, result);
    }
    
}
