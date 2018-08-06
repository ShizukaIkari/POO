/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc1poo;

/**
 *
 * @author 20161bsi0284
 */
public class Exerc1POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaCorrente cTst = new ContaCorrente();
        cTst.setSaldo(100);
        System.out.println(cTst.calculaTributos());
    }
    
}
