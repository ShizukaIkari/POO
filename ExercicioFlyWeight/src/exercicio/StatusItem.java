/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

/**
 *
 * @author Serenna
 */
public class StatusItem {
    private Estado estado;
    private boolean podeCancelar;
    private boolean compraConcluida;
    
    public StatusItem (Estado s, boolean cancel, boolean shop){
        this.estado = s;
        this.podeCancelar = cancel;
        this.compraConcluida = shop;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isPodeCancelar() {
        return podeCancelar;
    }

    public void setPodeCancelar(boolean podeCancelar) {
        this.podeCancelar = podeCancelar;
    }

    public boolean isCompraConcluida() {
        return compraConcluida;
    }

    public void setCompraConcluida(boolean compraConcluida) {
        this.compraConcluida = compraConcluida;
    }

    static enum Estado {
        CARRINHO, FECHADO, PAGO, ENVIADO , ENTREGUE;
    }
    
    
    
}
