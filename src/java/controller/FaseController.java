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
 * @author Cesar Cifuentes 4490-13-9410
 */
@Named
@SessionScoped
public class FaseController implements Serializable{
    
    private static final long serialVersionUID = -8215235587134021444L;
    
    

    private List<Fase> list = null;
    private Integer idfase = null;
    private String Nombre = null;
    private Date fechainicio = null;
    private Date fechafinalizacion = null;
    private String Estado = null;
    private Fase fase = null;


    public List<Fase> getList() {
        return list;
    }

    public void setList(List<Fase> list) {
        this.list = list;
    }

    public Integer getIdfase() {
        return idfase;
    }

    public void setIdfase(Integer idfase) {
        this.idfase = idfase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinalizacion() {
        return fechafinalizacion;
    }

    public void setFechafinalizacion(Date fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }
    
    

        
    @Inject
    private FaseFacade faseFacade;
    
    @PostConstruct
    public void init (){
     list = faseFacade.findAll();
    }
    
    public String cmdCrearFase(){
    Fase fase = new Fase();
    fase.setNombre(Nombre);
    fase.setFechaInicio(fechainicio);
    fase.setFechaFinalizacion(fechafinalizacion);
    fase.setEstado(Estado);
    faseFacade.create(fase);
    list = faseFacade.findAll();
    return "buscarfase.xhtml";
    }
    
    public String cmdRedirige(Fase fase){
    this.fase = fase;
    idfase = fase.getIdFase();
    Nombre = fase.getNombre();
    fechainicio = fase.getFechaInicio();
    fechafinalizacion = fase.getFechaFinalizacion();
    Estado = fase.getEstado();
    return"formModificar.xhtml";
    }
    
    public String cmdModicacionFase(){
    Fase fase = new Fase();
    fase.setNombre(Nombre);
    fase.setFechaInicio(fechainicio);
    fase.setFechaFinalizacion(fechafinalizacion);
    fase.setEstado(Estado);
    faseFacade.edit(fase);
    list = faseFacade.findAll();
        return "buscarfase.xhtml";
    }
    
     public String cmdRedirige2(Fase fase){
    this.fase = fase;
    idfase = fase.getIdFase();
    Nombre = fase.getNombre();
    fechainicio = fase.getFechaInicio();
    fechafinalizacion = fase.getFechaFinalizacion();
    Estado = fase.getEstado();
    return"formEliminar.xhtml";
    }
    
    public String cmdEliminarFase(){
    Fase fase = new Fase();
    fase.setNombre(Nombre);
    fase.setFechaInicio(fechainicio);
    fase.setFechaFinalizacion(fechafinalizacion);
    fase.setEstado(Estado);
    faseFacade.remove(fase);
    list = faseFacade.findAll();
        return "buscarfase.xhtml";
    }
}
