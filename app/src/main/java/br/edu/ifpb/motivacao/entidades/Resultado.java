/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jose
 */
@Entity
public class Resultado implements Serializable{
    @Id
    private Long id;
    private TipoNecessidade necessidade;
    private int valor;

    public Resultado() {
    }

    public Resultado(Long id, TipoNecessidade necessidade, int valor) {
        this.id = id;
        this.necessidade = necessidade;
        this.valor = valor;
    }
    public Resultado(TipoNecessidade necessidade) {
       
        this.necessidade = necessidade;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoNecessidade getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(TipoNecessidade necessidade) {
        this.necessidade = necessidade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Resultado other = (Resultado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resultados{" + "id=" + id + ", necessidade=" + necessidade + ", valor=" + valor + '}';
    }
    
}
