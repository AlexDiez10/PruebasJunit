/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package calculadorasmp;

/**
 *
 * @author andre
 */
public class CalculadoraSMP {

    public static void main(String[] args) {
        String question = Operations.MakeFormula();
        System.out.println(question);
        String ret = Operations.Solve(question);
        System.out.println(ret);
    }
}
    