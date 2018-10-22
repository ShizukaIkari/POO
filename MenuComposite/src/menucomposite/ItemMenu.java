/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menucomposite;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0284
 */
public class ItemMenu extends Menu{
    
    private double preco;
    
    public ItemMenu(String descricao, double preco){
        this.setDescricao(descricao);
        this.preco = preco;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void addMenu(Menu n) {
        throw new UnsupportedOperationException("Not supported."); 
    }

    @Override
    public void removeMenu(Menu n) {
        throw new UnsupportedOperationException("Not supported."); 
    }

    @Override
    public ArrayList<Menu> getMenus() {
        throw new UnsupportedOperationException("Not supported."); 
    }
    
}
