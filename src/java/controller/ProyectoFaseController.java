/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Fase;
import entities.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import stateless.FaseFacade;
import stateless.ProyectoFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped

public class ProyectoFaseController implements Serializable{
    
    private static final long serialVersionUID = 3619512198450939282L;
    
    private Integer idFase = null;
    private Integer idProyecto = null;
    
    private Fase fase = null;
    private Proyecto proyecto = null;

    private List<Fase> listFase = null;
    private List<Proyecto> listProyecto = null;
    
    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;    
    @Inject
    private FaseFacade faseFacade;
    @Inject
    private ProyectoFacade proyectoFacade;
    
    @PostConstruct
    public void init(){
        listFase = faseFacade.findAll();
        listProyecto = proyectoFacade.findAll();
    }
    
    public String cmdCrear(){

        List<Proyecto> auxProyectos = null;
        List<Fase> auxFase = null;
        
        Query query = em.createNamedQuery("Proyecto.findByNog");
        query.setParameter("nog", idProyecto);
        query.setMaxResults(1);
        auxProyectos = query.getResultList();        

        Query queryFase = em.createNamedQuery("Fase.findByIdFase");
        queryFase.setParameter("idFase", idFase);
        queryFase.setMaxResults(1);
        auxFase = queryFase.getResultList();
        
        if ( auxProyectos.size() > 0 ){
            proyecto = auxProyectos.get(0);
        }

        if ( auxFase.size() > 0 ){
            fase = auxFase.get(0);
        }
        
        List<Fase> listFaseProyecto = null;
        listFaseProyecto =  proyecto.getFaseList();
        listFaseProyecto.add(fase);
        proyecto.setFaseList(listFaseProyecto);
        proyectoFacade.edit(proyecto);
        return "proyectofase.xhtml";
    }    
    
    /**
     * @return the fase
     */
    public Fase getFase() {
        return fase;
    }

    /**
     * @param fase the fase to set
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }    

    /**
     * @return the listFase
     */
    public List<Fase> getListFase() {
        return listFase;
    }

    /**
     * @param listFase the listFase to set
     */
    public void setListFase(List<Fase> listFase) {
        this.listFase = listFase;
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
     * @return the faseFacade
     */
    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    /**
     * @param faseFacade the faseFacade to set
     */
    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
    }

    /**
     * @return the proyectoFacade
     */
    public ProyectoFacade getProyectoFacade() {
        return proyectoFacade;
    }

    /**
     * @param proyectoFacade the proyectoFacade to set
     */
    public void setProyectoFacade(ProyectoFacade proyectoFacade) {
        this.proyectoFacade = proyectoFacade;
    }

    /**
     * @return the idFase
     */
    public Integer getIdFase() {
        return idFase;
    }

    /**
     * @param idFase the idFase to set
     */
    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    /**
     * @return the idProyecto
     */
    public Integer getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    
    
    
}
