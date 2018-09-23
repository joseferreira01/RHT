/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.service;

import br.edu.ifpb.motivacao.entidades.Avaliacao;
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
public class AvaliacaoService {

    @EJB
    private Repository<Avaliacao,Long>  crud;
    @EJB
    private UsuarioRepositorio ur;

    public void salvar(Avaliacao avaliacao) {
        crud.salvar(avaliacao);
    }

    public List<Avaliacao> buscarTodos() {
        return crud.list(Avaliacao.class);
    }
   
    public Avaliacao buscar(long id){
        return crud.find(Avaliacao.class, id);
    }

}
