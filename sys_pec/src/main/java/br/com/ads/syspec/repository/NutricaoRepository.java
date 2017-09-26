package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Nutricao;
import br.com.ads.syspec.model.Remedio;

public class NutricaoRepository implements Serializable{
	@Inject
	private EntityManager manager;


	public List<Nutricao> findAll() {
		List<Nutricao> nutricoes =  manager.createQuery("FROM Nutricao", Nutricao.class).getResultList();


		for(Nutricao n : nutricoes){
			Float qtdEntrada = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'nutricao' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", n.getId())
					.setParameter("movi", "ENTRADA")
					.getSingleResult();

			Float qtdBaixa = (Float) manager.createNativeQuery("SELECT SUM(qtd) "
					+ "FROM atualizacaoestoque AS ae INNER JOIN estoque AS e on e.id = ae.estoque_id "
					+ "INNER JOIN insumo AS i ON i.estoque_id = e.id "
					+ "WHERE i.tipo like 'nutricao' AND ae.movimentacaotipo like :movi AND i.id = :id ")
					.setParameter("id", n.getId())
					.setParameter("movi", "BAIXA")
					.getSingleResult();

			if(qtdBaixa == null)
				qtdBaixa = 0f;

			if(qtdEntrada == null)
				qtdEntrada = 0f;

			n.getEstoque().setQtdEstoque(qtdEntrada - qtdBaixa);
		}




		return nutricoes;
	}


	public Nutricao guardar(Nutricao nutricao) {
		return manager.merge(nutricao);
	}

}
