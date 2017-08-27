package br.com.ads.syspec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Inseminacao implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@OneToOne
	private Semen semen;
	@NotNull
	@OneToOne
	private Animal animal;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dtInsemincao = new Date();
	private String obs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Semen getSemen() {
		return semen;
	}
	public void setSemen(Semen semen) {
		this.semen = semen;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Date getDtInsemincao() {
		return dtInsemincao;
	}
	public void setDtInsemincao(Date dtInsemincao) {
		this.dtInsemincao = dtInsemincao;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
