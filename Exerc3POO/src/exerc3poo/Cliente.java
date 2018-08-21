/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc3poo;

import javax.swing.JOptionPane;

/**
 *
 * @author 20161bsi0284
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void realizarCompra(Pedido p){
        //simulação da escolha de forma de pagamento
        String fp = JOptionPane.showInputDialog("Escolha a forma de pagamento");
        p.setFormaPagamento(fp);
        p.setStatus("Aguardando pagamento");
        System.out.println("Enviado para email "+this.email+" pedido nº " 
                +p.getNumPedido()+". Status: " +p.getStatus());
    }
}
