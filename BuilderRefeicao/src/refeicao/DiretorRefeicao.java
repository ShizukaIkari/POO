
package refeicao;

/**
 *
 * @author felipe
 */
public class DiretorRefeicao {        
    
    public Refeicao preparaNaoVegetariana(String sabor, String tipoBebida, String tamanho){       
        Refeicao novaRefeicao = new Refeicao();
        NonVegetarianoBuilder refeicaoBuilder = new NonVegetarianoBuilder(novaRefeicao);        
        if(tipoBebida.equalsIgnoreCase("refrigerante"))
            refeicaoBuilder.adicionarRefrigerante(sabor);
        else
            refeicaoBuilder.adicionarSuco(sabor);                
        refeicaoBuilder.prepadaHamburgerCarne();
        refeicaoBuilder.adicionarBatata(tamanho);
        return novaRefeicao;        
    }     
    public Refeicao preparaVegetariana(String sabor, String tipoBebida, String tamanho){        
        Refeicao novaRefeicao = new Refeicao();
        VegetarianoBuilder refeicaoBuilder = new VegetarianoBuilder(novaRefeicao);        
        if(tipoBebida.equalsIgnoreCase("refrigerante"))
            refeicaoBuilder.adicionarRefrigerante(sabor);
        else
            refeicaoBuilder.adicionarSuco(sabor);     
        refeicaoBuilder.preparaHamburgerVegetariano();
        refeicaoBuilder.adicionarBatata(tamanho);
        return novaRefeicao;        
    }            
    
}
