/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menucomposite;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0284
 */
public class MenuComposite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        ArrayList itensBebida = new ArrayList();
        ArrayList itensFood = new ArrayList();
        ArrayList itensCardapio = new ArrayList();
        
        Menu beb1 = new ItemMenu("Suco Laranja",4);
        Menu beb2 = new ItemMenu("Refrigerante",8);
        Menu food1 = new ItemMenu("Batata Frita",12);
        Menu food2 = new ItemMenu("Hamburguer",18);
        
        itensBebida.add(beb1);
        itensBebida.add(beb2);
        itensFood.add(food1);
        itensFood.add(food2);
        
        
        Menu lanche = new SubMenu("Lanche", itensFood);
        Menu bebida = new SubMenu("Bebidas", itensBebida);
        
        itensCardapio.add(lanche);
        itensCardapio.add(bebida);
        Menu cardapio = new SubMenu("Cardapio", itensCardapio);  //Kinda assembler
        
        

    }
    
}
