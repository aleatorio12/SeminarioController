/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Fase;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.FaseFacade;

/**
 *
 * @author dany
 */
@Named
@SessionScoped
public class FaseController implements Serializable {

    private static final long serialVersionUID = -8215235587134021444L;
    //DATOS FASE

    private String nombre=null;
    private Date fechaInicio=null;
    private Date fechaFinalizacion=null;
    private String estado=null;
    
    private Fase fase=null;
    
    private boolean popup = true;
 
    public String cmdRegresar(){
        return "#{request.contextPath}/faces/fase/fase.xhtml";
    
    }
    
    private List<Fase> list = null;

    public List<Fase> getList() {
        return list;
    }

    public void setList(List<Fase> list) {
        this.list = list;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public boolean isPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }


    
    
    
    @Inject
    private FaseFacade FaseFacade;
        
    @PostConstruct
    public void init(){
        
    list=FaseFacade.findAll();
                
    }
    
    public String cmdCrear(){
    return "./crearfase.xhtml";
    }
    
     public String cmdModificar(Fase fase) {
         this.fase=fase;
         nombre=fase.getNombre();
         fechaInicio=fase.getFechaInicio();
         fechaFinalizacion=fase.getFechaFinalizacion();
         estado=fase.getEstado();
    return "edit.xhtml";
    }
     
    
    public String cmdRegistrar(){
        Fase fase = new Fase ();
        fase.setNombre(nombre);
        fase.setFechaInicio(fechaInicio);
        fase.setFechaFinalizacion(fechaFinalizacion);
        fase.setEstado(estado);
        FaseFacade.create(fase);
                return "fase.xhtml";
        
    }
    
     public String cmdUpdate(){
        Fase fase = new Fase ();
        fase.setNombre(nombre);
        fase.setFechaInicio(fechaInicio);
        fase.setFechaFinalizacion(fechaFinalizacion);
        fase.setEstado(estado);
        FaseFacade.edit(fase);
                return "fase.xhtml";
        
    }

}