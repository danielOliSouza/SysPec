package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.repository.EstoqueRepository;

@Named
@ViewScoped
public class EstoqueBean implements Serializable{
	@Inject 
	private EstoqueRepository estoqueRepository;
	private List<Estoque> estoques = new ArrayList<>();
 	private Estoque estoqueSelecionado;
	private List<AtualizacaoEstoque> atualizacaoEstoques = new ArrayList<>();
	
	public void initialize(){
		estoques = estoqueRepository.findAll();
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque getEstoqueSelecionado() {
		return estoqueSelecionado;
	}

	public void setEstoqueSelecionado(Estoque estoqueSelecionado) {
		this.estoqueSelecionado = estoqueSelecionado;
		if(estoqueSelecionado != null){
			atualizacaoEstoques = estoqueRepository.findAtualizacaoByEstoque(estoqueSelecionado);
		}
	}

	public List<AtualizacaoEstoque> getAtualizacaoEstoques() {
		return atualizacaoEstoques;
	}
}
