package br.com.ads.syspec.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Gestacao;

public class GestacaoRepository implements Serializable{
	@Inject
	private EntityManager manager;

	public void guardar(Gestacao gestacao) {
		gestacao.setId(manager.merge(gestacao).getId());
	}

	public Gestacao findById(Long id) {
		return manager.find(Gestacao.class, id);
	}
}
