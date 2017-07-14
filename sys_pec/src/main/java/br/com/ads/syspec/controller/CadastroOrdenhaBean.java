package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.model.Ordenha;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.model.Raca;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.service.ExtracaoService;
import br.com.ads.syspec.util.FacesMessages;

@Named
@ViewScoped
public class CadastroOrdenhaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ExtracaoService extracaoService;
	@Inject
	private FacesMessages messages;
	@Inject 
	private AnimalRepository animalRepository;
	
	private List<Animal> animaisFemeas = new ArrayList<>();
	private Extracao extracao = new Extracao();
	private Ordenha novaOrdenha = new Ordenha();
	
	public void initialize() {
		animaisFemeas = animalRepository.findPorSexo("F");
	}
	
	public void addOrdenha() {
		try {
			extracaoService.addOrdenha(novaOrdenha, extracao);
			novaOrdenha= new Ordenha();
		} catch (Exception e) {
			messages.error(e.getMessage());
		}
		
	}
	
	public void salvar() {
		try {
			extracaoService.salvar(extracao);
		} catch (Exception e) {
			messages.error(e.getMessage());
		}
	}
	
	public Extracao getExtracao() {
		return extracao;
	}
	public void setExtracao(Extracao extracao) {
		this.extracao = extracao;
	}
	public Ordenha getNovaOrdenha() {
		return novaOrdenha;
	}
	public void setNovaOrdenha(Ordenha novaOrdenha) {
		this.novaOrdenha = novaOrdenha;
	}
	public List<Animal> getAnimaisFemeas() {
		return animaisFemeas;
	}
	public void setAnimaisFemeas(List<Animal> animaisFemeas) {
		this.animaisFemeas = animaisFemeas;
	}
	
}
