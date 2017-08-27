package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.repository.InseminacaoRepository;
import br.com.ads.syspec.util.Transacional;

public class InseminacaoService implements Serializable{
	@Inject
	private InseminacaoRepository inseminacaoRepository;
	
	@Transacional
	public void salvar(Inseminacao inseminacao) {
		inseminacaoRepository.guardar(inseminacao);
	}

}
