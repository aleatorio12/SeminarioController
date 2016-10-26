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
    private String idProyecto = null;
    
    private List<EnteProyecto> listEnteProyecto = null;

    private Ente ente;
    private Proyecto proyecto;
    private EnteProyecto enteProyecto;
    
    @Inject
    private EnteProyectoFacade enteProyectoFacade;
    @PostConstruct
    public void init (){
        listEnteProyecto = enteProyectoFacade.findAll();
    }
    
    public String cmdCreate(){
        return "/faces/enteproyecto/crear.xhtml";
    }

    public String registrarEnte(){
/*        Ente ente = new Ente();
        ente.setNombre(nombre);
        ente.setDireccion(direccion);
        enteFacade.create(ente);
        listEnte = enteFacade.findAll();
*/
        return "/faces/ente/ente.xhtml";

    }

    public Integer getIdEnte() {
        return idEnte;
    }

    public void setIdEnte(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
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
    
        
}
