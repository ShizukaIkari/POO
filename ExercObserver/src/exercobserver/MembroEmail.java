/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercobserver;

/**
 *
 * @author 20161bsi0284
 */
public class MembroEmail implements Observer {
    private String email;

    @Override
    public void update(Observable obs) {
        CaixaEntradaGrupo caixa = (CaixaEntradaGrupo) obs;
        System.out.println("Nova mensagem! "+ caixa.getMensagem());
       
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
