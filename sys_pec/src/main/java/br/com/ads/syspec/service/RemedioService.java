package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.repository.RemedioRepository;
import br.com.ads.syspec.util.Transacional;

public class RemedioService implements Serializable {
	@Inject
	private RemedioRepository remedioRepository;
	
	@Transacional
	public void salvar(Remedio remedio) {
		remedioRepository.guardar(remedio);
	}
}
