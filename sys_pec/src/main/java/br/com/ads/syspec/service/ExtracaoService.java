package br.com.ads.syspec.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Extracao;
import br.com.ads.syspec.model.Ordenha;
import br.com.ads.syspec.repository.ExtracaoRepository;
import br.com.ads.syspec.util.Transacional;

public class ExtracaoService implements Serializable{
	@Inject
	private ExtracaoRepository extracaoRepository;
	
	@Transacional
	public void salvar(Extracao extracao) throws Exception {
		if(extracao.getOrdenhas().isEmpty())
			throw new Exception("Sem Registro de Ordenha Inserido");
		extracaoRepository.guardar(extracao);
	}

	public void addOrdenha(Ordenha ordenha, Extracao extracao) throws Exception{
		String msgException = "";
		
		if(ordenha.getAnimal() == null)
			msgException += " - Animal deve ser informado ";
		if(ordenha.getQtd() <= 0)
			msgException += " - Quantidade invalida \n";
		if(isAnimalNaExtracao(extracao, ordenha.getAnimal()))
			msgException += " - Este Animal já foi Inserido \n";
		
		if(!msgException.isEmpty())
			throw new Exception(msgException);
		extracao.addOrdenha(ordenha);
	}

	public boolean isAnimalNaExtracao(Extracao extracao, Animal animal) {
		List<Ordenha> ordenhas = extracao.getOrdenhas();
		for(Ordenha i : ordenhas) {
			if(i.getAnimal().getId() == animal.getId())
				return true;
		}
		return false;
	}
}
