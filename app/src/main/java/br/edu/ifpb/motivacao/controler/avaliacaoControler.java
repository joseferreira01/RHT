/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Afirmativa;
import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.service.UsuarioService;
import java.io.Serializable;
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
public class avaliacaoControler implements Serializable{
     @Inject
    private Mensagem msg;

    @EJB
    private UsuarioService service;
    private Avaliacao avaliacao;
    private Afirmativa afirmativa;

    public Afirmativa getAfirmativa() {
        return afirmativa;
    }

    public void setAfirmativa(Afirmativa afirmativa) {
        this.afirmativa = afirmativa;
    }
    
    

    public String salvar() {
        
      return null;
        
    }

    @PostConstruct
    public void init() {
        this.avaliacao = new Avaliacao();
        avaliacao.addAfirmativa(new Afirmativa(Long.parseLong("1"), "p1"));
        avaliacao.addAfirmativa(new Afirmativa(Long.parseLong("2"), "p2"));
        avaliacao.addAfirmativa(new Afirmativa(Long.parseLong("3"), "p3"));
        afirmativa = new Afirmativa(Long.MIN_VALUE, "9eie9dddd");
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    

}
