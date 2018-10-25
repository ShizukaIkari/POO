/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiacaixa;

/**
 *
 * @author Serenna
 */
public interface CaixaAutomatico {
    public void setNextNota(CaixaAutomatico nota);
    public void processaSaque(int valor);
}
