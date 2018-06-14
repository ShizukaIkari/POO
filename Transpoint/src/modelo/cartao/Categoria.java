/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cartao;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0403
 */


import java.util.ArrayList;

/**
 *
 * @author 20161bsi0403
 */
public class Categoria {         
    public boolean limiteDiario ;        //Se possui ou não
    public int qtdDiaria;  // SE classe possui limite diário, qual é o numero?  R:6,2
    public String tipo; //Vale transporte, Passe Facil, idoso... etc
    private boolean gratuita;
    private ArrayList<String> linhasCadastradas = null;
    private double desconto = 0;  
    
    public Categoria(String descricao){
        //Verifica se a descriçao condiz com alguma das categorias gratuitas
        if((descricao.equalsIgnoreCase("Idoso")) || (descricao.equalsIgnoreCase("PasseLivre")) || (descricao.equalsIgnoreCase("Servico")) ||(descricao.equalsIgnoreCase("EstudanteGratuito"))){
            setGratuita(true);      
            if((descricao.equalsIgnoreCase("EstudanteGratuito"))){  //Particularidade da classe: limitediario (2)
                setLimiteDiario(true);
                setQtdDiaria(2);
            }
            else{
                setLimiteDiario(false);     //As outras classes gratuitas não tem limite diário
            }
        }
        else{
            setGratuita(false);     //Se a classe não é grauita, ela é paga
        }
        // Categorias pagas que possuem limite diário:
        if((descricao.equalsIgnoreCase("Estudante")) || descricao.equalsIgnoreCase("ValeTransporte")){
            setLimiteDiario(true);
            setQtdDiaria(6);
            if(descricao.equalsIgnoreCase("Estudante")){  //O estudante possui desconto de 50% 
                this.desconto = 0.5;
            }
        }
        setTipo(descricao);             /*ATENÇÃO Não fazemos tratamento de erros no caso "descrição inválida"*/
        
    }

    public void setLimiteDiario(boolean limiteDiario) {
        this.limiteDiario = limiteDiario;
    }
    public void setQtdDiaria(int l){
        if (this.limiteDiario) this.qtdDiaria = l;
        else System.out.println("Operação ilegal. Categoria não tem limite diário"); // Não precisa disso mas talvez precisemos tentar
    }
    
    public int getQtdDiaria() {
        return qtdDiaria;
    }
        
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo=tipo; 
    }
    
    public boolean getLimiteDiario(){
        return limiteDiario;
    }
    
     public boolean isGratuita() {
        return gratuita;
    }

    public void setGratuita(boolean gratuito) {
        this.gratuita = gratuito;
        if(!this.gratuita){          //Supõe-se :
            setLimiteDiario(true);
        }
    }
    
    public ArrayList<String> getLinhasCadastradas() { //FALTA TRATAR AS LINHAS QUE SERAO PASSADAS COMO PARAMETRO EM CARTAO
        
        if(this.gratuita)   return linhasCadastradas;
        else {
            System.out.println("Erro, estudante não gratuito não possui linhas cadastradas"); //desnecessário
            return null;
        }
    }

    public void setLinhasCadastradas(ArrayList<String> linhasCadastradas) {
        if (this.gratuita) this.linhasCadastradas = linhasCadastradas;
        else System.out.println("Erro, estudante não gratuito"); // Melhorar isso aqui HEUEHE(tratamento de erros necessario?)
    }
}