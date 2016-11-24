/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Fase;
import entities.Hallazgo;
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
import stateless.HallazgoFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Named
@SessionScoped

public class FaseHallazgoController implements Serializable{
    
    private static final long serialVersionUID = 7760686434677421958L;
    
    private Integer idFase = null;
    private Integer idHallazgo = null;
    
    private Fase fase = null;
    private Hallazgo hallazgo = null;
    
    private List<Fase> faseList = null;
    private List<Hallazgo> hallazgoList = null;

    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;        
    @Inject
    private FaseFacade faseFacade;
    @Inject
    private HallazgoFacade hallazgoFacade;
    @PostConstruct
    public void init(){
        faseList = faseFacade.findAll();
        hallazgoList = hallazgoFacade.findAll();
    }
    
    public String cmdCrear(){
        List<Fase> listFase = null;
        List<Hallazgo> listHallazgo = null;
        
        Query queryFase = em.createNamedQuery("Fase.findByIdFase");
        queryFase.setParameter("idFase", idFase);
        queryFase.setMaxResults(1);
        listFase = queryFase.getResultList();
        
        if ( listFase.size() > 0 ){
            fase = listFase.get(0);
        }
        
        Query queryHallazgo = em.createNamedQuery("Hallazgo.findByIdHallazgo");
        queryHallazgo.setParameter("idHallazgo", idHallazgo);
        queryHallazgo.setMaxResults(1);
        listHallazgo = queryHallazgo.getResultList();
        
        if ( listHallazgo.size() > 0 ){
            hallazgo = listHallazgo.get(0);
        }
        
        listFase = hallazgo.getFaseList();
        listFase.add(fase);
        hallazgo.setFaseList(listFase);
        hallazgoFacade.edit(hallazgo);
        
        listHallazgo = fase.getHallazgoList();
        listHallazgo.add(hallazgo);
        fase.setHallazgoList(listHallazgo);
        faseFacade.edit(fase);
        
        return "fasehallazgo.xhtml?faces-redirect=true";
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
     * @return the idHallazgo
     */
    public Integer getIdHallazgo() {
        return idHallazgo;
    }

    /**
     * @param idHallazgo the idHallazgo to set
     */
    public void setIdHallazgo(Integer idHallazgo) {
        this.idHallazgo = idHallazgo;
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
     * @return the hallazgo
     */
    public Hallazgo getHallazgo() {
        return hallazgo;
    }

    /**
     * @param hallazgo the hallazgo to set
     */
    public void setHallazgo(Hallazgo hallazgo) {
        this.hallazgo = hallazgo;
    }

    /**
     * @return the faseList
     */
    public List<Fase> getFaseList() {
        return faseList;
    }

    /**
     * @param faseList the faseList to set
     */
    public void setFaseList(List<Fase> faseList) {
        this.faseList = faseList;
    }

    /**
     * @return the hallazgoList
     */
    public List<Hallazgo> getHallazgoList() {
        return hallazgoList;
    }

    /**
     * @param hallazgoList the hallazgoList to set
     */
    public void setHallazgoList(List<Hallazgo> hallazgoList) {
        this.hallazgoList = hallazgoList;
    }
    
}
