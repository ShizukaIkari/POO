/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cartao;

import java.util.ArrayList;

/**
 *
 * @author Salzman
 */
public class Cartao {
    private Categoria categoria;
    private int codigo;
    private boolean disponivel;
    private double saldo;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }
    
    
    
    
    
    public Cartao(String descricao){
                
           
            
            Categoria category = new Categoria(descricao);
            this.categoria = category;

    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Categoria getCategoria() {
        return categoria;
    }

  
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo>=0) this.saldo = saldo;
        else System.out.println("Saldo inválido");
    }
    
    public String getCategoria(Cartao card) {
        return card.categoria.getTipo();
    }

    public int getCodigo(Cartao card) {
        return codigo;
    }

    public boolean isDisponivel(Cartao card) {
        return disponivel;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

   
    
      
    
    
    
    
}