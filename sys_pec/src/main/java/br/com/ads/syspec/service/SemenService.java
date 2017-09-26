package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.MovimentacaoTipo;
import br.com.ads.syspec.model.Semen;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.repository.SemenRepository;
import br.com.ads.syspec.util.Transacional;

public class SemenService implements Serializable{
	@Inject
	private SemenRepository semenRepository;
	@Inject
	private EstoqueRepository estoqueRepository;
	@Transacional
	public void salvar(Semen semen) {
		Float qtd = (float) semen.getEstoque().getQtdEstoque();
		semen.getEstoque().setInsumo(semen);
		semen = semenRepository.guardar(semen);

		if(semen.getEstoque().getAtualizacaoEstoque().isEmpty()) {
			AtualizacaoEstoque ae = new AtualizacaoEstoque();
			ae.setEstoque(semen.getEstoque());
			ae.setMotivo("ESTOQUE INICIAL");
			ae.setQtd(qtd);
			ae.setMovimentacaoTipo(MovimentacaoTipo.ENTRADA);
			estoqueRepository.guardar(ae);
		}
	}

}
