package br.com.ads.syspec.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Gestacao;

public class GestacaoRepository implements Serializable{
	@Inject
	private EntityManager manager;

	public void guardar(Gestacao gestacao) {
		manager.merge(gestacao);
	}
}
