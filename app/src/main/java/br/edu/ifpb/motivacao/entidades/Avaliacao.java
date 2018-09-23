/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jose
 */
@Entity
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
//    @JoinColumn(name = "entrevistado_ID")
    private Usuario entrevistado;
    @OneToOne
//    @JoinColumn(name = "avaliador_ID")
    private Usuario avaliador;
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Necessidade> necessidades;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Afirmativa> afirmativas;

    public Avaliacao() {
        necessidades = new HashSet<>();
        this.afirmativas = new HashSet<>();
    }

    public Avaliacao(Usuario avaliador) {
        this();
        this.avaliador = avaliador;
       
        
    }

    public void addAvaliacao(Necessidade necessidade) {
        this.necessidades.add(necessidade);
    }

    public void removeAvaliacao(Necessidade necessidade) {
        this.necessidades.remove(necessidade);
    }
    public void addAfirmativa(Afirmativa afirmativa) {
        this.afirmativas.add(afirmativa);
    }

    public void removeAfirmativa(Afirmativa afirmativa) {
        this.afirmativas.add(afirmativa);
    }

    public Set<Afirmativa> getAfirmativas() {
        return afirmativas;
    }

    public void setAfirmativas(Set<Afirmativa> afirmativas) {
        this.afirmativas = afirmativas;
    }

   

    public Set<Necessidade> getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(Set<Necessidade> necessidades) {
        this.necessidades = necessidades;
    }

    public Long getId() {
        return id;
    }

    public Usuario getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Usuario entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Usuario avaliador) {
        this.avaliador = avaliador;
    }
    

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", entrevistado=" +
                entrevistado + ", avaliador=" + avaliador + 
                ", necessidades=" + necessidades + ", afirmativas=" + afirmativas + '}';
    }

   

}
