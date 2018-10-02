/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.controler;

import br.edu.ifpb.motivacao.entidades.Avaliacao;
import br.edu.ifpb.motivacao.entidades.Resultado;
import br.edu.ifpb.motivacao.entidades.TipoNecessidade;
import br.edu.ifpb.motivacao.service.AvalicaoService;
import br.edu.ifpb.motivacao.service.PerguntaService;
import br.edu.ifpb.motivacao.service.UsuarioService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author jose
 */
@RequestScoped
@Named
public class Graficos {
    private TipoNecessidade necessidade;
    private PieChartModel pieModel1;
   @Inject
    private Mensagem msg;

    @EJB
    private AvalicaoService service;
    @EJB
    private PerguntaService perguntaService;

    @EJB
    private UsuarioService usuarioService;
      private Avaliacao avaliacao;
    @PostConstruct
    public void init() {
       
        createPieModels();
    }
  
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
           
    private void createPieModels() {
        createPieModel1();
    }
  
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        for (Resultado resultado : resultado(602)) {
            
        
          switch(resultado.getNecessidade()){
              case AUTOREALIZAÇAO: 
                   pieModel1.set(necessidade.AUTOREALIZAÇAO.name(),resultado.getValor());
                   
              case AUTORECONHECIMENTO: 
                   pieModel1.set(necessidade.AUTORECONHECIMENTO.name(),resultado.getValor());
                   case FISIOLÓGICAS: 
                   pieModel1.set(necessidade.FISIOLÓGICAS.name(),resultado.getValor());
                   case PARTICIPAÇÃO: 
                   pieModel1.set(necessidade.PARTICIPAÇÃO.name(),resultado.getValor());
                   case SEGURANÇA:
                   pieModel1.set(necessidade.SEGURANÇA.name(),resultado.getValor());
                   
                   
                   
          }
    }
           
        pieModel1.setTitle("Prognóstico da avaliação");
        pieModel1.setLegendPosition("w");
    }
    private List<Resultado> resultado(int id){
        return service.resultado(avaliacao).getResultados();
    }
}
