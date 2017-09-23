package br.com.ads.syspec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String indentificador;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	private Date dtCadastro = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dtNascimento;
	
	private String sexo = "F";
	
	private String descricao;
	
	@NotNull
	@OneToOne
	@JoinColumn
	private Raca raca;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Procedencia procedencia;
	
	@OneToOne
	@JoinColumn
	private Animal mae;
	
	@OneToOne
	@JoinColumn
	private Animal pai;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Gestacao gestacao;
	
	private String dtEstimadaInicio;
	
	private String dtEstimadaFim;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Inseminacao inseminacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		if(gestacao!=null)
			gestacao.setDtParto(dtNascimento);
		this.dtNascimento = dtNascimento;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Procedencia getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		if(gestacao != null)
			gestacao.setProcedencia(procedencia);
		this.procedencia = procedencia;
	}

	public Animal getMae() {
		System.out.println(mae.indentificador);
		return mae;
	}

	public void setMae(Animal mae) {
		this.mae = mae;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		if(gestacao != null)
			gestacao.setPai(pai);
		this.pai = pai;
	}

	public String getDtEstimadaInicio() {
		return dtEstimadaInicio;
	}

	public void setDtEstimadaInicio(String dtEstimadaInicio) {
		this.dtEstimadaInicio = dtEstimadaInicio;
	}

	public String getDtEstimadaFim() {
		return dtEstimadaFim;
	}

	public void setDtEstimadaFim(String dtEstimadaFim) {
		this.dtEstimadaFim = dtEstimadaFim;
	}
	
	public Gestacao getGestacao() {
		return gestacao;
	}

	public void setGestacao(Gestacao gestacao) {
		this.gestacao = gestacao;
	}

	public Inseminacao getInseminacao() {
		return inseminacao;
	}

	public void setInseminacao(Inseminacao inseminacao) {
		this.inseminacao = inseminacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((dtEstimadaFim == null) ? 0 : dtEstimadaFim.hashCode());
		result = prime * result + ((dtEstimadaInicio == null) ? 0 : dtEstimadaInicio.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((gestacao == null) ? 0 : gestacao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((indentificador == null) ? 0 : indentificador.hashCode());
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((procedencia == null) ? 0 : procedencia.hashCode());
		result = prime * result + ((raca == null) ? 0 : raca.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Animal other = (Animal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (dtEstimadaFim == null) {
			if (other.dtEstimadaFim != null)
				return false;
		} else if (!dtEstimadaFim.equals(other.dtEstimadaFim))
			return false;
		if (dtEstimadaInicio == null) {
			if (other.dtEstimadaInicio != null)
				return false;
		} else if (!dtEstimadaInicio.equals(other.dtEstimadaInicio))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (gestacao == null) {
			if (other.gestacao != null)
				return false;
		} else if (!gestacao.equals(other.gestacao))
			return false;
		if (id != other.id)
			return false;
		if (indentificador == null) {
			if (other.indentificador != null)
				return false;
		} else if (!indentificador.equals(other.indentificador))
			return false;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (procedencia != other.procedencia)
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
}
