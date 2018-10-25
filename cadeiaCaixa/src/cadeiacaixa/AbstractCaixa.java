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
public abstract class AbstractCaixa implements CaixaAutomatico{
    private CaixaAutomatico nota;
    protected int qtdNotas;
    
    @Override
    public void setNextNota(CaixaAutomatico nota) {
        this.nota = nota;
    }
    //processPagamento
    @Override
    public void processaSaque(int valor) {
        if(valor >0){
            valor = handleSaque(valor);
            if(nota != null){
                this.nota.processaSaque(valor);
            }
        }
    }
    
    protected abstract int handleSaque(int valor);
    
    public static void realizaSaque(int valorSaque){
        CaixaAutomatico n100 = new Nota100();
        CaixaAutomatico n50 = new Nota50();
        CaixaAutomatico n20 = new Nota20();
        CaixaAutomatico n10 = new Nota10();
        CaixaAutomatico n5 = new Nota5();
        CaixaAutomatico n2 = new Nota2();
        CaixaAutomatico n1 = new Nota1();
        
        n100.setNextNota(n50);
        n50.setNextNota(n20);
        n20.setNextNota(n10);
        n10.setNextNota(n5);
        n5.setNextNota(n2);
        n2.setNextNota(n1);
        
        n100.processaSaque(valorSaque);
        
        
    }
    
}
