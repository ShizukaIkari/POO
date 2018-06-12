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
    
   
    public void pedirBloqueio(Cartao card){
        data = new Date();
        dataHora = dateFormat.format(data);
        JOptionPane.showMessageDialog(null, "Isto deixará seu cartão indisponível no app, deseja continuar?"); // Fazer um Sim ou Não
        motivo = JOptionPane.showInputDialog(null, "Informe o motivo:");
        card.setDisponivel(false);
        /*Guardar no banco de dados: saldo do cartão, código, disponibilidade, data e hora ?, motivo*/
    }
}
