package br.com.ads.syspec.model;

import java.text.SimpleDateFormat;
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

import br.com.ads.syspec.util.DateUtil;

@Entity
@Table(name = "animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String indentificador;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	private Date dtCadastro = new Date();
	
	@Column(nullable=true)
	private Double margemDiasDtNascimento ;
	
	private String sexo = "F";
	
	private String descricao;
	
	@NotNull
	@OneToOne
	@JoinColumn
	private Raca raca;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Gestacao gestacao;

	private String obs;

	
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
		if(gestacao != null)
			return gestacao.getDtParto();
		else
			return new Date();
	}

	public void setDtNascimento(Date dtNascimento) {
		if(gestacao == null)
			gestacao = new Gestacao();
		this.gestacao.setDtParto(dtNascimento);
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
	
	public Gestacao getGestacao() {
		return gestacao;
	}

	public void setGestacao(Gestacao gestacao) {
		this.gestacao = gestacao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public double getMargemDiasDtNascimento() {
		return margemDiasDtNascimento;
	}

	public void setMargemDiasDtNascimento(double margemDiasDtNascimento) {
		this.margemDiasDtNascimento = margemDiasDtNascimento;
	}
	
	public String getDtNascimentoEstimadaToString() {
		String response = "";
		
		if(getDtNascimento() != null && margemDiasDtNascimento != null) {
			Date max = DateUtil.somarDias(margemDiasDtNascimento / 2, getDtNascimento());
			Date min = DateUtil.subtrairDias(margemDiasDtNascimento / 2, getDtNascimento());
			
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			response = dt.format(min) + " à " + dt.format(max);
		}
		return response;
	}
}
