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
public class ExercObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CaixaEntradaGrupo c = new CaixaEntradaGrupo();
        MembroEmail velho = new MembroEmail();
        MembroWhatsapp bozo = new MembroWhatsapp();
        c.addObserver(velho);
        c.addObserver(bozo);
        
        c.setNovaMensagem("Comprei um chip novo!");

    }
    
}
