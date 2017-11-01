package br.com.ads.syspec.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Extracao;

public class ExtracaoRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public Extracao guardar(Extracao extracao)  {
		return manager.merge(extracao);
	}
	
	public List<Extracao> findAll(){
		return manager.createQuery("FROM Extracao", Extracao.class)
				.getResultList();
	}

	public Number getTotalLeite(Long idExtracao) {
		Number num = (Number) manager.createQuery("SELECT SUM(qtd) FROM Ordenha WHERE extracao.id = :idExt")
				.setParameter("idExt", idExtracao)
				.getSingleResult();
		
		return num;
	}

	public  Extracao findById(long id) {
		return manager.createQuery("FROM Extracao WHERE id = :idExtr", Extracao.class)
				.setParameter("idExtr", id)
				.getSingleResult();
	}
}
