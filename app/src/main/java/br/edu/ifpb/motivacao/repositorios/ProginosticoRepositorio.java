/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.motivacao.repositorios;

import br.edu.ifpb.motivacao.entidades.Proginostico;
import br.edu.ifpb.motivacao.entidades.TipoNecessidade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author jose
 */
@Singleton
@Startup
public class ProginosticoRepositorio {

    private final List<Proginostico> progs = new ArrayList();

    @PostConstruct
    public void init() {
        String fisiologico = " É importante para o gestor enfatizar a prática de recompensas que vão além do salário: destinar um percentual do lucro anual é um exemplo; outra prática pode ser a remuneração por desempenho, oferecendo complementação em dinheiro a que superar a meta. outra prática que pode elevar a satisfação com as necessidades fisiológicas é a adequação do ambiente de trabalho de acordo com princípios de economia reestruturando o mobiliário de acordo com o porte físico dos trabalhadores.";
     
        String seguranca = " É de Vital importância que o administrador desenvolvimento políticas  para garantir a segurança  como: manter boa reputação no mercado de forma a proporcionar   estabilidade no trabalho ;flexibilizar o oferecimento de  planos de saúde. de forma a adequaá-os de acordo com as necessidades de cada funcionário. ";
        
        String participacao = " Necessidades sociais: relacionadas à vida em sociedade, englobando necessidades de convívio, amizade, respeito amor, lazer e\n"
                + "participação.(REGIS, PORTO, 2006);";
        
        String autoRealizacao = "Necessidades de auto-estima: estão ligadas a forma com o indivíduo se avalia, levando-o a ter sentimentos de poder, capacidade habilidade e aptidão(REGIS, PORTO, 2006).";
        
        String reconhecimento = "Necessidades de auto-realização: “expressam o mais alto nível das necessidades estando diretamente relacionadas à realização integral do indivíduo.”(REGIS, PORTO,2006,p 336) consistem na realização potencial do indivíduo, e são manifestadas, no momento em que todas as demais necessidades forem satisfeitas.";
        
        this.progs.add(new Proginostico(1, fisiologico, TipoNecessidade.FISIOLÓGICAS));
        this.progs.add(new Proginostico(2, fisiologico, TipoNecessidade.SEGURANÇA));
        this.progs.add(new Proginostico(3, fisiologico, TipoNecessidade.PARTICIPAÇÃO));
        this.progs.add(new Proginostico(4, fisiologico, TipoNecessidade.AUTOREALIZAÇAO));
        this.progs.add(new Proginostico(5, fisiologico, TipoNecessidade.AUTORECONHECIMENTO));

    }

    public Proginostico proginostico(TipoNecessidade necessidade) {
        for (Proginostico p : progs) {
            if (p.getTipo().equals(necessidade)) {
                return p;
            }

        }
        return new Proginostico();
    }
}
