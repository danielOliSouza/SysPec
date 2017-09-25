package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.util.Transacional;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

public class EstoqueService implements Serializable{
	@Inject
	private EstoqueRepository estoqueRepository;
	
	@Transacional
	public void salvar(AtualizacaoEstoque atualizacaoEstoque, Estoque estoque, ValidacaoUtil vUtil) {
		atualizacaoEstoque.setEstoque(estoque);
		if(atualizacaoEstoque.getQtd() == 0) {
			vUtil.addMensagem("Operação Negada - Informe Quantidade diferente de '0'");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}
		
		if(estoque == null) {
			vUtil.addMensagem("Selecione um Insumo");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}
		
		if(atualizacaoEstoque.getQtd() < 0)
			atualizacaoEstoque.setQtd(atualizacaoEstoque.getQtd() * -1);
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
			estoqueRepository.guardar(atualizacaoEstoque);
			vUtil.addMensagem("Realizado com sucesso");
		}
	}

}
