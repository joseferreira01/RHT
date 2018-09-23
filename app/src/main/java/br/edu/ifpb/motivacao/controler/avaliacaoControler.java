/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Afirmativa;
import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.entidades.Pergunta;
import br.edu.ifpb.motivacao.entidades.Tipo;
import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.service.AvalicaoService;
import br.edu.ifpb.motivacao.service.PerguntaService;
import br.edu.ifpb.motivacao.service.UsuarioService;
import java.io.Serializable;
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
   // private Afirmativa afirmativa;

//    public Afirmativa getAfirmativa() {
//        return afirmativa;
//    }
//
//    public void setAfirmativa(Afirmativa afirmativa) {
//        this.afirmativa = afirmativa;
//    }
    
    

    public String salvar() {
        avaliacao.getAfirmativas().forEach(a->System.out.println(a.toString()));
        service.salvar(avaliacao);
      return null;
        
    }

    @PostConstruct
    public void init() {
         Usuario user = (Usuario) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap().get("usuario");
       this.avaliacao =  service.buscarPorUsuario(user);
         List<Pergunta> perguntas = perguntaService.buscarTodos();
         for (Pergunta pergunta : perguntas) {
             avaliacao.addAfirmativa(new Afirmativa(pergunta));
            
        }
         //avaliacao.setAvaliador(service1.buscar(51L));
//        avaliacao.setEntrevistado(service1.buscar(151L));
//        afirmativa = new Afirmativa();
//        afirmativa.setId(1);
//        afirmativa.setPergunta(new Pergunta(1L, "pergunta A"));
//        avaliacao.addAfirmativa(afirmativa);
      
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
    

}
