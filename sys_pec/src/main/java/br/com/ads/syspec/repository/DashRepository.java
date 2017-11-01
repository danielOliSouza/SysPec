package br.com.ads.syspec.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DashRepository implements Serializable{
	@Inject
	private EntityManager manager;
	
	public void getProducaoMensal() {
		
	}
}
