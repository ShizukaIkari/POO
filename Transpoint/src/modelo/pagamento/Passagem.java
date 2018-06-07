/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pagamento;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 *
 */
public class Passagem {
    private final double valorNormal = 3.4;
    private final double valorDomingo = 2.9;
    private static Calendar cal = new GregorianCalendar();
    private int diaAtual;
    private static Date data = new Date();
    
    public double getPassagem(){
        cal.setTime(data);
        diaAtual = cal.get(Calendar.DAY_OF_WEEK);
        if (diaAtual != 1){
            return valorNormal;
        }
        else return valorDomingo;
    }
    
    
    
}
