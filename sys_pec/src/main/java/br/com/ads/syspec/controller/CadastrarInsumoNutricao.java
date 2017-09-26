package br.com.ads.syspec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Nutricao;
import br.com.ads.syspec.repository.NutricaoRepository;
import br.com.ads.syspec.service.NutricaoService;
import br.com.ads.syspec.util.FacesMessages;

@Named
@ViewScoped
public class CadastrarInsumoNutricao implements java.io.Serializable{
	@Inject
	private NutricaoRepository nutricaoRepository;
	@Inject
	private NutricaoService nutricaoService;
	@Inject
	private FacesMessages messages;
	private float qtd;
	
	private List<Nutricao> nutricaos = new ArrayList<>();
	private Nutricao nutricao = new Nutricao();

	public  void initialize(){
		nutricaos = nutricaoRepository.findAll();
	}

	public void salvar(){
		nutricaoService.salvar(nutricao);
		nutricaos = nutricaoRepository.findAll();
		messages.info("Cadastrado com sucesso");
	}
	
	public List<Nutricao> getNutricaos() {
		return nutricaos;
	}

	public void setNutricaos(List<Nutricao> nutricaos) {
		this.nutricaos = nutricaos;
	}

	public Nutricao getNutricao() {
		return nutricao;
	}

	public void setNutricao(Nutricao nutricao) {
		this.nutricao = nutricao;
	}
}
