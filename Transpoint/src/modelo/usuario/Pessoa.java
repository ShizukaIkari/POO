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
 * @author Salzman
 */
public abstract class Pessoa {
    public String nome;
    public ArrayList<Cartao> cartoesTranscol;
    public Endereco endereco;
    public String telefone;
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
    /* Não é a classe pessoa que gerencia isso
    public void addCartao(Cartao card){
        cartoesTranscol.add(card);
    }
    
    public boolean removeCartao(ArrayList<Cartao> listaCartoes, Cartao card){
        
        boolean removido = false;
        for(int i =0; i<listaCartoes.size();i++){
            if(Cartao.comparaCartao(listaCartoes.get(i),card)){ //SE DER, IMPLEMENTAR A FUNÇÃO
                listaCartoes.remove(i);
                removido = true;
            }
        }
        return removido;
        
    }*/ 
    
    public void listarCartoes(ArrayList<Cartao> cards){
        for(Cartao card : cards){
            System.out.println(" 1 - " + card.categoria.getTipo() + ";");
        }
    }
    
    public String getEndereco(){
        return endereco.getEndereco();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
    
    
}