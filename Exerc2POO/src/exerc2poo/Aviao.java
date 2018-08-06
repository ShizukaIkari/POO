/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc2poo;

/**
 *
 * @author 20161bsi0284
 */
public class Aviao {
    private String prefix;
    private String modelo;
    private String fabricante;
    private int numAssentos;
    private String codigo;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }
    
    public void setCodigo(Aviao a){
        this.codigo = toString(a);
    }
    
    String toString(Aviao a){
        String idPlane = this.prefix+"-"+this.fabricante+"-"+this.modelo+"-"+this.numAssentos;
        return idPlane;
    }
}
