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
		 return manager.createQuery("FROM Inseminacao WHERE id =:id", Inseminacao.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public void guardar(Inseminacao inseminacao) {
		manager.merge(inseminacao);
	}
	
	public List<Inseminacao> findPorAnimal(Long animalId){
		if(animalId == null)
			animalId = 0l;
		return manager.createQuery("FROM Inseminacao  WHERE animal_id = :animalId ORDER BY dtInsemincao, id DESC", Inseminacao.class)
				.setParameter("animalId", animalId)
				.getResultList();
	}
	public List<Inseminacao> findSemCria(){
		return manager.createQuery("FROM Inseminacao as i WHERE NOT EXISTS"
				+ "(SELECT a.gestacao.inseminacao.id from Animal as a WHERE a.gestacao.inseminacao.id = i.id)", Inseminacao.class)
				.getResultList();
	}
}
