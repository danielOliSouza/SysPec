package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.ads.syspec.model.AplicacaoRemedio;
import br.com.ads.syspec.model.Insumo;

@Named
@ViewScoped
public class CadastrarAplicacaoRemedio implements Serializable{
	private Date dtAplicacao;
	private String tipoAplicacao;
	private Insumo remedio;
	private List<Insumo> insumosRemedios;
	private List<AplicacaoRemedio> aplicacaoes;

	
	
	
	
	
	//Getters And Setters
	public Date getDtAplicacao() {
		return dtAplicacao;
	}
	public void setDtAplicacao(Date dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
	public String getTipoAplicacao() {
		return tipoAplicacao;
	}
	public void setTipoAplicacao(String tipoAplicacao) {
		this.tipoAplicacao = tipoAplicacao;
	}
	public Insumo getRemedio() {
		return remedio;
	}
	public void setRemedio(Insumo remedio) {
		this.remedio = remedio;
	}
	public List<AplicacaoRemedio> getAplicacaoes() {
		return aplicacaoes;
	}
	public void setAplicacaoes(List<AplicacaoRemedio> aplicacaoes) {
		this.aplicacaoes = aplicacaoes;
	}
	public List<Insumo> getInsumosRemedios() {
		return insumosRemedios;
	}
	public void setInsumosRemedios(List<Insumo> insumosRemedios) {
		this.insumosRemedios = insumosRemedios;
	}
}
