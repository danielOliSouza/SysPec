package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.AplicacaoRemedio;
import br.com.ads.syspec.model.Vacinacao;
import br.com.ads.syspec.repository.VacinacaoRepository;

@Named
@ViewScoped
public class IndexVacinacaoController implements Serializable{
	@Inject
	private VacinacaoRepository vacinacaoRepository;
	private List<Vacinacao> vacinacaos = null;
	private Vacinacao vacinacaoSelecionado;
	
	public List<Vacinacao> getVacinacaos() {
		if(vacinacaos == null)
			vacinacaos = vacinacaoRepository.findAll();
		return vacinacaos;
	}
	
	public Vacinacao getVacinacaoSelecionado() {
		return vacinacaoSelecionado;
	}
	public void setVacinacaoSelecionado(Vacinacao vacinacaoSelecionado) {
		this.vacinacaoSelecionado = vacinacaoSelecionado;
	}
	public String editarVacinacao() {
		if(vacinacaoSelecionado != null) {
			return "/AcompanhamentoVeterinario/CadastrarVacinacao.xhtml?faces-redirect=true&idVacinacao=" 
					+ String.valueOf(vacinacaoSelecionado.getId());
		}
		return null;
	}
}
