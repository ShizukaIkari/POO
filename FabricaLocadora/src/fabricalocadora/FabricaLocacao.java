/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricalocadora;

/**
 *
 * @author 20161bsi0284
 */
public class FabricaLocacao {
    public static Object gerarEntidade(String tipo){
        if(tipo.equalsIgnoreCase("cliente")){
            System.out.println("Cliente gerado");
            return new EntidadeCliente();
        } else if(tipo.equalsIgnoreCase("avaliacao")){
            System.out.println("Avaliação criada");
            return new EntidadeAvaliacao();
        } else if(tipo.equalsIgnoreCase("itemLocado")){
            System.out.println("Item locado gerado");
            return new EntidadeItemLocado();
        } else if(tipo.equalsIgnoreCase("visualizacao")){
            System.out.println("Visualização gerada");
            return new EntidadeVisualizacao();
        } else if(tipo.equalsIgnoreCase("Filme")){
            System.out.println("Filme gerado");
            return new EntidadeFilme();
        } else if(tipo.equalsIgnoreCase("locacao")){
            System.out.println("Locação gerada");
            return new EntidadeLocacao();
        } else {
            System.out.println("Nada gerado");
            return null;
        }
    }
}
