package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Inseminacao;

public class InseminacaoRepository implements Serializable {
	@Inject
	private EntityManager manager;
	
	public List<Inseminacao> findAll(){
		return manager.createQuery("FROM Inseminacao ORDER BY dtInsemincao, id DESC", Inseminacao.class)
				.getResultList();
	}
	
	public Inseminacao findById(Long id){
		return manager.find(Inseminacao.class, id);
	}
	
	public void guardar(Inseminacao inseminacao) {
		manager.merge(inseminacao);
	}
	
	public List<Inseminacao> findPorAnimal(Long animalId){
		return manager.createQuery("FROM Inseminacao  WHERE animal_id = :animalId ORDER BY dtInsemincao, id DESC", Inseminacao.class)
				.setParameter("animalId", animalId)
				.getResultList();
	}
}
