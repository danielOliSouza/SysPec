package br.com.ads.syspec.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.ads.syspec.repository.DashRepository;

@Named
public class DashController implements Serializable{
	@Inject
	private DashRepository dashRespository;
	
	
	private BarChartModel barProducao = new BarChartModel();
	
	/* SELECT (EXTRACT (MONTH FROM dt_extracao_inicio)) AS mes,
	 * (EXTRACT (YEAR FROM dt_extracao_inicio)) AS ano,
     * (SUM(qtd)) AS qtd
	 * FROM extracao INNER JOIN ordenha ON extracao.id = ordenha.extracao_id
     * WHERE (EXTRACT (YEAR FROM dt_extracao_inicio)) = '2017'
	 * GROUP BY mes, ano
	 */
	
	public BarChartModel getBarProducao() {
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
		
        barProducao.setTitle("Produção Mensal");
        barProducao.setAnimate(true); 
        barProducao.setLegendPosition("ne");
        barProducao.addSeries(boys);
        
        Axis yAxis = barProducao.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
		return barProducao;
	}

	public void setBarProducao(BarChartModel barProducao) {
		this.barProducao = barProducao;
	}
	
	public String getMes(int i) {
		String meses[] = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};
		
		if(i <= 12) {
			return meses[i-1];
		}
		else
			return null;
	}
}
