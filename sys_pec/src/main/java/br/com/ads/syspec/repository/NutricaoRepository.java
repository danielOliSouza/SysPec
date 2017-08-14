package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Nutricao;

public class NutricaoRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	
	public List<Nutricao> findAll() {
		return manager.createQuery("FROM Nutricao ORDER BY id DESC", Nutricao.class).getResultList();
	}


	public void guardar(Nutricao nutricao) {
		manager.merge(nutricao);
	}

}
