/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pagamento;

import java.text.DateFormat;
import modelo.cartao.Cartao;
import java.util.Date;

/**
 *
 * @author Serenna
 */
public class Recarga {
    private double valor; //quantia desejada para incrementar saldo do cartão
    private String dataHoraRecarga; //Salvando hora e data da recarga
    private String formaPagamento;
    
    public Recarga(Cartao c, double val) throws Exception{
        if (val<0){
            throw new Exception("Recarga não pode ser negativa");
        }else{
            setDataRecarga();
            this.valor = val;
            c.movimentaSaldo(val);
            c.setDisponivel(true);
        }
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws Exception {
        if (valor<0) throw new Exception("Valor não pode ser menor a zero.");
        this.valor = valor;
    }

    public String getDataRecarga() {
        return dataHoraRecarga;
    }

    public void setDataRecarga() {
        Date hoje = new Date();
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        this.dataHoraRecarga = dtHora.format(hoje);
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
