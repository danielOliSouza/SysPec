package br.com.ads.syspec.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.MotivoSaidaAnimal;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.service.AnimalService;
import br.com.ads.syspec.util.FacesMessages;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

@Named
@ViewScoped
public class IndexAnimalController implements Serializable{
	@Inject
	private AnimalRepository animalRepository;
	@Inject
	private AnimalService animalService;
	@Inject
	private FacesMessages messages;
	
	private Animal animalSelecionado = new Animal();
	
	public List<Animal> getAnimals(){
		return animalRepository.findAll();
	}

	public Animal getAnimalSelecionado() {
		return animalSelecionado;
	}

	public void setAnimalSelecionado(Animal animalSelecionado) {
		this.animalSelecionado = animalSelecionado;
	}

	public String editarAnimal() {
		if(animalSelecionado != null) {
			if(animalSelecionado.getGestacao() != null)
				return "/Animal/CadastroNovoAnimalIndividual.xhtml?faces-redirect=true&idGestacao=" 
					+ String.valueOf(animalSelecionado.getGestacao().getId());
		}
		return null;
	}
	public MotivoSaidaAnimal[] getMotivoSaidaAnimal(){
		return MotivoSaidaAnimal.values();
	}
	
	public void registrarSaida() {
		ValidacaoUtil vUtil = new ValidacaoUtil();
		animalService.salvar(animalSelecionado, null, null, false, vUtil);
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
			messages.info(vUtil.getMensagemToString());
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			 try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} catch (IOException e) {}
		}
		else {
			messages.error(vUtil.getMensagemToString());
		}
	}
}
