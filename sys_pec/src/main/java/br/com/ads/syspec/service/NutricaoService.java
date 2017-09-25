package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.model.Nutricao;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.repository.NutricaoRepository;
import br.com.ads.syspec.util.Transacional;

public class NutricaoService implements Serializable{
	@Inject
	private NutricaoRepository nutricaoRepository;
	@Inject
	private EstoqueRepository estoqueRepository;
	
	@Transacional
	public void salvar(Nutricao nutricao) {
		nutricao.getEstoque().setInsumo(nutricao);
		nutricaoRepository.guardar(nutricao);
	}

}
