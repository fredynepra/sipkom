/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.List;
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
public class UniqueOperatorTest {
    
    public UniqueOperatorTest() {
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
     * Test of resetTotalUnikOprt method, of class UniqueOperator.
     */
    /*
    @Test
    public void testResetTotalUnikOprt() {
        System.out.println("resetTotalUnikOprt");
        UniqueOperator instance = new UniqueOperator();
        instance.resetTotalUnikOprt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getTotalUnikOprt method, of class UniqueOperator.
     */
    
    @Test
    public void testGetTotalUnikOprt() {
        System.out.println("getTotalUnikOprt");
        UniqueOperator instance = new UniqueOperator();
        int expResult = 0;
        int result = instance.getTotalUnikOprt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUnikOprt method, of class UniqueOperator.
     */
    /*
    @Test
    public void testGetUnikOprt() {
        System.out.println("getUnikOprt");
        Object[] keys = null;
        UniqueOperator instance = new UniqueOperator();
        Object[] expResult = null;
        Object[] result = instance.getUnikOprt(keys);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of hitungUnikOprt method, of class UniqueOperator.
     */
    /*
    @Test
    public void testHitungUnikOprt() {
        System.out.println("hitungUnikOprt");
        List<String> lUnikOprt = null;
        UniqueOperator instance = new UniqueOperator();
        instance.hitungUnikOprt(lUnikOprt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
