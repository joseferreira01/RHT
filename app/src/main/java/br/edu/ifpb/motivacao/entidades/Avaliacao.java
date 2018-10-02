/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario entrevistado;
    @OneToMany 
    @Lob
     @Basic(fetch = FetchType.LAZY)
    @ElementCollection()
    private List<Resposta> respostas;
    @ElementCollection
    private List<Resultado> resultados;
    
    @OneToOne
    private Proginostico proginostico;

    public Avaliacao() {
        this.respostas = new ArrayList<>();
        this.resultados = new ArrayList<>();
        
    }

    public Avaliacao(Usuario Usuario) {
        this();
        this.entrevistado = new Usuario();
    }

    public void add(Resposta resposta) {
        this.respostas.add(resposta);
    }

    public void remove(Resposta resposta) {
        this.respostas.remove(resposta);
    }

    public void add(Resultado resultados) {
        this.resultados.add(resultados);
    }

    public void remove(Resultado resultados) {
        this.resultados.remove(resultados);
    }

    public Proginostico getProginostico() {
        return proginostico;
    }

    public void setProginostico(Proginostico proginostico) {
        this.proginostico = proginostico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Usuario entrevistado) {
        this.entrevistado = entrevistado;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

   

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", entrevistado=" + entrevistado + ", respostas=" + respostas.get(0) + ", resultados=" + resultados + ", proginosticos=" + proginostico + '}';
    }
    
    

}
