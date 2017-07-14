package br.com.ads.syspec.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ads.syspec.model.Extracao;

public class ExtracaoRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public Extracao guardar(Extracao extracao)  {
		return manager.merge(extracao);
	}

}
