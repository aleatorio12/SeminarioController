/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Auditor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.AuditorFacade;

/**
 *
 * @author Cesar Cifuentes 4490-13-9410
 */
@Named
@SessionScoped

public class AuditorController implements Serializable{
    
    private static final long serialVersionUID = -8320851293331768731L;

    private Auditor auditor = null;
    private Integer idauditor = null;
    private String primernombre = null;
    private String segundonombre = null;
    private String primerapellido = null;
    private String segundoapellido = null;
    private String email = null;
    private String telefono = null;
    private List<Auditor> list = null;

    public List<Auditor> getList() {
        return list;
    }

    public void setList(List<Auditor> list) {
        this.list = list;
    }

    public Integer getIdauditor() {
        return idauditor;
    }

    public void setIdauditor(Integer idauditor) {
        this.idauditor = idauditor;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Auditor getAuditor() {
        return auditor;
    }

    public void setAuditor(Auditor auditor) {
        this.auditor = auditor;
    }

    
    
    
    
    @Inject
    private AuditorFacade auditorFacade;
    
    @PostConstruct
    public void init (){
     list = auditorFacade.findAll();    
    }
    
    public String cmdInsertarAuditor (){
        Auditor auditor1 = new Auditor();
        auditor1.setIdAuditor(idauditor);
        auditor1.setPrimerNombre(primernombre);
        auditor1.setSegundoNombre(segundonombre);
        auditor1.setPrimerApellido(primerapellido);
        auditor1.setSegundoApellido(segundoapellido);
        auditor1.setEmail(email);
        auditor1.setTelefono(telefono);
        auditorFacade.create(auditor1);
        list = auditorFacade.findAll();
        return "buscarauditor.xhtml";
    }
    
    public String cmdRedirigir(Auditor auditor){
        this.auditor = auditor;
        idauditor = auditor.getIdAuditor();
        primernombre = auditor.getPrimerNombre();
        segundonombre = auditor.getSegundoNombre();
        primerapellido = auditor.getPrimerApellido();
        segundoapellido = auditor.getSegundoApellido();
        email = auditor.getEmail();
        telefono = auditor.getTelefono();
        return"formModificacion.xhtml";
    }
    
    public String cmdModificacionAuditor (){
        Auditor audio2 = new Auditor();
        audio2.setIdAuditor(idauditor);
        audio2.setPrimerNombre(primernombre);
        audio2.setSegundoNombre(segundonombre);
        audio2.setPrimerApellido(primerapellido);
        audio2.setSegundoApellido(segundoapellido);
        audio2.setEmail(email);
        audio2.setTelefono(telefono);
        auditorFacade.edit(audio2);
        list = auditorFacade.findAll();
        return "buscarauditor.xhtml";
    }
    
    public String cmdRedirigir2(Auditor auditor){
        this.auditor = auditor;
        idauditor = auditor.getIdAuditor();
        primernombre = auditor.getPrimerNombre();
        segundonombre = auditor.getSegundoNombre();
        primerapellido = auditor.getPrimerApellido();
        segundoapellido = auditor.getSegundoApellido();
        email = auditor.getEmail();
        telefono = auditor.getTelefono();
        return"formeliminar.xhtml";
    }

    public String cmdEliminarAuditor (){
        Auditor audio2 = new Auditor();
        audio2.setIdAuditor(idauditor);
        audio2.setPrimerNombre(primernombre);
        audio2.setSegundoNombre(segundonombre);
        audio2.setPrimerApellido(primerapellido);
        audio2.setSegundoApellido(segundoapellido);
        audio2.setEmail(email);
        audio2.setTelefono(telefono);
        auditorFacade.remove(audio2);
        list = auditorFacade.findAll();
        return "buscarauditor.xhtml";
    }
}
