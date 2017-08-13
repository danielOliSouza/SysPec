package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.Semen;
import br.com.ads.syspec.repository.SemenRepository;
import br.com.ads.syspec.util.Transacional;

public class SemenService implements Serializable{
	@Inject
	private SemenRepository semenRepository;
	@Transacional
	public void salvar(Semen semen) {
		semenRepository.guardar(semen);
	}

}
