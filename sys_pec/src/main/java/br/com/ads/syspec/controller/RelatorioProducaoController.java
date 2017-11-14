package br.com.ads.syspec.controller;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.ads.syspec.services.ProcessadorRelatorios;
import br.com.ads.syspec.util.FacesMessages;

@Named
@ViewScoped
public class RelatorioProducaoController implements Serializable{
	@Inject
	private FacesMessages messages;
	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletResponse response; 

	@Inject
	private EntityManager manager;
	
	//30 dias antes do atual
	private Date dtInicio = new Date(new Date().getTime() - (long) (86400l * 30l) * 1000l); 
	private Date dtFim = new Date();

	public void imprimir() {
		
		System.out.println(dtInicio);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("dt_inicio", this.dtInicio);
		parametros.put("dt_fim", this.dtFim);
		
		ProcessadorRelatorios executor = new ProcessadorRelatorios("/relatorios/producao_por_dia.jasper",
				this.response, parametros, "relatorio.pdf");
		
		manager.unwrap(Session.class).doWork(executor);
		
		if (executor.isRelatorioVazio()) {
			messages.error("Nenhuma Produção neste período!");
		} else {
			facesContext.responseComplete();
		}
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
}
