package br.com.ads.syspec.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Vacinacao;

public class VacinacaoRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public void guardar(Vacinacao vacinacao) {
		manager.merge(vacinacao);
	}

}
