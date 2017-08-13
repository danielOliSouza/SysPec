package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Semen;

public class SemenRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public List<Semen> findAll() {
		return manager.createQuery("FROM Semen ORDER BY id DESC", Semen.class).getResultList();
	}

	public void guardar(Semen semen) {
		manager.merge(semen);		
	}
	
}
