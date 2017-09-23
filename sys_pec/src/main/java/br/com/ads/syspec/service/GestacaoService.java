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

		if(gestacao.getDtParto() == null){
			if(gestacao.getPartoSucesso()){
				vUtil.addMensagem("Insira Data de Parto");
				vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			}
		}
		else{
			if(gestacao.getDtInicioGestacao().getTime() > gestacao.getDtParto().getTime()) {
				vUtil.addMensagem("Dt. Inicio da Gestação não pode ser maior que a data de Parto");
				vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			}
		}
		try {
			if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
				gestacao.setPartoSucesso(false); //Só sera true quando inserir o registro da cria(Filho)
				gestacaoRepository.guardar(gestacao);
				vUtil.addMensagem("Salvo com Sucesso");
			}
		}catch (Exception e) {
			vUtil.addMensagem("Erro interno tente novamente mais tarde :(");
			vUtil.setValidacaoStatus(ValidacaoStatus.ERRO);
		}
	}

	public void verificaRedirecionamento(Gestacao gestacao, ValidacaoUtil vUtil) {
		Gestacao gestacaoOld = null;
		if(gestacao.getDtParto() == null){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Insira Dt. de Parto Para Inserir o Registro da Cria. ");
		}

		if(gestacao.getId() == null){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Salve esse Registro Para Inserir a Cria. ");
		}
		else{
			gestacaoOld =gestacaoRepository.findById(gestacao.getId());
			if(gestacaoOld != null){
				//Coloco igual para "IGNORAR" na hora do equals se o parto sucesso
				gestacaoOld.setPartoSucesso(gestacao.getPartoSucesso());

				if(!gestacaoOld.equals(gestacao)){
					vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
					vUtil.addMensagem("Salve as Mudanças no Registro Para Inserir a Cria. ");
				}
			}
			else{
				vUtil.setValidacaoStatus(ValidacaoStatus.ERRO);
				vUtil.addMensagem("Houve um Erro Interno :( \n"
						+ "Não foi possivel encontrar o registro");

			}

		}

	}
}
