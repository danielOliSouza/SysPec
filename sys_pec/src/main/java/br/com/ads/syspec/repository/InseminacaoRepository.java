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

	public void guardar(Inseminacao inseminacao) {
		try {
		manager.merge(inseminacao);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
