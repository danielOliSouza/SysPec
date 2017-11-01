package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Ordenha;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.model.Raca;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.ExtracaoRepository;
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
	@Inject 
	private ExtracaoRepository extracaoRepository;
	
	private List<Animal> animaisFemeas = new ArrayList<>();
	private Extracao extracao = new Extracao();
	private Ordenha novaOrdenha = new Ordenha();
	
	public void initialize() {
		animaisFemeas = animalRepository.findPorSexo("F");
		
		try{
			Map<String, String> params =FacesContext.getCurrentInstance().
					getExternalContext().getRequestParameterMap();
			String parameterOne = params.get("idExtr");

			if(!parameterOne.isEmpty()) {
				Extracao extracaoParam = extracaoRepository.findById(Long.parseLong(parameterOne));
				
				if(extracaoParam != null)
					extracao = extracaoParam;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
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
			extracao = new Extracao();
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
