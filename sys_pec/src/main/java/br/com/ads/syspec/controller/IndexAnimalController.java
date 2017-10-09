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
	
	public List<Animal> getAnimals(){
		return animalRepository.findAll();
	}
}
