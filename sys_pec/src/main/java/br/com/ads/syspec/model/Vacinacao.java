package br.com.ads.syspec.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Vacinacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	@Column(name="dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro = new Date();
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="dt_aplicacao")
	private Date dtAplicao = new Date();
	@NotEmpty
	private String tipo;
	@NotNull
	@OneToOne
	private Insumo remedio;
	private String campanha;
	@NotNull
	@OneToMany(mappedBy="vacinacao", cascade=CascadeType.ALL)
	private List<AplicacaoRemedio> aplicacaoRemedios = new ArrayList<>();
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
	public Date getDtAplicao() {
		return dtAplicao;
	}
	public void setDtAplicao(Date dtAplicao) {
		this.dtAplicao = dtAplicao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Insumo getRemedio() {
		return remedio;
	}
	public void setRemedio(Insumo remedio) {
		this.remedio = remedio;
	}
	public String getCampanha() {
		return campanha;
	}
	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}
	public List<AplicacaoRemedio> getAplicacaoRemedios() {
		return aplicacaoRemedios;
	}
	public void setAplicacaoRemedios(List<AplicacaoRemedio> aplicacaoRemedios) {
		this.aplicacaoRemedios = aplicacaoRemedios;
	}
	public void addAplicacaoRemedios(AplicacaoRemedio aplicacaoRemedio){
		aplicacaoRemedio.setVacinacao(this);
		aplicacaoRemedios.add(aplicacaoRemedio);
	}
}
