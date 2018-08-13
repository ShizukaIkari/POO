/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc3poo;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0284
 */
public class Pedido {
    private String formaPagamento;
    private int numPedido;
    private String status;
    private ArrayList<ItemPedido> compras;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ItemPedido> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<ItemPedido> compras) {
        this.compras = compras;
    }
    
    public double calculaValor(){
        double v = 0;
        for(ItemPedido item : this.compras){
            v+=item.getValor();
        }
        return v;
    }
}
