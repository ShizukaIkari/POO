/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptercliente.model;

import lib.ClienteExterno;

/**
 *
 * @author 20161bsi0284
 */
public class AdapterClienteExterno implements ICliente {
    
    private ClienteExterno ce;
    
    public AdapterClienteExterno(ClienteExterno c) {
        this.ce = c;
    }
    @Override
    public String getNomeCompleto() {
        String nomeCompleto;
        nomeCompleto = ce.getNome()+" "+ce.getSobreNome();
                
        return nomeCompleto;
    }

    @Override
    public void setNomeCompleto(String nomeCompleto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefone() {
        String telefone = ce.getDddTelefone()+" "+ce.getTelefone();
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        String dddTel[] = telefone.split(" ");
        this.ce.setDddTelefone(dddTel[0]);
        this.ce.setTelefone(dddTel[1]);
    }

    @Override
    public String getEmail() {
        return this.ce.getEmail();
    }

    @Override
    public void setEmail(String email) {
        this.ce.setEmail(email);
    }

    @Override
    public String getCelular() {
        String celular = this.ce.getDddCelular()+" "+this.ce.getCelular();
        return celular;
    }

    @Override
    public void setCelular(String celular) {
        this.ce.setDddCelular(celular.substring(0,2));
        this.ce.setCelular(celular.substring(3,9));
    }
    
}
