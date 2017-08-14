package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.repository.RemedioRepository;
import br.com.ads.syspec.service.RemedioService;
import br.com.ads.syspec.util.FacesMessages;

@Named
@ViewScoped
public class CadastrarInsumoRemedio implements Serializable{
	@Inject
	private RemedioRepository remedioRepository;
	@Inject
	private RemedioService remedioService;
	@Inject
	private FacesMessages messages;
	
	private Remedio remedio = new Remedio();
	private List<Remedio> remedios = new ArrayList<>();
	
	
	public void initialize(){
		remedios = remedioRepository.findAll();
		System.out.println(remedios.size());
	}
	
	public void salvar(){
		remedioService.salvar(remedio);
		remedio = new Remedio();
		remedios = remedioRepository.findAll();
		messages.info("Cadastrado com Sucesso");
	}
	
	public Remedio getRemedio() {
		return remedio;
	}
	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}
	public List<Remedio> getRemedios() {
		System.out.println("OK");
		return remedios;
	}
	public void setRemedios(List<Remedio> remedios) {
		this.remedios = remedios;
	}
}
