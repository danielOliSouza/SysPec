package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.model.MovimentacaoTipo;

public class EstoqueRepository implements Serializable{
	@Inject
	private EntityManager manager;

	public List<Estoque> findAll() {
		List<Estoque> estoques =  manager.createQuery("FROM Estoque", Estoque.class).getResultList();
		

		for(Estoque estq : estoques){
			Float qtdEntrada = (Float) manager.createNativeQuery("SELECT SUM(qtd)  FROM atualizacaoestoque WHERE estoque_id = :id AND movimentacaotipo like :movi")
					.setParameter("id", estq.getId())
					.setParameter("movi", "ENTRADA")
					.getSingleResult();
			
			Float qtdBaixa = (Float)  manager.createNativeQuery("SELECT SUM(qtd)  FROM atualizacaoestoque WHERE estoque_id = :id AND movimentacaotipo like :movi")
					.setParameter("id", estq.getId())
					.setParameter("movi", "BAIXA")
					.getSingleResult();
			
			if(qtdBaixa == null)
				qtdBaixa = 0f;
			
			if(qtdEntrada == null)
				qtdEntrada = 0f;
			
			estq.setQtdEstoque(qtdEntrada - qtdBaixa);
		}


		
		
		return estoques;
	}
	
	public List<AtualizacaoEstoque> findAtualizacaoByEstoque(Estoque estoque){
		return manager.createQuery("FROM AtualizacaoEstoque WHERE estoque_id = :id", AtualizacaoEstoque.class)
				.setParameter("id", estoque.getId())
				.getResultList();
	}

	public void guardar(AtualizacaoEstoque atualizacaoEstoque) {
		manager.merge(atualizacaoEstoque);
	}

}
