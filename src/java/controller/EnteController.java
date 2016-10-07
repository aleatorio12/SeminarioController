/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Ente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.EnteFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped


public class EnteController implements Serializable{

    private static final long serialVersionUID = 1979050895618488871L;   
    //Campos de la tabla Ente
    
    private Ente ente = null;
    
    private Integer idEnte = null;
    private String nombre = null;
    private String direccion = null;
    private Integer tipo = null;
    
    private List<Ente> listEnte = null;
    
    @Inject
    private EnteFacade enteFacade;
    @PostConstruct
    public void init (){
        listEnte = enteFacade.findAll();
    }
    
    public String cmdCreate(){
        return "/faces/ente/crearente.xhtml";
    }
    
    public String cmdModificar(Ente ente){
        this.ente = ente;
        this.idEnte = ente.getIdEnte();
        this.nombre = ente.getNombre();
        this.direccion = ente.getDireccion();
        this.tipo = ente.getTipoEnte();
        return "/faces/ente/editarente.xhtml";
    }

    public String cmdEliminar(Ente ente){
        this.ente = null;
        this.idEnte = null;
        this.nombre = null;
        this.direccion = null;
        this.tipo = null;
        enteFacade.remove(ente);
        this.listEnte = this.enteFacade.findAll();
        return "/faces/ente/ente.xhtml";
    }
    
    public String registrarEnte(){
        Ente ente = new Ente();
        ente.setNombre(nombre);
        ente.setDireccion(direccion);
        ente.setTipoEnte(tipo);
        enteFacade.create(ente);
        listEnte = enteFacade.findAll();
        return "/faces/ente/ente.xhtml";
    }

    public String actualizarEnte(){
        this.ente.setIdEnte(idEnte);
        this.ente.setNombre(nombre);
        this.ente.setDireccion(direccion);
        this.ente.setTipoEnte(tipo);
        enteFacade.edit(ente);
        return "/faces/ente/ente.xhtml";
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

    public Ente getEnte() {
        return ente;
    }

    public void setEnte(Ente ente) {
        this.ente = ente;
    }
    
    /**
     * @return the idEnte
     */
    public int getIdEnte() {
        return idEnte;
    }

    /**
     * @param idEnte the idEnte to set
     */
    public void setIdEnte(int idEnte) {
        this.idEnte = idEnte;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
}
