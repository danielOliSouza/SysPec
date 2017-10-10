package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Procedencia;

public class GestacaoRepository implements Serializable{
	@Inject
	private EntityManager manager;

	public void guardar(Gestacao gestacao) {
		gestacao.setId(manager.merge(gestacao).getId());
	}

	public Gestacao findById(Long id) {
		return manager.find(Gestacao.class, id);
	}

	public List<Gestacao> findAll() {
		return  manager.createQuery("FROM Gestacao", Gestacao.class).getResultList();
	}
	
	public List<Gestacao> findNotComprado() {
		return  manager.createQuery("FROM Gestacao WHERE procedencia != :proc", Gestacao.class)
				.setParameter("proc", Procedencia.ANIMAL_COMPRADO)
				.getResultList();
	}
}
