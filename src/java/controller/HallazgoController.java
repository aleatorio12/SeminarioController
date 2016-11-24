/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Hallazgo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.HallazgoFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped

public class HallazgoController implements Serializable{
    
    private static final long serialVersionUID = -5324588022963707421L;
    
    private Hallazgo hallazgo = null;
    private String comentario = null;
    private Integer idHallazgo = null;
    
    private List<Hallazgo> listHallazgo = null;
    
    @Inject
    private HallazgoFacade hallazgoFacade;
    
    @PostConstruct
    public void init(){
        setListHallazgo(hallazgoFacade.findAll());
    }
    
    public String registrarHallazgo(){
        Hallazgo nuevoHallazgo = new Hallazgo();
        nuevoHallazgo.setComentario(getComentario());
        nuevoHallazgo.setIdHallazgo(getIdHallazgo());
        hallazgoFacade.create(nuevoHallazgo);
        setListHallazgo(hallazgoFacade.findAll());
        resetearCampos();
        return "/hallazgo/hallazgo.xhtml?faces-redirect=true";
    }
    
    private void resetearCampos(){
        this.setComentario(null);
        this.setIdHallazgo(null);
        this.setHallazgo(null);
    }
    
    public String cmdModificar( Hallazgo hallazgo ){
        this.setHallazgo(hallazgo);
        this.setComentario(hallazgo.getComentario());
        this.setIdHallazgo(hallazgo.getIdHallazgo());
        return "modificar.xhtml";
    }
    
    public String actualizarHallazgo(){
        this.getHallazgo().setComentario(getComentario());
        this.getHallazgo().setIdHallazgo(getIdHallazgo());
        hallazgoFacade.edit(getHallazgo());
        return "hallazgo.xhtml";
    }

    /**
     * @return the hallazgo
     */
    public Hallazgo getHallazgo() {
        return hallazgo;
    }

    /**
     * @param hallazgo the hallazgo to set
     */
    public void setHallazgo(Hallazgo hallazgo) {
        this.hallazgo = hallazgo;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the idHallazgo
     */
    public Integer getIdHallazgo() {
        return idHallazgo;
    }

    /**
     * @param idHallazgo the idHallazgo to set
     */
    public void setIdHallazgo(Integer idHallazgo) {
        this.idHallazgo = idHallazgo;
    }

    /**
     * @return the listHallazgo
     */
    public List<Hallazgo> getListHallazgo() {
        return listHallazgo;
    }

    /**
     * @param listHallazgo the listHallazgo to set
     */
    public void setListHallazgo(List<Hallazgo> listHallazgo) {
        this.listHallazgo = listHallazgo;
    }
    
}
