/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Afirmativa;
import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.service.AvalicaoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
    private Avaliacao avaliacao;
    private Afirmativa afirmativa;

    public Afirmativa getAfirmativa() {
        return afirmativa;
    }

    public void setAfirmativa(Afirmativa afirmativa) {
        this.afirmativa = afirmativa;
    }
    
    

    public String salvar() {
        avaliacao.getAfirmativas().forEach(a->System.out.println(a.toString()));
        service.salvar(avaliacao);
      return null;
        
    }

    @PostConstruct
    public void init() {
        this.avaliacao = new Avaliacao();
        avaliacao.addAfirmativa(new Afirmativa( "p1"));
        avaliacao.addAfirmativa(new Afirmativa( "p2"));
        avaliacao.addAfirmativa(new Afirmativa( "p3"));
       
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
