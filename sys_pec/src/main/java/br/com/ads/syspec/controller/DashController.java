package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.repository.DashRepository;

@Named
@ViewScoped
public class DashController implements Serializable{
	@Inject
	private DashRepository dashRespository;

	private String anoProducaoBar = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

	public BarChartModel getBarProducao() {
		BarChartModel barProducao = new BarChartModel();
		List<Object[]> producaoMensal = dashRespository.findProducaoMensal(anoProducaoBar);
		ChartSeries producao = new ChartSeries();

		producao.setLabel("Produção: " + anoProducaoBar);
		barProducao.setTitle("Produção Mensal");
		barProducao.setAnimate(true); 
		barProducao.setLegendPosition("ne");
		barProducao.addSeries(producao);

		for(int i=0; i < 12; i++) {
			boolean qtdZero = true;
			for(Object[] o : producaoMensal) {
				Number oMes = (Number) o[0];

				if((i + 1) == oMes.intValue()) {
					producao.set(getMes(i), (Number) o[2]);
					qtdZero = false;
				}
			}

			if(qtdZero)
				producao.set(getMes(i), 0);
		}        

		return barProducao;
	}

	public BarChartModel getBarProducaoDiaria() {
		List<Extracao> producaoDiaria = dashRespository.findProducaoDiaria(1);
		BarChartModel barProducao = new BarChartModel();
		ChartSeries producao = new ChartSeries();
		int mes = 1;
		
		producao.setLabel("Produção Mês: " + 01);
		barProducao.setTitle("Produção Mensal");
		barProducao.setAnimate(true); 
		barProducao.setLegendPosition("ne");
		barProducao.addSeries(producao);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, mes - 1);
		
		int maxDiaMes = c.getMaximum(Calendar.DATE);
		Double[] values = new Double[maxDiaMes];
		for(int i=0; i <= maxDiaMes; i++) {

		}
		
		return barProducao;

	}


	public String getAnoProducaoBar() {
		return anoProducaoBar;
	}

	public void setAnoProducaoBar(String anoProducaoBar) {
		this.anoProducaoBar = anoProducaoBar.replace("_","");
	}



	public String getMes(int i) {
		String meses[] = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};

		if(i < 12 && i >= 0) {
			return meses[i];
		}
		else
			return null;
	}
}
