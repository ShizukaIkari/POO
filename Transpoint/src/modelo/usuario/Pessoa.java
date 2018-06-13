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
public class Pessoa {
    public String nome;
    public Endereco endereco;
    public String telefone;
    private int cpf;
    private String dataNascimento;
    private RG rg;
    private CartaoCredito cartaoCredito = null;
    

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public RG getRG(){
        return this.rg;
    }
    
    public void setRG(String dataNascimento, String orgaoEmissor, String codigo){
        this.rg.setDataNascimento(dataNascimento);
        this.rg.setOrgaoEmissor(orgaoEmissor);
        this.rg.setCodigo(codigo);
        
    }
    
    public CartaoCredito getCartaoCredito(){
        return this.cartaoCredito;
    }
    
    public void setCartaoCredito(int numero, String dataVencimento){
        this.cartaoCredito.setNumero(numero);
        this.cartaoCredito.setDataVencimento(dataVencimento);
        this.cartaoCredito.setTitular(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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