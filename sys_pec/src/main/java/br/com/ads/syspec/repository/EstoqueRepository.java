package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;

public class EstoqueRepository implements Serializable{
	@Inject
	private EntityManager manager;

	public List<Estoque> findAll() {
		List<Estoque> estoques =  manager.createQuery("FROM Estoque", Estoque.class).getResultList();

		for(Estoque estq : estoques){
			Double qtd = (Double) manager.createQuery("SELECT SUM(qtd) FROM AtualizacaoEstoque WHERE estoque_id = :id")
			.setParameter("id", estq.getId())
			.getSingleResult();
		
			estq.setQtdEstoque((qtd == null) ? 0f : qtd);
		}
		
		return estoques;
	}
	
	public List<AtualizacaoEstoque> findAtualizacaoByEstoque(Estoque estoque){
		return manager.createQuery("FROM AtualizacaoEstoque WHERE estoque_id = :id", AtualizacaoEstoque.class)
				.setParameter("id", estoque.getId())
				.getResultList();
	}

}
