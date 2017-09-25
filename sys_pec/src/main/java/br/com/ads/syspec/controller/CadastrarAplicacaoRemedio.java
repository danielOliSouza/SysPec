package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.AplicacaoRemedio;
import br.com.ads.syspec.model.Insumo;
import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.model.Vacinacao;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.RemedioRepository;
import br.com.ads.syspec.service.VacinaService;
import br.com.ads.syspec.util.ValidacaoUtil;

@Named
@ViewScoped
public class CadastrarAplicacaoRemedio implements Serializable{
	@Inject
	private AnimalRepository animalRepository;
	@Inject
	private br.com.ads.syspec.util.FacesMessages messages;
	@Inject 
	private RemedioRepository remedioRepository;
	@Inject
	private VacinaService vacinaService;
	
	private Vacinacao vacinacao = new Vacinacao();
	private AplicacaoRemedio novaAplicacao = new AplicacaoRemedio();
	private List<Animal> animais= new ArrayList<>();
	private List<Remedio> remedios = new ArrayList<>();
	
	public void initialize(){
		vacinacao = new Vacinacao();
		novaAplicacao = new AplicacaoRemedio();
		animais = animalRepository.findAll();
		remedios = remedioRepository.findAll();
	}

	public void addAplicacao(){
		ValidacaoUtil vUtil = new ValidacaoUtil();
		
		if(vacinaService.addAplicacaoRemedio(novaAplicacao, vacinacao, vUtil)){
			novaAplicacao = new AplicacaoRemedio();
			messages.info("Add Com Sucesso");
		}
		else
			messages.error(vUtil.getMensagemToString());
		
	}
	
	public void salvar(){
		ValidacaoUtil vUtil = new ValidacaoUtil();
		
		System.out.println("OK");
		
		if(vacinaService.salvar(vacinacao, vUtil)) {
			messages.info(vUtil.getMensagemToString());
			vacinacao = new Vacinacao();
		}
		else
			messages.error(vUtil.getMensagemToString());
	}
	public Vacinacao getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(Vacinacao vacinacao) {
		this.vacinacao = vacinacao;
	}

	public AplicacaoRemedio getNovaAplicacao() {
		return novaAplicacao;
	}

	public void setNovaAplicacao(AplicacaoRemedio novaAplicacao) {
		this.novaAplicacao = novaAplicacao;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<Remedio> getRemedios() {
		return remedios;
	}

	public void setRemedios(List<Remedio> remedios) {
		this.remedios = remedios;
	}
	
}
