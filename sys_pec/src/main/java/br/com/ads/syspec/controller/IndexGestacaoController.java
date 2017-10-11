package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.repository.GestacaoRepository;

@Named
@ViewScoped
public class IndexGestacaoController implements Serializable{
	@Inject
	private GestacaoRepository gestacaoRepository;
	private Gestacao gestacaoSelecionado = new Gestacao();
	private List<Gestacao> gestacaos = null;
	
	public List<Gestacao> getGestacoes(){
		if(gestacaos == null)
			gestacaos = gestacaoRepository.findNotComprado();
		
		return gestacaos;
	}

	public Gestacao getGestacaoSelecionado() {
		return gestacaoSelecionado;
	}

	public void setGestacaoSelecionado(Gestacao gestacaoSelecionado) {
		this.gestacaoSelecionado = gestacaoSelecionado;
	}
	public String editarGestacao() {
		if(gestacaoSelecionado != null) {
			return "/AcompanhamentoVeterinario/CadastrarGestacao.xhtml?faces-redirect=true&idGestacao=" 
					+ String.valueOf(gestacaoSelecionado.getId());
		}
		return null;
	}
	public String addAnimalNascido() {
		if(gestacaoSelecionado != null) {
			return "/Animal/CadastroNovoAnimalIndividual.xhtml?faces-redirect=true&idGestacao="
					+String.valueOf(gestacaoSelecionado.getId());
		}
		return null;
	}
}
