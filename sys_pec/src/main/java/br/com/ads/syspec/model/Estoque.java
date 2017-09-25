package br.com.ads.syspec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Estoque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy="estoque")
	private Insumo insumo;
	
	@OneToMany(mappedBy="estoque" ,cascade=CascadeType.ALL)
	private List<AtualizacaoEstoque> atualizacaoEstoque= new ArrayList<>();

	@Transient
	private double qtdEstoque = 0f;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public List<AtualizacaoEstoque> getAtualizacaoEstoque() {
		return atualizacaoEstoque;
	}

	public void setAtualizacaoEstoque(List<AtualizacaoEstoque> atualizacaoEstoque) {
		this.atualizacaoEstoque = atualizacaoEstoque;
	}
	
	public void addAtualizacaoEstoque(AtualizacaoEstoque atualizacao){
		atualizacao.setEstoque(this);
		atualizacaoEstoque.add(atualizacao);
	}

	public double getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
}
