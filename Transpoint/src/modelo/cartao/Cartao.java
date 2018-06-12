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
    public Categoria categoria;
    public int codigo;
    public boolean disponivel;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo>=0) this.saldo = saldo;
        else System.out.println("Saldo inválido");
    }
    
    public Cartao(String descricao){
                
            ArrayList linhasCadastradas = new ArrayList();
            linhasCadastradas = null;  //tratar a passagem da lista por parametro
            
            Categoria category = new Categoria(descricao,linhasCadastradas);
            this.categoria = category;

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