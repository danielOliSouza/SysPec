package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.repository.AnimalRepository;

@Named
@ViewScoped
public class IndexAnimalController implements Serializable{
	@Inject
	private AnimalRepository animalRepository;
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
}
