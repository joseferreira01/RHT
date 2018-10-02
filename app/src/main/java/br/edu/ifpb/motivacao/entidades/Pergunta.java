/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author jose
 */
@Entity
public class Pergunta implements Serializable {
    @Id
    private Long id;
    @Column(length = 1024)
     @Lob
     @Basic(fetch = FetchType.LAZY)
    private String tex;
    @Enumerated(EnumType.STRING)
    private TipoNecessidade tipo;

    public Pergunta() {
    }

    public Pergunta(Long id, String tex,TipoNecessidade necessidade) {
        this.id = id;
        this.tex = tex;
        this.tipo = necessidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    public TipoNecessidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoNecessidade tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pergunta other = (Pergunta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return "Pergunta{" + "id=" + id + ", tex=" + tex + ", tipo=" + tipo + '}';
    }
}
