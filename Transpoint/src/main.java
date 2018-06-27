/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vitorsalzman
 */

import visao.TelaInicial;


public class main{
    public static void main(String args[]) {
    
    TelaInicial inicTranspoint = new TelaInicial();
    
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicTranspoint.setVisible(true);
            }
        });
}
    
    
}


  