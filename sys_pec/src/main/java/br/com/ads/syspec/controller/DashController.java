package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.model.Ordenha;
import br.com.ads.syspec.repository.DashRepository;

@Named
@ViewScoped
public class DashController implements Serializable{
	@Inject
	private DashRepository dashRespository;

	private String anoProducaoBar = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	private String anoProducaoBarCompare = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 1);
	private String anoProducaoBarCompare02 = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	private int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
	
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

	public LineChartModel getBarProducaoDiaria() {
		LineChartModel linearProducao = new LineChartModel();
		LineChartSeries producao = new LineChartSeries();
		
		int mes = this.mes;
		List<Extracao> producaoDiaria = dashRespository.findProducaoDiaria(mes);
		
		System.out.println(mes);
		
		producao.setLabel("Produção Mês: " + mes);
		linearProducao.setTitle("Produção Diaria");
		linearProducao.setAnimate(true); 
		linearProducao.setLegendPosition("se");
		linearProducao.addSeries(producao);
		linearProducao.getAxes().put(AxisType.X, new CategoryAxis("Dias"));
		linearProducao.getAxis(AxisType.Y).setLabel("QTD");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, mes - 1);
		
		int maxDiaMes = c.getMaximum(Calendar.DATE);
		double[] values = new double[maxDiaMes];
		
		System.out.println(values);
		
		for(int i=0; i < maxDiaMes; i++) {
			values[i] = 0d;
			for(Extracao e : producaoDiaria) {
				
				Calendar diaInicio = Calendar.getInstance();
				diaInicio.setTime(e.getDtExtracaoInicio());
				
				
				if((i+1) == diaInicio.get(Calendar.DATE)) {
	
					for(Ordenha o : e.getOrdenhas()) {
						values[i] += o.getQtd();
					}
				}
					
			}
		}

		if(producaoDiaria.isEmpty()) {
			producao.set(1, 0);
			producao.set(maxDiaMes + 1, 0);
		}
		
		for(int i = 0; i < values.length; i++) {
			if(values[i] > 0)
				producao.set(i+1, values[i]);
		}
		
		return linearProducao;

	}

	public BarChartModel getBarProducaoComparativo() {
		BarChartModel barProducao = new BarChartModel();
		List<Object[]> producaoMensal01 = dashRespository.findProducaoMensal(anoProducaoBarCompare);
		List<Object[]> producaoMensal02 = dashRespository.findProducaoMensal(anoProducaoBarCompare02);
		ChartSeries producao = new ChartSeries();
		ChartSeries producao02 = new ChartSeries();
		
		producao.setLabel("Produção: " + anoProducaoBarCompare);
		producao02.setLabel("Produação: " + anoProducaoBarCompare02);
		
		barProducao.setTitle("Produção Mensal");
		barProducao.setAnimate(true); 
		barProducao.setLegendPosition("ne");

		
		
		for(int i=0; i < 12; i++) {
			boolean qtdZero = true;
			for(Object[] o : producaoMensal01) {
				Number oMes = (Number) o[0];

				if((i + 1) == oMes.intValue()) {
					producao.set(getMes(i), (Number) o[2]);
					qtdZero = false;
				}
			}

			if(qtdZero)
				producao.set(getMes(i), 0);
		}        
		
		for(int i=0; i < 12; i++) {
			boolean qtdZero = true;
			for(Object[] o : producaoMensal02) {
				Number oMes = (Number) o[0];

				if((i + 1) == oMes.intValue()) {
					producao02.set(getMes(i), (Number) o[2]);
					qtdZero = false;
				}
			}

			if(qtdZero)
				producao02.set(getMes(i), 0);
		}
		
		barProducao.addSeries(producao);
		barProducao.addSeries(producao02);
		
		return barProducao;
	}

	public String getAnoProducaoBar() {
		return anoProducaoBar;
	}

	public void setAnoProducaoBar(String anoProducaoBar) {
		this.anoProducaoBar = anoProducaoBar.replace("_","");
	}

	public int getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = Integer.valueOf(mes);
	}
	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getAnoProducaoBarCompare() {
		return anoProducaoBarCompare;
	}

	public void setAnoProducaoBarCompare(String anoProducaoBarCompare) {
		this.anoProducaoBarCompare = anoProducaoBarCompare.replace("_", "");
	}

	public String getAnoProducaoBarCompare02() {
		return anoProducaoBarCompare02;
	}

	public void setAnoProducaoBarCompare02(String anoProducaoBarCompare02) {
		this.anoProducaoBarCompare02 = anoProducaoBarCompare02.replace("_", "");
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
