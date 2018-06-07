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
public class PessoaFisica extends Pessoa {
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
    
}
    
