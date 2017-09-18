package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Procedencia;

@Named
@ViewScoped
public class CadastrarGestacaoBean implements Serializable{
	private List<Animal> animals = new ArrayList<>();
	private Gestacao gestacao = new Gestacao();
	private int tipo = 1;
	
	@PostConstruct
	public void initialize() {
		Animal animal = new Animal();
		animal.setDescricao("Teste");
		animal.setIndentificador("Teste 01");
		animal.setProcedencia(Procedencia.NASCIMENTO_INSEMINACAO);
		
		animals.add(animal);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Gestacao getGestacao() {
		return gestacao;
	}

	public void setGestacao(Gestacao gestacao) {
		this.gestacao = gestacao;
	}
	
	public String getPaiORInseminacao() {
		String response = "";
		if(gestacao.getProcedencia() == Procedencia.NASCIMENTO_INSEMINACAO) {
			if(gestacao.getInseminacao() != null)
				response = String.valueOf(gestacao.getInseminacao().getId());
		}
		else if(gestacao.getProcedencia() == Procedencia.NASCIMENTO_NATURAL)
			if(gestacao.getPai() != null)
				response = String.valueOf(gestacao.getPai().getIndentificador());
		
		return response;
	}
	public void setPaiORInseminacao(String value) {
		
	}
	
	public int getOrdinalTipoGestacao() {
		if(gestacao.getProcedencia() != null)
			return gestacao.getProcedencia().ordinal() ;
		else
			return 0;
	}
	
	public void setOrdinalTipoGestacao(int ordinal) {
		Procedencia p = null;
		switch(ordinal) {
			case 0: p = Procedencia.ANIMAL_COMPRADO; break;
			case 1: p = Procedencia.NASCIMENTO_INSEMINACAO; break;
			case 2: p = Procedencia.NASCIMENTO_NATURAL; break;
		}
		
		gestacao.setProcedencia(p);
	}
	
}
