/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.repositorios;

import br.edu.ifpb.motivacao.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
@Stateless
public class UsuarioRepositorio {

    @PersistenceContext(unitName = "RHT_PU")
    private EntityManager em;

    public Usuario login(String email, String senha) {
//        StringBuffer sql = new StringBuffer("u FROM Usuario u WHERE u.senha= ").
//                append(senha).append(" AND u.email= ").append(email).append("");
        String sql = "SELECT u FROM Usuario u WHERE u.email =:email AND u.senha =:senha";
        System.err.println("query login" + sql);
            
        return em.createQuery(sql.toString(), Usuario.class).
                setParameter("email", email)
                .setParameter("senha", senha).getSingleResult();
    }
}
