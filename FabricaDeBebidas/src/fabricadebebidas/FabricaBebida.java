/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricadebebidas;

/**
 *
 * @author 20161bsi0284
 */
public class FabricaBebida {
    public static Bebida servirBebida(String drink){
        
        if (drink.equalsIgnoreCase("cafe")){
            System.out.println("Café servido!");
            return new Cafe();
        } else if (drink.equalsIgnoreCase("refrigerante")){
            System.out.println("Refrigerante servido!");
            return new Refrigerante();
        } else if (drink.equalsIgnoreCase("cha")){
            System.out.println("Chá servido!");
            return new Cha();
        } else if (drink.equalsIgnoreCase("suco")){
            System.out.println("Suco servido!");
            return new Suco();
        } else {
            System.out.println("Está em falta...");
        }
        return null;
    }
}
