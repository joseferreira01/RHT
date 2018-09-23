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
public class Proginostico implements Serializable {

    @Id
    private int id;
    private String resultado;
    private TipoNecessidade tipo;

    public Proginostico() {
    }

    public Proginostico(String resultado, TipoNecessidade tipo) {
        this.resultado = resultado;
        this.tipo = tipo;
    }

    public Proginostico(int id, String resultado, TipoNecessidade tipo) {
        this.id = id;
        this.resultado = resultado;
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.tipo);
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
        final Proginostico other = (Proginostico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public TipoNecessidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoNecessidade tipo) {
        this.tipo = tipo;
    }

}
