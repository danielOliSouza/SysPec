package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.model.MovimentacaoTipo;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.repository.InseminacaoRepository;
import br.com.ads.syspec.util.Transacional;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

public class InseminacaoService implements Serializable{
	@Inject
	private InseminacaoRepository inseminacaoRepository;
	@Inject
	private EstoqueRepository estoqueRepository;

	@Transacional
	public void salvar(Inseminacao inseminacao, ValidacaoUtil vUtil) {	
		AtualizacaoEstoque ae = new AtualizacaoEstoque();
		ae.setEstoque(inseminacao.getSemen().getEstoque());
		ae.setMotivo("INSEMINAÇÃO");
		ae.setMovimentacaoTipo(MovimentacaoTipo.BAIXA);
		ae.setQtd(inseminacao.getDosagem());

		if(inseminacao.getDosagem() <= 0) {
			vUtil.addMensagem("Dosagem Invalida");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}

		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
			estoqueRepository.guardar(ae);
			inseminacaoRepository.guardar(inseminacao);
		}
	}

}
