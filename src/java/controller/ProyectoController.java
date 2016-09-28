/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Ente;
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

    private static final long serialVersionUID = 3196528861852293781L;   
    private List<Proyecto> listaProyecto = null;
    
    private int nog;
    private String nombre;
    private double monto;
    private String direccion;
    private Date fechaInicio;
    private Date fechaFin;
    private int impactoSocial;
    private char estado = 'I';
    private Ente enteEjecutor;
    private Ente enteSupervisor;
    private Ente enteRector;
    private int fase;
    
    
    /**
     * @return the listaProyecto
     */
    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    /**
     * @param listaProyecto the listaProyecto to set
     */
    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    @Inject
    private ProyectoFacade proyectoFacade;    
    @PostConstruct
    public void init() {
        //listaProyecto = proyectoFacade.findAll();
    }
    
    public String cmdCreate (){
        return "crearproyecto.xhtml";
    }
    
    public String insertarProyecto(){
        
        Proyecto proyecto = new Proyecto();
        proyecto.setDireccion(direccion);
        proyecto.setNog(nog);
        proyecto.setNombre(nombre);
        proyecto.setMonto(monto);
        proyecto.setImpactoSocial(impactoSocial);
        proyecto.setEstado(estado);
       
        
        proyectoFacade.create(proyecto);
        
        return "index.html";
    }

    /**
     * @return the nog
     */
    public int getNog() {
        return nog;
    }

    /**
     * @param nog the nog to set
     */
    public void setNog(int nog) {
        this.nog = nog;
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
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the impactoSocial
     */
    public int getImpactoSocial() {
        return impactoSocial;
    }

    /**
     * @param impactoSocial the impactoSocial to set
     */
    public void setImpactoSocial(int impactoSocial) {
        this.impactoSocial = impactoSocial;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @return the enteEjecutor
     */
    public Ente getEnteEjecutor() {
        return enteEjecutor;
    }

    /**
     * @param enteEjecutor the enteEjecutor to set
     */
    public void setEnteEjecutor(Ente enteEjecutor) {
        this.enteEjecutor = enteEjecutor;
    }

    /**
     * @return the enteSupervisor
     */
    public Ente getEnteSupervisor() {
        return enteSupervisor;
    }

    /**
     * @param enteSupervisor the enteSupervisor to set
     */
    public void setEnteSupervisor(Ente enteSupervisor) {
        this.enteSupervisor = enteSupervisor;
    }

    /**
     * @return the enteRector
     */
    public Ente getEnteRector() {
        return enteRector;
    }

    /**
     * @param enteRector the enteRector to set
     */
    public void setEnteRector(Ente enteRector) {
        this.enteRector = enteRector;
    }

    /**
     * @return the fase
     */
    public int getFase() {
        return fase;
    }

    /**
     * @param fase the fase to set
     */
    public void setFase(int fase) {
        this.fase = fase;
    }
    
}
