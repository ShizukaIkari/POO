/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import exercicio.StatusItem.Estado;
import java.util.HashMap;

/**
 *
 * @author Serenna
 */
public class FlyweightStatusItem {
    private static HashMap<Estado,StatusItem>  cache = new HashMap<>();
    
    public FlyweightStatusItem (){
        StatusItem carrinho = new StatusItem(StatusItem.Estado.CARRINHO, true, false);
        this.addStatus(carrinho);
        StatusItem compra = new StatusItem(StatusItem.Estado.PAGO, true, false);
        this.addStatus(compra);
        StatusItem caminho = new StatusItem(StatusItem.Estado.ENVIADO, true, false);
        this.addStatus(caminho);
        StatusItem recebido = new StatusItem(StatusItem.Estado.ENTREGUE, true, false);
        this.addStatus(recebido);
        StatusItem closed = new StatusItem(StatusItem.Estado.FECHADO, true, false);
        this.addStatus(closed);
    }
    
    public void addStatus(StatusItem stats){
        this.cache.put(stats.getEstado(),stats);
    }
    
    public static StatusItem get(Estado keyEstado){
        return (StatusItem)cache.get(keyEstado);
    }
}
