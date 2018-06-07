/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pagamento;

import java.util.Date;
import modelo.cartao.Cartao;

/**
 *
 * 
 */
public class Tarifa {
    public int linha;
    public Date data;
    public double valor;
    public Cartao cartaoUtilizado;
    
}
