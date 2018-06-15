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
    public int linha;
    public String data;
    public double valor;
    public Cartao cartaoUtilizado;
    
    public Tarifa(int linha, Passagem p, Cartao c){
        
    }

    public void setData() {
        Date dataTarifa = new Date();
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        this.data = dtHora.format(dataTarifa);
    }
    
}
