/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import japa.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import mvc.model.ASTParser;
import mvc.model.UniqueOperand;
import mvc.model.UniqueOperator;
import mvc.view.MainUI;
import mvc.controller.SystemControl;
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
public class SystemControlTest {
    
    private SystemControl SystemControl = new SystemControl();
    private ASTParser ASTParser = new ASTParser();
    private MainUI MainUI = new MainUI();
    private UniqueOperator UniqueOperator = new UniqueOperator();
    private UniqueOperand UniqueOperand = new UniqueOperand();
    
    public SystemControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*@Before
    public void setUp() throws IOException, FileNotFoundException, ParseException {
        SystemControl.hitungKompleksitas(MainUI, ASTParser, UniqueOperator, UniqueOperand);
    }*/
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFileValid method, of class SystemControl.
     */
    /*@Test
    public void testGetFileValid() {
        System.out.println("getFileValid");
        SystemControl instance = new SystemControl();
        boolean expResult = false;
        boolean result = instance.getFileValid();
        assertEquals(expResult, result);

    }*/

    /**
     * Test of hitungKompleksitas method, of class SystemControl.
     */
    /*@Test
    public void testHitungKompleksitas() throws Exception {
        System.out.println("hitungKompleksitas");
        MainUI ui = null;
        ASTParser astParser = null;
        UniqueOperator uOprt = null;
        UniqueOperand uOprn = null;
        SystemControl instance = null;
        instance.hitungKompleksitas(ui, astParser, uOprt, uOprn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of lihatHasilHalstead method, of class SystemControl.
     */
    /*@Test
    public void testLihatHasilHalstead() throws Exception {
        System.out.println("lihatHasilHalstead");
        MainUI ui = null;
        ASTParser astParser = null;
        UniqueOperator uOprt = null;
        UniqueOperand uOprn = null;
        SystemControl instance = null;
        instance.lihatHasilHalstead(ui, astParser, uOprt, uOprn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of lihatHasilCyclomatic method, of class SystemControl.
     */
    /*@Test
    public void testLihatHasilCyclomatic() throws Exception {
        System.out.println("lihatHasilCyclomatic");
        MainUI ui = null;
        ASTParser astParser = null;
        UniqueOperator uOprt = null;
        UniqueOperand uOprn = null;
        SystemControl instance = null;
        instance.lihatHasilCyclomatic(ui, astParser, uOprt, uOprn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of deleteLog method, of class SystemControl.
     */
    /*@Test
    public void testDeleteLog() throws Exception {
        System.out.println("deleteLog");
        MainUI ui = null;
        ASTParser astParser = null;
        UniqueOperator uOprt = null;
        UniqueOperand uOprn = null;
        SystemControl instance = null;
        instance.deleteLog(ui, astParser, uOprt, uOprn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
