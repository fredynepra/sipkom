/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

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
public class DataHalsteadTest {
    
    public DataHalsteadTest() {
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
     * Test of readLogHalstead method, of class DataHalstead.
     */
    /*@Test
    public void testReadLogHalstead() {
        System.out.println("readLogHalstead");
        MainUI view = null;
        DataHalstead instance = new DataHalstead();
        instance.readLogHalstead(view);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of deleteLogHalstead method, of class DataHalstead.
     */
    /*@Test
    public void testDeleteLogHalstead() {
        System.out.println("deleteLogHalstead");
        DataHalstead instance = new DataHalstead();
        instance.deleteLogHalstead();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of getFileExistHV method, of class DataHalstead.
     */
    @Test
    public void testGetFileExistHV() {
        System.out.println("getFileExistHV");
        DataHalstead instance = new DataHalstead();
        boolean expResult = false;
        boolean result = instance.getFileExistHV();
        assertEquals(expResult, result);
    }
    
}
