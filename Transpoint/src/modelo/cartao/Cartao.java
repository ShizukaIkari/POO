/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cartao;

public class Cartao {
    private Categoria categoria;
    private int codigo;
    private boolean disponivel;
    private double saldo;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }    
    
    public Cartao(int codigo, boolean disponivel, double saldo, String descricao, int idUser){
        Categoria category = new Categoria(descricao);
        this.categoria = category;
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.saldo = saldo;
        this.idUser = idUser;
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

    //Saldo vai ser descontado de tarifa (passar valor negativo) ou recarregado por recarga.
    public void setSaldo(double valor) throws Exception {
        if(this.saldo + valor > 0){
            this.saldo += valor;
        } else throw new Exception("Saldo insuficiente.");
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