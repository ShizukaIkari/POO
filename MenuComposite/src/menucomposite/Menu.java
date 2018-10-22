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
public abstract class Menu {
    
    private String descricao;
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public abstract void addMenu(Menu n);
    
    public abstract void removeMenu(Menu n);
    
    public abstract ArrayList<Menu> getMenus();
}
