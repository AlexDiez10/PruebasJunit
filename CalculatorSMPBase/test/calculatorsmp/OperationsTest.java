/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorsmp;

import static calculatorsmp.Operations.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro Diez
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String expResult = "";
        String result = Operations.MakeFormula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testFormulaFormat(){
        String formula = MakeFormula();
        assertTrue(formula.matches("\\d+[\\+\\-\\*/]\\d+([\\+\\-\\*/]\\d+)?"));
    }
    
    @Test
    public void testFormulaNumberRange(){
        String formula = MakeFormula();
        String[] numbers = formula.split("[\\\\+\\\\-\\\\*/]");
        for(String number : numbers){
            int num = Integer.parseInt(number);
            assertTrue(num >= 1 && num <=99);
        }
    }
    
    @Test
    public void testFormulaOperatorCount(){
        String formula = MakeFormula();
        int operatorCount = formula.replaceAll("[^\\+\\-\\*/]", "").length();
        assertTrue(operatorCount == 1 || operatorCount == 2);
    }
    
    @Test
    public void testSolveSum(){
        String result = Solve("10+10");
        assertEquals("10+10=20", result);
    }
    
    @Test
    public void testSolveRes(){
        String result = Solve("10-10");
        assertEquals("10-10=0", result);
    }
    
    @Test
    public void testSolveMul(){
        String result = Solve("10*10");
        assertEquals("10*10=100", result);
    }
    
    @Test
    public void testSolveDiv(){
        String result = Solve("10/10");
        assertEquals("10/10=1", result);
    }
    
    @Test
    public void testSolveDivZero(){
        Solve("10/0");
    }
    
    @Test
    public void testSolveMulOperators(){
        String result = Solve("10*10/2");
        assertEquals("10*10/2=50", result);
    }
}
