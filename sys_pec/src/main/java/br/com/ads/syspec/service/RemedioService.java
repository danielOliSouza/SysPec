package br.com.ads.syspec.service;

import javax.inject.Inject;

import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.repository.RemedioRepository;

public class RemedioService {
	@Inject
	private RemedioRepository remedioRepository;
	
	public void salvar(Remedio remedio) {
		remedioRepository.guardar(remedio);
	}
}
