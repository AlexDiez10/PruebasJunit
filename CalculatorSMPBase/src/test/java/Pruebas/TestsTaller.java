/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Pruebas;

import calculadorasmp.Operations;
import static calculadorasmp.Operations.MakeFormula;
import static calculadorasmp.Operations.Solve;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class TestsTaller {
    
    public TestsTaller() {
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

    @org.junit.jupiter.api.Test
    public void testFormulaFormat(){
        String formula = MakeFormula();
        assertTrue(formula.matches("\\d+[\\+\\-\\/]\\d+([\\+\\-\\/]\\d+)?"));
    }
    
    
    @org.junit.jupiter.api.Test
    public void testFormulaNumberRange(){
       String formula = Operations.MakeFormula();  // Llamada al método de la clase Operations
       String[] numbers = formula.split("[+\\-*/]");  // Separa la fórmula en números

       for(String number : numbers){
           try {
               int num = Integer.parseInt(number.trim());  // Intenta convertir el número
               assertTrue(num >= 1 && num <= 99, "Número fuera de rango: " + num);
           } catch (NumberFormatException e) {
               fail("Formato de número inválido: " + number);
           }
       }
    }

    
    @org.junit.jupiter.api.Test
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
    
    @org.junit.jupiter.api.Test
    public void testSolveRes(){
        String result = Solve("10-10");
        assertEquals("10-10=0", result);
    }
    
    @org.junit.jupiter.api.Test
    public void testSolveMul(){
        String result = Solve("10*10");
        assertEquals("10*10=100", result);
    }
    
    @org.junit.jupiter.api.Test
    public void testSolveDiv(){
        String result = Solve("10/10");
        assertEquals("10/10=1", result);
    }
    
    public void testSolveDivZero() {
        // Espera que se lance una ArithmeticException cuando se intente dividir por cero
        assertThrows(ArithmeticException.class, () -> {
            Operations.Solve("10/0");
        }, "Se esperaba una excepción de división por cero, pero no se lanzó.");
    }
    
    @org.junit.jupiter.api.Test
    public void testSolveMulOperators(){
        String result = Solve("10*10/2");
        assertEquals("10*10/2=50", result);
    }

    


}
