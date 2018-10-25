/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiacaixa;
import javax.swing.JOptionPane;
/**
 *
 * @author Serenna
 */
public class CadeiaCaixa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dinheiro;
        dinheiro = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser sacado:"));
        if(dinheiro>0){
            AbstractCaixa.realizaSaque(dinheiro);
        } else {
            JOptionPane.showMessageDialog("Digite um valor válido! (Inteiro e maior que zero.)");
        }
        
    }
    
}
