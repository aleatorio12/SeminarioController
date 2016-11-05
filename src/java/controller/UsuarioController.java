package controller;

import entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import stateless.UsuarioFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freddy Josué Camposeco Silvestre <Carné: 0904-10-12051> <ankoku.fj@gmail.com>
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable{
    
    private static final long serialVersionUID = -6004071469836183158L;
    
    private List<Usuario> listUsuario = null;
    
    private Integer idUsuario = null;
    private String userName = null;
    private String password = null;

    
    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
    
    Usuario usuario;
    
    @Inject
    private UsuarioFacade usuarioFacade;
    @PostConstruct
    public void init(){
        listUsuario=usuarioFacade.findAll();
    }
    
    public String cmdBuscar (){
        return "#{request.contextPath}/faces/usuarios.xhtml";
    }
    
    public String cmdGestion (){
        return "#{request.contextPath}/faces/gestion.xhtml";
    }
    
    public String crearUsuario(){
        Usuario usuario = new Usuario ();
        usuario.setIdUsuario(null);
        usuario.setUsername(userName);
        usuario.setPassword(password);
        usuarioFacade.create(usuario);
        listUsuario = usuarioFacade.findAll();
        return "";
    }
    
}