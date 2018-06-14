/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import java.util.ArrayList;
import modelo.cartao.Cartao;

/**
 *
 * @author 20161bsi0403
 */
public class Usuario extends Pessoa {
    private int idUser;
    private String senha;
    private ArrayList<Cartao> cartoesTranscol;
    
    
    //Vai verificar no BD cartões relacionados à pessoa usuária e adicionar na lista
    public void addCartao(Cartao card){
        cartoesTranscol.add(card);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    /*
    //Caso um cartão seja cancelado ele é removido da lista
    public boolean removeCartao(ArrayList<Cartao> listaCartoes, Cartao card){
        
        boolean removido = false;
        for(int i =0; i<listaCartoes.size();i++){
            if(card.comparaCartao(listaCartoes.get(i),card)){ //SE DER, IMPLEMENTAR A FUNÇÃO
                listaCartoes.remove(i);
                removido = true;
            }
        }
        return removido;
        
    } 
    
    */
    public void listarCartoes(ArrayList<Cartao> cards){
        int i=1;
        for(Cartao card : cards){
            System.out.println(i + " - " + card.getCategoria().getTipo() + ";");
            i++;
        }
    }
        
}
