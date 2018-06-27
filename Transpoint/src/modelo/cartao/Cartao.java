/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cartao;

import modelo.pagamento.Passagem;

public class Cartao {
    private Categoria categoria;
    private int codigo;
    private boolean disponivel;
    private double saldo;
    private int cpfUser;
 
    public Cartao(int codigo, boolean disponivel, double saldo, String descricao, int cpfUser){
        this.categoria = new Categoria(descricao);
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.saldo = saldo;
        this.cpfUser = cpfUser;
    }
    
    public Cartao(String categoria){
        this.categoria = new Categoria(categoria);
    }

    public void setCpfUser(int cpfUser) {
        this.cpfUser = cpfUser;
    }
    
    public int getCpfUser() {
        return cpfUser;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getSaldo() {
        return saldo;
    }

    //Saldo vai ser descontado de tarifa (passar valor negativo) ou recarregado por recarga.
    public void setSaldo(double valor) throws Exception{
        if ((this.saldo += valor )<0){
            throw new Exception("Saldo insuficiente");
        }else{
            this.saldo += valor;
        }
        
    }
    
    public String getTipoCategoria() {
        return this.categoria.getTipo();
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /*Caso não gratuita, verifica se o saldo consegue pagar a passagem (conside
    rando possíveis descontos), se não conseguir, torna-se indisponível indepen
    dente do boolean passado
    */
    public void setDisponivel(boolean disponivel) {
        Passagem p = new Passagem();
        if(this.categoria.isGratuita()){
            this.disponivel = disponivel;
        } else if (((this.saldo - (p.getValorPassagem()*this.categoria.getDesconto()))<0) || this.saldo == 0){
            this.disponivel = false;
        } else this.disponivel = disponivel;
    }

}