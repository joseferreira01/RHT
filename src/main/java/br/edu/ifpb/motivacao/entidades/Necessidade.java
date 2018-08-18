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
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jose
 */
@Entity
public class Necessidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})    
    private Set<Afirmativa> afirmativas; 
    private String descricao;
    private int total;

    public Necessidade() {
         this.afirmativas = new HashSet<>();
    }

    public Necessidade(Long id, String descricao, int total) {
        this();
        this.id = id;
        this.descricao = descricao;
        this.total = total;
        
    }
    public void addAfirmativa(Afirmativa afirmativa){
        this.afirmativas.add(afirmativa);
    }
    public void removeAfirmativa(Afirmativa afirmativa){
        this.afirmativas.remove(afirmativa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Afirmativa> getAfirmativas() {
        return afirmativas;
    }

    public void setAfirmativas(Set<Afirmativa> afirmativas) {
        this.afirmativas = afirmativas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        if (!(object instanceof Necessidade)) {
            return false;
        }
        Necessidade other = (Necessidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    public int rsultadoPorNessecidade(){
         afirmativas.iterator().forEachRemaining(a-> this.total =a.getResposta());
         return this.total;
    }

    @Override
    public String toString() {
        return "br.edu.ifpb.motivacao.Necessidade[ id=" + id + " ]";
    }
    
}
