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
public class SubMenu extends Menu{
    
    private ArrayList<Menu> lista;
    
    public SubMenu(String descricao, ArrayList itens){
        this.setDescricao(descricao);
        this.lista = itens;
    }

    @Override
    public void addMenu(Menu n) {
        this.lista.add(n);
    }

    @Override
    public void removeMenu(Menu n) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Menu> getMenus() {
        return lista;
    }
    
    
}
