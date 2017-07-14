package br.com.ads.syspec.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Ordenha implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@NotNull
	private Animal animal;
	
	@OneToOne
	@NotNull
	private Extracao extracao;
	
	@NotEmpty
	private String qtd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Extracao getExtracao() {
		return extracao;
	}

	public void setExtracao(Extracao extracao) {
		this.extracao = extracao;
	}

	public String getQtd() {
		return qtd;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
}
