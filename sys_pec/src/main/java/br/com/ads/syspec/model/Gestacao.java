package br.com.ads.syspec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gestacao implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private Animal animal = new Animal();

	private Date dtInicioGestacao = new Date();
	
	private Date dtParto = new Date();
	
	private String obs;
	
	private Procedencia procedencia;
	
	private Inseminacao inseminacao;
	
	private Animal pai;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getDtInicioGestacao() {
		return dtInicioGestacao;
	}

	public void setDtInicioGestacao(Date dtInicioGestacao) {
		this.dtInicioGestacao = dtInicioGestacao;
	}

	public Date getDtParto() {
		return dtParto;
	}

	public void setDtParto(Date dtParto) {
		this.dtParto = dtParto;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Procedencia getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}

	public Inseminacao getInseminacao() {
		return inseminacao;
	}

	public void setInseminacao(Inseminacao inseminacao) {
		this.inseminacao = inseminacao;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		this.pai = pai;
	}
	
}
