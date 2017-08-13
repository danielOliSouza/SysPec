package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Raca;
import br.com.ads.syspec.model.Semen;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.RacaRepository;
import br.com.ads.syspec.repository.SemenRepository;
import br.com.ads.syspec.service.SemenService;

@Named
@ViewScoped
public class CadastrarInsumoSemen implements Serializable{
	@Inject
	private SemenRepository semenRepository;
	@Inject
	private RacaRepository racaRepository;
	@Inject 
	private AnimalRepository animalRepository;
	@Inject 
	private SemenService semenService;
	
	private Semen semen = new Semen();
	private List<Semen> semens = new ArrayList<>();
	private List<Raca> racas = new ArrayList<>();
	private List<Animal> animalMachos = new ArrayList<>();
	
	public void initialize(){
		semens = semenRepository.findAll();
		racas = racaRepository.findAll();
		animalMachos = animalRepository.findPorSexo("M");
	}
	
	
	public void salvar(){
		semenService.salvar(semen);
		semen = new Semen();
		semens = semenRepository.findAll();
	}
	
	public List<Raca> getRacas() {
		return racas;
	}
	public void setRacas(List<Raca> racas) {
		this.racas = racas;
	}
	public Semen getSemen() {
		return semen;
	}
	public void setSemen(Semen semen) {
		this.semen = semen;
	}
	public List<Semen> getSemens() {
		return semens;
	}
	public void setSemens(List<Semen> semens) {
		this.semens = semens;
	}
	public List<Animal> getAnimalMachos() {
		return animalMachos;
	}
	public void setAnimalMachos(List<Animal> animalMachos) {
		this.animalMachos = animalMachos;
	}
}
