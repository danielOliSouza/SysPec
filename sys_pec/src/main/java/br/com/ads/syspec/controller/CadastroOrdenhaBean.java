package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.model.Ordenha;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.model.Raca;

@Named
@ViewScoped
public class CadastroOrdenhaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Animal> animaisFemeas = new ArrayList<>();
	private Extracao extracao = new Extracao();
	private Ordenha novaOrdenha = new Ordenha();
	
	public void initialize() {
		for(int i=0; i < 10; i++) {
			Animal animal = new Animal();
			animal.setDescricao("Animal F - " + String.valueOf(i));
			animal.setDtNascimento(new Date());
			animal.setId(new Long(i));
			animal.setIndentificador(String.valueOf(i));
			animal.setProcedencia(Procedencia.ANIMAL_COMPRADO);
			animal.setRaca(new Raca());
			animal.setSexo("F");
			
			animaisFemeas.add(animal);
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
