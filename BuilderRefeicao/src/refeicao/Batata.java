/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refeicao;

/**
 *
 * @author Serenna
 */
public class Batata {
    private String tamanhoPorcao;
    
    public Batata(String tamanho){
        System.out.println("Cria batata de tamanho:" + tamanho);
        this.setTamanhoPorcao(tamanho);
    }
    public String getTamanhoPorcao() {
        return tamanhoPorcao;
    }

    public void setTamanhoPorcao(String tamanhoPorcao) {
        this.tamanhoPorcao = tamanhoPorcao;
    }
    
}
