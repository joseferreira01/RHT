/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.service;

import br.edu.ifpb.motivacao.entidades.Pergunta;
import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.repositorios.Repository;
import br.edu.ifpb.motivacao.repositorios.UsuarioRepositorio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class PerguntaService {

    @EJB
    private Repository<Pergunta,Long>  crud;
    @EJB
    private UsuarioRepositorio ur;

    public void salvar(Pergunta pergunta) {
        crud.salvar(pergunta);
    }

    public List<Pergunta> buscarTodos() {
        return crud.list(Pergunta.class);
    }
  
    public Pergunta buscar(long id){
        return crud.find(Pergunta.class, id);
    }

}
