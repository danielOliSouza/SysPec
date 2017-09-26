package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.model.Nutricao;
import br.com.ads.syspec.model.Remedio;

public class RemedioRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public List<Remedio> findAll() {
		List<Remedio> remedios =  manager.createQuery("FROM Remedio", Remedio.class).getResultList();
		

		for(Remedio r : remedios){
			Float qtdEntrada = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'remedio' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", r.getId())
					.setParameter("movi", "ENTRADA")
					.getSingleResult();
			
			Float qtdBaixa = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'remedio' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", r.getId())
					.setParameter("movi", "BAIXA")
					.getSingleResult();
			
			if(qtdBaixa == null)
				qtdBaixa = 0f;
			
			if(qtdEntrada == null)
				qtdEntrada = 0f;
			
			r.getEstoque().setQtdEstoque(qtdEntrada - qtdBaixa);
		}


		
		
		return remedios;
	}

	public Remedio guardar(Remedio remedio) {
		return manager.merge(remedio);
	}

}
