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
public class ContaCorrente extends Conta implements Tributavel {

    @Override
    public double calculaTributos() {
        double tributo = this.getSaldo()*0.1;
        return tributo;
    }
    
}
