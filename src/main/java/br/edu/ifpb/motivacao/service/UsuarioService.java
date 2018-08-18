/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.service;

import br.edu.ifpb.motivacao.entidades.Usuario;
import br.edu.ifpb.motivacao.repositorios.CrudReposiroryImpl;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jose
 */
public class UsuarioService {

    @EJB
    private CrudReposiroryImpl<Usuario, Long> crud;

    public void salvar(Usuario usuario) {
        crud.salvar(usuario);
    }

    public List<Usuario> buscarTodos() {
        return crud.list(Usuario.class);
    }

}
