/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

/**
 *
 * @author Salzman
 */
public class CartaoCredito {
    private int numero;
    private String dataVencimento;
    private Pessoa titular;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setTitular(Pessoa titular) {
        this.titular.nome = titular.getNome();
    }

    public int getNumero() {
        return numero;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getTitular() {
        return titular.getNome();
    }
    
    
    
}
