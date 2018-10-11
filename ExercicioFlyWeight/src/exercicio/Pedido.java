/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.util.ArrayList;

/**
 *
 * @author Serenna
 */
public class Pedido {
    private ArrayList<Item> itensPedidos;
    
    public void addItemPedido(Item item){
        itensPedidos.add(item);
    }
    public Pedido(){
        this.itensPedidos = new ArrayList<Item>();
    }
}
