package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Inseminacao;

public class AnimalRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Animal guardar(Animal animal) {
		return manager.merge(animal);
	}

	public List<Animal> findPorSexo(String sexo){
		return manager.createQuery("FROM Animal WHERE sexo = :sexo", Animal.class)
				.setParameter("sexo", sexo)
				.getResultList();
	}

	public Animal findPorIndentificador(String indentificador) {
		try{
			return manager.createQuery("FROM Animal WHERE indentificador = :indentificador", Animal.class)
					.setParameter("indentificador", indentificador)
					.getSingleResult();
		}catch (Exception e) {
			return null;
		}
	}

	public List<Animal> findAll() {
		return manager.createQuery("FROM Animal", Animal.class).getResultList();
	}

	public Animal findByGestacao(Gestacao gestacao){
		try{
			return manager.createQuery("FROM Animal WHERE gestacao.id = :gestacao_id", Animal.class)
					.setParameter("gestacao_id", gestacao.getId())
					.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
