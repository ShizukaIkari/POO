/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercobserver;

/**
 *
 * @author 20161bsi0284
 */
public class MembroWhatsapp implements Observer{
    private int numero;

    @Override
    public void update(Observable obs) {
        CaixaEntradaGrupo caixa = (CaixaEntradaGrupo) obs;
        System.out.println("Nova mensagem! "+ caixa.getMensagem());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
