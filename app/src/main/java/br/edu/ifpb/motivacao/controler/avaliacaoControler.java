/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.entidades.Pergunta;
import br.edu.ifpb.motivacao.entidades.Resposta;
import br.edu.ifpb.motivacao.entidades.Tipo;
import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.service.AvalicaoService;
import br.edu.ifpb.motivacao.service.PerguntaService;
import br.edu.ifpb.motivacao.service.UsuarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@SessionScoped
public class avaliacaoControler implements Serializable{
     @Inject
    private Mensagem msg;

    @EJB
    private AvalicaoService service;
    @EJB
    private PerguntaService perguntaService;

    @EJB
    private UsuarioService usuarioService;
    private Avaliacao avaliacao;
    private List<Resposta> respostas;
   
    
    

    public String salvar() {
      avaliacao.setRespostas(respostas);
        System.out.println("avaliação para valvar -> "+avaliacao);
        service.salvar(avaliacao);
      return null;
        
    }

    @PostConstruct
    public void init() {
        respostas = new ArrayList<>();
        for (Pergunta pergunta : perguntaService.buscarTodos()) {
            int a=1;
            System.out.println("size"+a);
            a++;
            Resposta Resposta = new Resposta(pergunta);
            respostas.add(Resposta);
        }
        Usuario usuario = new Usuario();
         usuario = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap().get("usuario");
         System.out.println("usuario da ava"+usuario.getNome());
        avaliacao = new Avaliacao();
        avaliacao.setEntrevistado(usuario);
        
       
       
    }
public  List<Avaliacao> getTodos(){
    return service.buscarTodos();
}
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
    

}
