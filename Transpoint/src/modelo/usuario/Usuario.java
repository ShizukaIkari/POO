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

    public void setCartoesTranscol(ArrayList<Cartao> cartoesTranscol) {
        this.cartoesTranscol = cartoesTranscol;
    }
    
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        if(!senha.isEmpty())
            this.senha = senha;
        else throw new Exception ("Senha não pode ser vazia.");
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
    public ArrayList getCartoes(){
        return cartoesTranscol;
    }
        
}
