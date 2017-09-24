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
	private Date dtParto;
	
	private String obs;
	@Enumerated(EnumType.STRING)
	private Procedencia procedencia;
	@OneToOne(cascade=CascadeType.MERGE)
	private Inseminacao inseminacao;
	@OneToOne
	private Animal pai;
	
	private Boolean partoSucesso = false;
	
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
		if(inseminacao != null)
			this.animal = inseminacao.getAnimal();
		this.inseminacao = inseminacao;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		this.pai = pai;
	}

	public Boolean getPartoSucesso() {
		return partoSucesso;
	}

	public void setPartoSucesso(Boolean partoSucesso) {
		this.partoSucesso = partoSucesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dtInicioGestacao == null) ? 0 : dtInicioGestacao.hashCode());
		result = prime * result + ((dtParto == null) ? 0 : dtParto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inseminacao == null) ? 0 : inseminacao.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((partoSucesso == null) ? 0 : partoSucesso.hashCode());
		result = prime * result + ((procedencia == null) ? 0 : procedencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gestacao other = (Gestacao) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dtInicioGestacao == null) {
			if (other.dtInicioGestacao != null)
				return false;
		} else if (!dtInicioGestacao.equals(other.dtInicioGestacao))
			return false;
		if (dtParto == null) {
			if (other.dtParto != null)
				return false;
		} else if (!dtParto.equals(other.dtParto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inseminacao == null) {
			if (other.inseminacao != null)
				return false;
		} else if (!inseminacao.equals(other.inseminacao))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (partoSucesso == null) {
			if (other.partoSucesso != null)
				return false;
		} else if (!partoSucesso.equals(other.partoSucesso))
			return false;
		if (procedencia != other.procedencia)
			return false;
		return true;
	}
	
}
