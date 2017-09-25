package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.ads.syspec.service.AnimalService;
import br.com.ads.syspec.util.FacesMessages;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;
import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.model.Raca;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.GestacaoRepository;
import br.com.ads.syspec.repository.InseminacaoRepository;
import br.com.ads.syspec.repository.RacaRepository;

@Named
@ViewScoped
public class CadastroAnimalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AnimalService animalService;
	@Inject
	private RacaRepository racaRepository;
	@Inject
	private AnimalRepository animalRepository; 
	@Inject
	private GestacaoRepository gestacaoRepository;
	@Inject
	private InseminacaoRepository inseminacaoRepository;
	@Inject
	private FacesMessages messages;

	private Animal animal = new Animal();
	private List<Raca> racas;
	private List<Animal> animaisFemeas = new ArrayList<>();
	private List<Animal> animaisMachos = new ArrayList<>();
	private List<Inseminacao> inseminacaosSemCria = new ArrayList<>();

	private Date dtInicio = null;
	private Date dtFim = null;
	
	private boolean dtEstimada;
	
	public void initialize(){
		racas = racaRepository.findAll();
		animaisFemeas = animalRepository.findPorSexo("F");
		animaisMachos = animalRepository.findPorSexo("M");
		inseminacaosSemCria = inseminacaoRepository.findSemCria();
		animal.setGestacao(new Gestacao());
		
		try{
			Map<String, String> params =FacesContext.getCurrentInstance().
					getExternalContext().getRequestParameterMap();
			String parameterOne = params.get("idGestacao");

			if(!parameterOne.isEmpty()) {
				long id = Long.valueOf(parameterOne);
				Gestacao gestacao = gestacaoRepository.findById(id);

				Animal animalOld = animalRepository.findByGestacao(gestacao);
				
				if(animalOld != null){
					animal = animalOld;
				}
				else{
					animal.setGestacao(gestacao);
					animal.setRaca(gestacao.getAnimal().getRaca());
				}
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void salvar(){
		ValidacaoUtil vUtil = new ValidacaoUtil();
		
		animalService.salvar(animal,dtInicio, dtFim, dtEstimada,vUtil);
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID)
			messages.info(vUtil.getMensagemToString());
		else
			messages.error(vUtil.getMensagemToString());
	}
	
	public void tipoPorcedencia(){
		Procedencia procedencia = animal.getGestacao().getProcedencia();
		
		if(procedencia == Procedencia.NASCIMENTO_INSEMINACAO){
			animal.getGestacao().setPai(null);
		}
		else if(procedencia == Procedencia.NASCIMENTO_NATURAL){
			animal.getGestacao().setInseminacao(null);
		}
		else{
			animal.getGestacao().setPai(null);
			animal.getGestacao().setInseminacao(null);
			animal.getGestacao().setAnimal(null);
		}
	}
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public List<Raca> getRacas() {
		return racas;
	}
	public void setRacas(List<Raca> racas) {
		this.racas = racas;
	}
	public List<Animal> getAnimaisFemeas() {
		return animaisFemeas;
	}
	public void setAnimaisFemeas(List<Animal> animaisFemeas) {
		this.animaisFemeas = animaisFemeas;
	}
	public List<Animal> getAnimaisMachos() {
		return animaisMachos;
	}
	public void setAnimaisMachos(List<Animal> animaisMachos) {
		this.animaisMachos = animaisMachos;
	}
	public Procedencia[] getProcedencias(){
		return Procedencia.values();
	}
	
	public List<Inseminacao> getInseminacaosSemCria() {
		return inseminacaosSemCria;
	}

	public void setInseminacaosSemCria(List<Inseminacao> inseminacaosSemCria) {
		this.inseminacaosSemCria = inseminacaosSemCria;
	}

	public boolean isProcNatural(){
		if(animal.getGestacao().getProcedencia() == Procedencia.NASCIMENTO_NATURAL)
			return true;
		else
			return false;
	}
	
	public boolean isProcInseminacao(){
		if(animal.getGestacao().getProcedencia() == Procedencia.NASCIMENTO_INSEMINACAO)
			return true;
		else
			return false;
	}
	
	public boolean isProcComprado(){
		if(animal.getGestacao().getProcedencia() == Procedencia.ANIMAL_COMPRADO)
			return true;
		else
			return false;
	}

	public boolean isDtEstimada() {
		return dtEstimada;
	}

	public void setDtEstimada(boolean dtEstimada) {
		this.dtEstimada = dtEstimada;
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
	public void limparDatas(){
		if(dtEstimada)
			animal.getGestacao().setDtParto(null);
		else{
			dtFim = null;
			dtInicio= null;
		}
	}
}
