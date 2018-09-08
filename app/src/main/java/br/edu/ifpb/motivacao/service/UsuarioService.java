/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.service;

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
public class UsuarioService {

    @EJB
    private Repository<Usuario,Long>  crud;
    @EJB
    private UsuarioRepositorio ur;

    public void salvar(Usuario usuario) {
        crud.salvar(usuario);
    }

    public List<Usuario> buscarTodos() {
        return crud.list(Usuario.class);
    }
    public Usuario login(String email, String senha){
        return ur.login(email, senha);
    }

}
