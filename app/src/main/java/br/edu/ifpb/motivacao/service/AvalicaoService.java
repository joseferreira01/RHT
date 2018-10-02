/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.service;

import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.entidades.Resposta;
import br.edu.ifpb.motivacao.entidades.Resultado;
import br.edu.ifpb.motivacao.entidades.TipoNecessidade;
import br.edu.ifpb.motivacao.repositorios.ProginosticoRepositorio;
import br.edu.ifpb.motivacao.repositorios.Repository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class AvalicaoService {

    @EJB
    private Repository<Avaliacao, Long> crud;
    private final List<Avaliacao> lista = new ArrayList<>();
    @EJB
    private ProginosticoRepositorio pr;

    public void salvar(Avaliacao avaliacao) {
        //lista.add(avaliacao);
        System.err.println("avalicao incopleta"+avaliacao);
         
         
        crud.salvar(resultado(avaliacao));
         System.out.println("avalicao copleta"+avaliacao);

    }

    public List<Avaliacao> buscarTodos() {
        return crud.list(Avaliacao.class);
    }

    public Avaliacao resultado(Avaliacao avaliacao) {
        Resultado fisiologica = new Resultado(TipoNecessidade.FISIOLÓGICAS);
        Resultado seguranca = new Resultado(TipoNecessidade.SEGURANÇA);
        Resultado autto_realizacao = new Resultado(TipoNecessidade.AUTOREALIZAÇAO);
        Resultado participacao = new Resultado(TipoNecessidade.PARTICIPAÇÃO);
        Resultado reconhecimento = new Resultado(TipoNecessidade.AUTORECONHECIMENTO);
        for (Resposta resposta : avaliacao.getRespostas()) {

            switch (resposta.getPergunta().getTipo()) {
                case FISIOLÓGICAS:
                    fisiologica.
                            setValor(fisiologica.getValor() + resposta.getResposta());
                case SEGURANÇA:
                    seguranca.
                            setValor(seguranca.getValor() + resposta.getResposta());
                case AUTOREALIZAÇAO:
                    autto_realizacao.
                            setValor(autto_realizacao.getValor() + resposta.getResposta());
                case PARTICIPAÇÃO:
                    participacao.
                            setValor(participacao.getValor() + resposta.getResposta());
                case AUTORECONHECIMENTO:
                    participacao.
                            setValor(reconhecimento.getValor() + resposta.getResposta());
            }

        }
        List<Resultado> resultados = new ArrayList<>();
        resultados.add(fisiologica);
        resultados.add(seguranca);
        resultados.add(participacao);
        resultados.add(autto_realizacao);
        resultados.add(reconhecimento);
        avaliacao.setResultados(resultados);
        //int primero, segundo = resultados.get(0).getValor(); 
       // avaliacao.setProginostico(pr.proginostico(TipoNecessidade.SEGURANÇA));
        
        return avaliacao;
    }

    public Avaliacao buscarPorId(int id) {
     return crud.find(Avaliacao.class,Long.valueOf(new String().valueOf(id)));
    }

}
