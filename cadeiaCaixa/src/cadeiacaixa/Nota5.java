/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiacaixa;

/**
 *
 * @author Serenna
 */
public class Nota5 extends AbstractCaixa {

    @Override
    protected int handleSaque(int valor) {
        qtdNotas = 0;
        while(valor>=5){
            valor-=5;
            qtdNotas++;
        }
        if(qtdNotas >0){
            System.out.println(qtdNotas+" notas de R$ 5 entregues");
        }
        return valor;
    }
    
}
