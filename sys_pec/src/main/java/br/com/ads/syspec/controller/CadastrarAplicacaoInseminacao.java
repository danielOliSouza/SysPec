package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.model.Semen;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.InseminacaoRepository;
import br.com.ads.syspec.repository.SemenRepository;
import br.com.ads.syspec.service.InseminacaoService;
import br.com.ads.syspec.util.FacesMessages;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

@Named
@ViewScoped
public class CadastrarAplicacaoInseminacao implements Serializable{
	@Inject
	private InseminacaoRepository inseminacaoRepository;
	@Inject
	private AnimalRepository animalRepository;
	@Inject
	private SemenRepository semenRepository;
	@Inject 
	private InseminacaoService inseminacaoService;
	@Inject
	private FacesMessages msgs;
	
	private List<Inseminacao> insemincoes = new ArrayList<>();
	private List<Animal> animalsFemeas = new ArrayList<>();
	private List<Semen> semens = new ArrayList<>();
	private Inseminacao inseminacao = new Inseminacao();
	
	
	public void initialize() {
		insemincoes = inseminacaoRepository.findAll();
		animalsFemeas = animalRepository.findPorSexo("F");
		semens = semenRepository.findAll();
	}
	
	public void salvar() {
		ValidacaoUtil vUtil = new ValidacaoUtil();
		inseminacaoService.salvar(inseminacao, vUtil);
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
			insemincoes = inseminacaoRepository.findAll();
			inseminacao = new Inseminacao();
			msgs.info("Add com Sucesso");
		}
		
		else
			msgs.error(vUtil.getMensagemToString());
	}
	
	public List<Inseminacao> getInsemincoes() {
		return insemincoes;
	}

	public void setInsemincoes(List<Inseminacao> insemincoes) {
		this.insemincoes = insemincoes;
	}

	public List<Animal> getAnimalsFemeas() {
		return animalsFemeas;
	}

	public void setAnimalsFemeas(List<Animal> animalsFemeas) {
		this.animalsFemeas = animalsFemeas;
	}

	public Inseminacao getInseminacao() {
		return inseminacao;
	}

	public void setInseminacao(Inseminacao inseminacao) {
		this.inseminacao = inseminacao;
	}

	public List<Semen> getSemens() {
		return semens;
	}

	public void setSemens(List<Semen> semens) {
		this.semens = semens;
	}
}
