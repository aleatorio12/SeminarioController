/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Proyecto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.ProyectoFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped

public class ProyectoController implements Serializable{
    private static final long serialVersionUID = 281405594834487827L;
    
    private Integer nog = null;
    private String nombre = null;
    private Double monto = null;
    private String direccion = null;
    private Date fechaInicio = null;
    private Date fechaFinalizacion = null;
    private Integer impactosocial = null;
    private Character estado = null;
    private Proyecto proyecto = null;
    
    private List<Proyecto> list = null;

    public List<Proyecto> getList() {
        return list;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    

    public void setList(List<Proyecto> list) {
        this.list = list;
    }

    public Integer getNog() {
        return nog;
    }

    public void setNog(Integer nog) {
        this.nog = nog;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Integer getImpactosocial() {
        return impactosocial;
    }

    public void setImpactosocial(Integer impactosocial) {
        this.impactosocial = impactosocial;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
    
    @Inject
    private ProyectoFacade proyectoFacade;
    
    @PostConstruct
    public void init (){
        list = proyectoFacade.findAll();
    }
    
    public String cmdInsertarProyecto(){
    Proyecto proyecto = new Proyecto();
    proyecto.setNog(nog);
    proyecto.setNombre(nombre);
    proyecto.setMonto(monto);
    proyecto.setDireccion(direccion);
    proyecto.setFechaInicio(fechaInicio);
    proyecto.setFechaFinalizacion(fechaFinalizacion);
    proyecto.setImpactoSocial(impactosocial);
    proyecto.setEstado(estado);
    proyectoFacade.create(proyecto);
    list = proyectoFacade.findAll();
    return "buscarproyecto.xhtml";
    } 
    
    public String cmdModificarProyecto(){
    Proyecto proyecto = new Proyecto();
    proyecto.setNog(nog);
    proyecto.setNombre(nombre);
    proyecto.setMonto(monto);
    proyecto.setDireccion(direccion);
    proyecto.setFechaInicio(fechaInicio);
    proyecto.setFechaFinalizacion(fechaFinalizacion);
    proyecto.setImpactoSocial(impactosocial);
    proyecto.setEstado(estado);
    proyectoFacade.edit(proyecto);
    list = proyectoFacade.findAll();
    return "modificarproyecto.xhtml";
    }
    
    public String cmdRedirigir(Proyecto proyecto){
    this.proyecto = proyecto;
    estado = proyecto.getEstado();
    impactosocial = proyecto.getImpactoSocial();
    fechaFinalizacion = proyecto.getFechaFinalizacion();
    fechaInicio = proyecto.getFechaInicio();
    direccion = proyecto.getDireccion();
    monto = proyecto.getMonto();
    nombre = proyecto.getNombre();
    nog = proyecto.getNog();
        return "borrador.xhtml";
    }
    
    public String cmdEliminarProyecto(){
    Proyecto proyecto = new Proyecto();
    proyecto.setNog(nog);
    proyecto.setNombre(nombre);
    proyecto.setMonto(monto);
    proyecto.setDireccion(direccion);
    proyecto.setFechaInicio(fechaInicio);
    proyecto.setFechaFinalizacion(fechaFinalizacion);
    proyecto.setImpactoSocial(impactosocial);
    proyecto.setEstado(estado);
    proyectoFacade.remove(proyecto);
    list = proyectoFacade.findAll();
    return "modificarproyecto.xhtml";
    }
    
    public String cmdRedirigir2(Proyecto proyecto){
    this.proyecto = proyecto;
    estado = proyecto.getEstado();
    impactosocial = proyecto.getImpactoSocial();
    fechaFinalizacion = proyecto.getFechaFinalizacion();
    fechaInicio = proyecto.getFechaInicio();
    direccion = proyecto.getDireccion();
    monto = proyecto.getMonto();
    nombre = proyecto.getNombre();
    nog = proyecto.getNog();
        return "borrador_1.xhtml";
    }
    
    
    
    public String cmdCreate(){
    return "index.xhtml";
    }
}