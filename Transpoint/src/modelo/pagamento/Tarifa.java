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
    public Cartao cartaoUtilizado;  //talvez não seja necessário 
    
    public Tarifa(int linha, Passagem p, Cartao c) throws Exception{
        setData();
        this.linha = linha;
        if (c.isDisponivel()){        //Cartão deve estar disponível para uso
            valor = p.getValorPassagem() * c.getCategoria().getDesconto();
            try{
                c.setSaldo(-valor);
            } catch (Exception e){
                throw e;
            }
        }
        
        
    }

    public void setData() {
        Date dataTarifa = new Date();
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        this.data = dtHora.format(dataTarifa);
    }
    
}
