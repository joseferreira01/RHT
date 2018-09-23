/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author jose
 */
@Entity
public class Afirmativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Pergunta pergunta;
    private int resposta;

    public Afirmativa() {
    }

    public Afirmativa(int id, Pergunta pergunta ) {
        this.id = id;
        this.pergunta = pergunta;
      
    }
    public Afirmativa(Pergunta pergunta) {
     
        this.pergunta = pergunta;
      
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        hash = 67 * hash + this.id;
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
        final Afirmativa other = (Afirmativa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Afirmativa{" + "id=" + id + ", tex=" + pergunta + ", resposta=" + resposta + '}';
    }
    

   

    

   
    
}
