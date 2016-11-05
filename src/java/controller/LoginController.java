/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;
import stateless.UsuarioFacade;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */

@Named
@SessionScoped


public class LoginController implements Serializable{

    private static final long serialVersionUID = 1979050895618488871L;   
    //Campos de la tabla Ente
    
    private Usuario usuario = null;
    private String username = null;
    private String password = null;
    
    private List<Usuario> listUsuario = null;
    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;    
    @Inject
    private UsuarioFacade usuarioFacade;
    @PostConstruct
    public void init (){
        listUsuario = usuarioFacade.findAll();
    }
    
    public String cmdLogin(){
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario user = null;
        List usuarios = null;
        String passHasheada = passHasheada(password);
        
        Query query = em.createNamedQuery("Usuario.findByUsername");
        query.setParameter("username", username);
        query.setMaxResults(1);
        usuarios = query.getResultList();
        //user = (Usuario) query.getSingleResult();
        
        if ( usuarios.size() > 0 ){
            user = (Usuario) usuarios.get(0);
            if ( user.getPassword().equals(passHasheada) ){
                
                //Se ejecuta cuando usuario y pass coinciden.
                context.getExternalContext().getSessionMap().put("user", user);
                return "localhost:8080/SeminarioController/faces/";
            }
            else{
                
                //Se ejecuta cuando si se encuentra el usuario pero la
                //pass no coincide.
                
                return "usuario/buscar.xhtml";
            }
            
        }        

        //Se ejecuta cuando el usuario no ha sido encontrado
        
        return "ente/ente.xhtml";
    }
    
    private String passHasheada( String password ){
        return DigestUtils.sha512Hex(password);
    }

    public String cmdLogout(){
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "ente/ente.xhtml";
    }

    public String isUserLogued(){
        if ( FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("user") == null
        ){
            return "false";
        }
        else
            return "true";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
            
}
