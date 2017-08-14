package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Remedio;

public class RemedioRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public List<Remedio> findAll() {
		return manager.createQuery("FROM Remedio ORDER BY id DESC", Remedio.class).getResultList();
	}

	public void guardar(Remedio remedio) {
		manager.merge(remedio);
	}

}
