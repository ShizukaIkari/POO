/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc3poo;

/**
 *
 * @author Serenna
 */
public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private int codigo;
    private double valor;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        if (valor >=0){
            this.valor = valor;
        } else {
            //Exception, mas pra ficar simples:
            System.out.println("Valor negativo");
        }
        
    }
    
    public void calculaSubTotal(){
        setValor(this.produto.getPrecoUni()*this.quantidade);
    }
    
}
