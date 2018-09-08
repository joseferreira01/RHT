/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Tipo;
import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.service.UsuarioService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class UsuarioControler {
     @Inject
    private Mensagem msg;
     private int tipo;

    @EJB
    private UsuarioService service;
    private Usuario usuario;

    public String salvar() {
        if(tipo==1)
            usuario.setTipo(Tipo.AVALIADOR);
        else
            usuario.setTipo(Tipo.ENTREVISTADO);
        service.salvar(usuario);
         msg.addMessage("Cadastro realizado com sucesso, faça seu login!");
            
        usuario = new Usuario();
        return "index?faces-redirect=true";
        
    }
    public List<Usuario> getTodos(){
        return  service.buscarTodos();
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }
      public String login(){
          
         Usuario login = service.login(usuario.getEmail(),usuario.getSenha());
         if(login!=null){
             msg.addMessage("Ola "+usuario.getNome()+"!");
         return "home?faces-redirect=true";
         }
          msg.addMessage("Dados invalidos");
         return null;
      }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
