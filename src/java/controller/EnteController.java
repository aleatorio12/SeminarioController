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
    
    private int idEnte;
    private String nombre;
    private String direccion;
    private char tipo;
    
    private List<Ente> listEnte = null;
    
    @Inject
    private EnteFacade enteFacade;
    @PostConstruct
    public void init (  ){
        enteFacade.findAll();
    }
    
    public String cmdCreate(){
        return "/faces/ente/ente.xhtml";
    }

    public String registrarEnte(){
        Ente ente = new Ente();
        ente.setNombre(nombre);
        ente.setDireccion(direccion);
        
        enteFacade.create(ente);
        return "index.xhtml";
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
    public char getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
}
