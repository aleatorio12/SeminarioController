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
    
   private int idfase;
   private String nombre;
   private Date fechaInicio;
   private Date fechaFinalizacion;
   private Character estado;
   
   
   private List<Fase> listFase= null;
   
   @Inject
    private FaseFacade faseFacade;
    @PostConstruct
    public void init (  ){
        faseFacade.findAll();
    }
    
     public String cmdCreate(){
        return "/faces/fase/fase.xhtml";
    }

    public String registrarFase(){
        Fase fase = new Fase();
        fase.setNombre(nombre);
        fase.setFechaInicio(fechaInicio);
        fase.setFechaFinalizacion(fechaFinalizacion);
        fase.setEstado(estado);
        
        faseFacade.create(fase);
        return "index.xhtml";
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
    

   
   
    
    
}
