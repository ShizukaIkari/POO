/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

/**
 *
 * @author Salzman
 */
public class RG {
    private String dataNascimento;
    private String orgaoEmissor;
    private String codigo;
    

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
}
