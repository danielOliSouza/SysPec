package br.com.ads.syspec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table
public class Extracao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro")
	private Date dtCadastro = new Date();
	
	@NotNull
	@NotEmpty
	@Column(name="dt_extracao_inicio")
	private Date dtExtracaoInicio = new Date();
	
	@Column(name="dt_extracao_fim")
	private Date dtExtracaoFim = new Date();
	
	@OneToMany(mappedBy="extracao", cascade=CascadeType.ALL)
	private List<Ordenha> ordenhas = new ArrayList<Ordenha>();
	
	private String obs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtExtracaoInicio() {
		return dtExtracaoInicio;
	}

	public void setDtExtracaoInicio(Date dtExtracaoInicio) {
		this.dtExtracaoInicio = dtExtracaoInicio;
	}

	public Date getDtExtracaoFim() {
		return dtExtracaoFim;
	}

	public void setDtExtracaoFim(Date dtExtracaoFim) {
		this.dtExtracaoFim = dtExtracaoFim;
	}

	public List<Ordenha> getOrdenhas() {
		return ordenhas;
	}

	public void setOrdenhas(List<Ordenha> ordenhas) {
		this.ordenhas = ordenhas;
	}
	
	public void addOrdenha(Ordenha ordenha) {
		ordenha.setExtracao(this);
		ordenhas.add(ordenha);
	}
	
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
}
