package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.MovimentacaoTipo;
import br.com.ads.syspec.model.Remedio;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.repository.RemedioRepository;
import br.com.ads.syspec.util.Transacional;

public class RemedioService implements Serializable {
	@Inject
	private RemedioRepository remedioRepository;
	@Inject
	private EstoqueRepository estoqueRepository;
	
	@Transacional
	public void salvar(Remedio remedio) {
		Float qtd = (float) remedio.getEstoque().getQtdEstoque();
		remedio.getEstoque().setInsumo(remedio);
		remedio = remedioRepository.guardar(remedio);
		
		if(remedio.getEstoque().getAtualizacaoEstoque().isEmpty()) {
			AtualizacaoEstoque ae = new AtualizacaoEstoque();
			ae.setEstoque(remedio.getEstoque());
			ae.setMotivo("ESTOQUE INICIAL");
			ae.setQtd(qtd);
			ae.setMovimentacaoTipo(MovimentacaoTipo.ENTRADA);
			
			estoqueRepository.guardar(ae);
		}
	}
}
