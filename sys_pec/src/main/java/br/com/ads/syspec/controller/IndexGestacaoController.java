package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.repository.GestacaoRepository;

@Named
public class IndexGestacaoController implements Serializable{
	@Inject
	private GestacaoRepository gestacaoRepository;
	
	public List<Gestacao> getGestacoes(){
		return gestacaoRepository.findNotComprado();
	}
}
