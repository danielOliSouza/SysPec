package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.repository.GestacaoRepository;
import br.com.ads.syspec.util.Transacional;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

public class GestacaoService implements Serializable{
	@Inject
	private GestacaoRepository gestacaoRepository;
	
	@Transacional
	public void salvar(Gestacao gestacao, ValidacaoUtil vUtil) {
		if(gestacao.getProcedencia() == Procedencia.NASCIMENTO_NATURAL)
			gestacao.setInseminacao(null);
		else
			gestacao.setPai(null);
		
		if(gestacao.getDtInicioGestacao().getTime() > gestacao.getDtParto().getTime()) {
			vUtil.addMensagem("Dt. Inicio da Gestação não pode ser maior que a data de Parto");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}
		
		try {
			if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
				gestacaoRepository.guardar(gestacao);
				vUtil.addMensagem("Salvo com Sucesso");
			}
		}catch (Exception e) {
			vUtil.addMensagem("Erro interno tente novamente mais tarde :(");
			vUtil.setValidacaoStatus(ValidacaoStatus.ERRO);
		}
	}
}
