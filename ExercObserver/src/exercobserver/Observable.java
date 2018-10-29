/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercobserver;

import java.util.ArrayList;

/**
 *
 * @author 20161bsi0284
 */
public class Observable {
    private ArrayList<Observer> monitores = new ArrayList();
    
    public void addObserver(Observer ob){
        this.monitores.add(ob);
    }
    public void deleteObserver(Observer ob){
        monitores.remove(ob);
    }
    
    public void notifyObserver(){
        for(Observer obs : monitores){
            obs.update(this);
        }
    }
}
