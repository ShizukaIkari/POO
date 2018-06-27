/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cartao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * 
 */

 //Isso vai se tornar uma interface gráfica. Tirar dúdidas com prof
public class BloqueioCartao {
    private String dataHora;
    private static Date data;
    private static final  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String motivo; 
    
   
    public void pedirBloqueio(Cartao card, String reason){
        data = new Date();
        dataHora = dateFormat.format(data);
        motivo = reason;
        card.setDisponivel(false);
    }
}
