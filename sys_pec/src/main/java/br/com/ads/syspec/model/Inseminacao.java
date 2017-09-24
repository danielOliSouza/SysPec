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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private boolean gestacao;
	
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
	public boolean isGestacao() {
		return gestacao;
	}
	public void setGestacao(boolean gestacao) {
		this.gestacao = gestacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dtInsemincao == null) ? 0 : dtInsemincao.hashCode());
		result = prime * result + (gestacao ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((semen == null) ? 0 : semen.hashCode());
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
		Inseminacao other = (Inseminacao) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dtInsemincao == null) {
			if (other.dtInsemincao != null)
				return false;
		} else if (!dtInsemincao.equals(other.dtInsemincao))
			return false;
		if (gestacao != other.gestacao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (semen == null) {
			if (other.semen != null)
				return false;
		} else if (!semen.equals(other.semen))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Inseminacao [id=" + id + ", semen=" + semen + ", animal=" + animal + ", dtInsemincao=" + dtInsemincao
				+ ", obs=" + obs + ", gestacao=" + gestacao + "]";
	}
	
}
