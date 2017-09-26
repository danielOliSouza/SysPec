package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.model.Semen;

public class SemenRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public List<Semen> findAll() {
		List<Semen> semens =  manager.createQuery("FROM Semen", Semen.class).getResultList();
		

		for(Semen s : semens){
			Float qtdEntrada = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'semen' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", s.getId())
					.setParameter("movi", "ENTRADA")
					.getSingleResult();
			
			Float qtdBaixa = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'semen' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", s.getId())
					.setParameter("movi", "BAIXA")
					.getSingleResult();
			
			if(qtdBaixa == null)
				qtdBaixa = 0f;
			
			if(qtdEntrada == null)
				qtdEntrada = 0f;
			
			s.getEstoque().setQtdEstoque(qtdEntrada - qtdBaixa);
		}


		
		
		return semens;
	}

	public Semen guardar(Semen semen) {
		return manager.merge(semen);		
	}
	
}
