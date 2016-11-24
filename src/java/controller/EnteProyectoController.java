/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Ente;
import entities.EnteProyecto;
import entities.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.EnteFacade;
import stateless.EnteProyectoFacade;
import stateless.ProyectoFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped


public class EnteProyectoController implements Serializable{

    private static final long serialVersionUID = 2330429320034603128L;

    //Campos de la tabla Ente
    
    private Integer idEnte = null;
    private Integer idProyecto = null;
    
    private List<EnteProyecto> listEnteProyecto = null;
    private List<Ente> listEnte = null;
    private List<Proyecto> listProyecto = null;

    private Ente ente = null;
    private Proyecto proyecto = null;
    private String rol = null;
    private EnteProyecto enteProyecto = null;
    
    @Inject
    private EnteProyectoFacade enteProyectoFacade;
    @Inject
    private EnteFacade enteFacade;
    @Inject
    private ProyectoFacade proyectoFacade;
    @PostConstruct
    public void init (){
        listEnteProyecto = enteProyectoFacade.findAll();
        listEnte = enteFacade.findAll();
        listProyecto = proyectoFacade.findAll();
    }
    
    public String cmdCreate(){
        return "/faces/enteproyecto/crear.xhtml";
    }

    public String registrarEnteProyecto(){
        
        EnteProyecto enteProyecto = new EnteProyecto(this.idEnte, this.idProyecto);
        enteProyecto.setEnte1(ente);
        enteProyecto.setProyecto1(proyecto);
        enteProyecto.setRol(rol);
        enteProyectoFacade.create(enteProyecto);
        resetearCampos();
        return "/enteproyecto/enteproyecto.xhtml?faces-redirect=true";

    }

    private void resetearCampos(){
        this.ente = null;
        this.proyecto = null;
        this.enteProyecto = null;
        this.idEnte = null;
        this.idProyecto = null;
        this.rol = null;
        listEnteProyecto = enteProyectoFacade.findAll();
        listProyecto = proyectoFacade.findAll();
        listEnte = enteFacade.findAll();
    }
    
    public Integer getIdEnte() {
        return idEnte;
    }

    public void setIdEnte(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public List<EnteProyecto> getListEnteProyecto() {
        return listEnteProyecto;
    }

    public void setListEnteProyecto(List<EnteProyecto> listEnteProyecto) {
        this.listEnteProyecto = listEnteProyecto;
    }

    public Ente getEnte() {
        return ente;
    }

    public void setEnte(Ente ente) {
        this.ente = ente;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public EnteProyecto getEnteProyecto() {
        return enteProyecto;
    }

    public void setEnteProyecto(EnteProyecto enteProyecto) {
        this.enteProyecto = enteProyecto;
    }

    /**
     * @return the listEnte
     */
    public List<Ente> getListEnte() {
        return listEnte;
    }

    /**
     * @param listEnte the listEnte to set
     */
    public void setListEnte(List<Ente> listEnte) {
        this.listEnte = listEnte;
    }

    /**
     * @return the listProyecto
     */
    public List<Proyecto> getListProyecto() {
        return listProyecto;
    }

    /**
     * @param listProyecto the listProyecto to set
     */
    public void setListProyecto(List<Proyecto> listProyecto) {
        this.listProyecto = listProyecto;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
        
}
