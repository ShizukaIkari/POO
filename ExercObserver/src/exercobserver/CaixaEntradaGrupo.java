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
public class CaixaEntradaGrupo extends Observable {
    private String mensagem;
    
    public void setNovaMensagem(String msg){
        mensagem = msg;
        notifyObserver();
    }
    
    public String getMensagem(){
        return this.mensagem;
    }
}
