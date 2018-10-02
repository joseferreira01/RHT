/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 *
 * @author jose
 */
@Entity
public class Resposta implements Serializable {

    @Id
    private Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Pergunta pergunta;
    private int resposta;

    public Resposta() {
    }

    public Resposta(Long id, Pergunta pergunta, int resposta) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Resposta(Pergunta pergunta) {

        this.pergunta = pergunta;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Resposta other = (Resposta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resposta{" + "id=" + id + ", pergunta=" + pergunta + ", resposta=" + resposta + '}';
    }

}
