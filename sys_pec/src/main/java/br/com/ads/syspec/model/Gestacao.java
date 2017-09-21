package br.com.ads.syspec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Gestacao implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Animal animal = new Animal();

	@Temporal(TemporalType.DATE)
	private Date dtInicioGestacao = new Date();
	@Temporal(TemporalType.DATE)
	private Date dtParto = new Date();
	
	private String obs;
	@Enumerated(EnumType.STRING)
	private Procedencia procedencia;
	@OneToOne(cascade=CascadeType.MERGE)
	private Inseminacao inseminacao;
	@OneToOne
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
