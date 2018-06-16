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

    
  
    public Cartao(int codigo, boolean disponivel, double saldo, String descricao, int idUser){
        this.categoria = new Categoria(descricao);
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.saldo = saldo;
        this.idUser = idUser;
    }
    
    public Cartao(String categoria){
        this.categoria = new Categoria(categoria);
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdUser() {
        return idUser;
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
        } else {
            throw new Exception("Saldo insuficiente.");
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

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

   
    
      
    
    
    
    
}