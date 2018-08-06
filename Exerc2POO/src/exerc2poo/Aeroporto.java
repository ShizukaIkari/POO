/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc2poo;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0284
 */
public class Aeroporto {
    private int codigo;
    private String nome;
    private boolean internacional;
    private ArrayList<Aeroporto> conexoesFrom; //Vôos partindo dele direto para elem. da lista
    private ArrayList<Aeroporto> conexoesOf; //Vôos dos elems da lista direto para este
    private ArrayList<Aviao> avioesPatio;
    
    public boolean isInternacional(Aeroporto a){
        return internacional;
    }
    public void setInternacional(boolean b){
        this.internacional = b;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public boolean equals(Aeroporto a, Aeroporto b){
        return a.getCodigo() == b.getCodigo();
    }
    
    public boolean isOnPatio(String prefPlane){
        for(Aviao av: avioesPatio){
            if(av.getPrefix().equalsIgnoreCase(prefPlane)){
                return true;
            }
        }
        return false;
    }
}
