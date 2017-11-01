package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.repository.ExtracaoRepository;

@Named
@ViewScoped
public class IndexProducaoController implements Serializable{
	@Inject
	private ExtracaoRepository extracaoRepository;
	
	private Extracao extracaoSelecionada = new Extracao();
	
	public List<Extracao> getExtracoes(){
		return extracaoRepository.findAll();
	}
	
	public Number totalLeite(Number idExtracao) {
		return extracaoRepository.getTotalLeite((Long)idExtracao);
	}

	public Extracao getExtracaoSelecionada() {
		return extracaoSelecionada;
	}

	public void setExtracaoSelecionada(Extracao extracaoSelecionada) {
		this.extracaoSelecionada = extracaoSelecionada;
	}
	

	public String editarProducao() {
		if(extracaoSelecionada!= null) {
				return "/Producao/CadastroProducao?faces-redirect=true&idExtr=" 
					+ String.valueOf(extracaoSelecionada.getId());
		}
		return null;
	}
}
