package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.ads.syspec.model.Raca;

public class RacaRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Raca> findAll() {
		List<Raca> result;
		try {
			result = manager.createQuery("FROM Raca", Raca.class).getResultList();
		} catch (NoResultException e) {
			result = new ArrayList<>();
		}
		return result;
	}
}
