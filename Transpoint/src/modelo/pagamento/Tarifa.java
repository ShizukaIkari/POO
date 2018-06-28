/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pagamento;

import java.text.DateFormat;
import java.util.Date;
import modelo.cartao.Cartao;

/* Essa classe efetivamente retira o valor da passagem*/
public class Tarifa {
    private int linha;
    private String data;
    private double valor;
    private int codCartUtilizado;
    
    public Tarifa(int linha,Cartao c) throws Exception{
        Passagem p = new Passagem();
        this.setData();
        this.linha = linha;
        this.codCartUtilizado = c.getCodigo();
        
        if (c.isDisponivel()){        //Cartão deve estar disponível para uso
            valor = p.getValorPassagem() * c.getCategoria().getDesconto();
            System.out.println("Valor passagem: "+valor);
            try{
                c.movimentaSaldo(-valor);
            } catch (Exception e){
                c.setDisponivel(false);
                throw e;
            }
        } else throw new Exception ("Cartão indisponível, operação negada.");
        
        
    }
    public Tarifa(){
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodCartUtilizado() {
        return codCartUtilizado;
    }

    public void setCodCartUtilizado(int codCartUtilizado) {
        this.codCartUtilizado = codCartUtilizado;
    }
    
    public void setData() {
        Date dataTarifa = new Date();
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        this.data = dtHora.format(dataTarifa);
    }
    
}
