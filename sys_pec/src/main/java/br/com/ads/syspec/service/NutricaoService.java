package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.model.MovimentacaoTipo;
import br.com.ads.syspec.model.Nutricao;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.repository.NutricaoRepository;
import br.com.ads.syspec.util.Transacional;

public class NutricaoService implements Serializable{
	@Inject
	private NutricaoRepository nutricaoRepository;
	@Inject
	private EstoqueRepository estoqueRepository;

	@Transacional
	public void salvar(Nutricao nutricao) {
		Float qtd = (float) nutricao.getEstoque().getQtdEstoque();
		nutricao.getEstoque().setInsumo(nutricao);

		nutricao = nutricaoRepository.guardar(nutricao);
		
		if(nutricao.getEstoque().getAtualizacaoEstoque().isEmpty()) {
			AtualizacaoEstoque ae = new AtualizacaoEstoque();
			ae.setEstoque(nutricao.getEstoque());
			ae.setMotivo("ESTOQUE INICIAL");
			ae.setQtd(qtd);
			ae.setMovimentacaoTipo(MovimentacaoTipo.ENTRADA);
			
			estoqueRepository.guardar(ae);
		}
	}

}
