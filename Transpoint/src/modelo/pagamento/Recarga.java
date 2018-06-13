/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pagamento;

import modelo.cartao.Cartao;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Serenna
 */
public class Recarga {
    private double valor; //quantia desejada para incrementar saldo do cartão
    private Date dataRecarga;
    private String formaPagamento;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws Exception {
        
        if (valor<0) throw new Exception("Valor não pode ser menor a zero.");
        this.valor = valor;
    }

    public Date getDataRecarga() {
        return dataRecarga;
    }

    public void setDataRecarga(Date dataRecarga) {
        this.dataRecarga = dataRecarga;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    //Seria tipo o construtor
    public void executarRecarga(Cartao c, double valor, String pagamento){  //Criar interface para tal
        
        //Verificar se cartão, verificar se valor válido, verificar se pagamento válido
        if ( valor > 0){
            if (pagamento.equalsIgnoreCase("Cartao de Credito") ){
                //pegar informações dele e validar? what should I do
                this.formaPagamento = "Cartao de Credito"; 
                this.valor = valor;
                c.setSaldo(c.getSaldo()+valor);
                this.dataRecarga = new Date();
            }
            else if (pagamento.equalsIgnoreCase("Boleto")) {
                //Validação?
                this.formaPagamento = "Boleto"; 
                this.valor = valor;
                c.setSaldo(c.getSaldo()+valor);
                this.dataRecarga = new Date();
            } else JOptionPane.showMessageDialog(null, "Método de pagamento inválido, selecione Cartão ou Boleto");
        } else JOptionPane.showMessageDialog(null, "Valor inválido, selecione uma quantia válida");
    }
}
