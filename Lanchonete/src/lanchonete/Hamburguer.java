/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete;

/**
 *
 * @author 20161bsi0284
 */
public class Hamburguer extends Produto {
    private String tipo;

    public Hamburguer(String tipo, double precoUni, String descricao, int codigo) {
        super(precoUni, descricao, codigo);
        this.tipo = tipo;
    }
    public Hamburguer(){
        
    }
     
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
