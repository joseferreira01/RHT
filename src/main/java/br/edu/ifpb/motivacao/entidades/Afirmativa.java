/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Id;

/**
 *
 * @author jose
 */
@Entity
public class Afirmativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String tex;
    private int resposta;

    public Afirmativa() {
    }

    public Afirmativa(Long id, String tex, int resposta) {
        this.id = id;
        this.tex = tex;
        this.resposta = resposta;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afirmativa)) {
            return false;
        }
        Afirmativa other = (Afirmativa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.motivacao.Afirmativa[ id=" + id + " ]";
    }
    
}
