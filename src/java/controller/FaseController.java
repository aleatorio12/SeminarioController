/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Fase;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author dany
 */
@Named
@SessionScoped
public class FaseController implements Serializable {

    private static final long serialVersionUID = -8215235587134021444L;
    
    private List<Fase> list = null;

    public List<Fase> getList() {
        return list;
    }

    public void setList(List<Fase> list) {
        this.list = list;
    }
    
    
    
    
}
