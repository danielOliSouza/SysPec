package br.com.ads.syspec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sound.midi.MidiDevice.Info;

import br.com.ads.syspec.model.AtualizacaoEstoque;
import br.com.ads.syspec.model.Estoque;
import br.com.ads.syspec.model.MovimentacaoTipo;
import br.com.ads.syspec.repository.EstoqueRepository;
import br.com.ads.syspec.service.EstoqueService;
import br.com.ads.syspec.util.FacesMessages;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

@Named
@ViewScoped
public class EstoqueBean implements Serializable{
	@Inject 
	private EstoqueRepository estoqueRepository;
	@Inject
	private EstoqueService estoqueService;
	@Inject
	private FacesMessages messages;
	
	private List<Estoque> estoques = new ArrayList<>();
 	private Estoque estoqueSelecionado;
	private List<AtualizacaoEstoque> atualizacaoEstoques = new ArrayList<>();
	private AtualizacaoEstoque atualizacaoEstoque = new AtualizacaoEstoque();

	
	public void initialize(){
		estoques = estoqueRepository.findAll();
	}

	
	public void atualizarEstoque() {
		ValidacaoUtil vUtil = new ValidacaoUtil();
		estoqueService.salvar(atualizacaoEstoque, estoqueSelecionado, vUtil);
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID) {
			messages.info(vUtil.getMensagemToString());
			estoques = estoqueRepository.findAll();
			atualizacaoEstoque = new AtualizacaoEstoque();
		}
		else
			messages.error(vUtil.getMensagemToString());
	}
	
	
	
	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque getEstoqueSelecionado() {
		return estoqueSelecionado;
	}

	public void setEstoqueSelecionado(Estoque estoqueSelecionado) {
		this.estoqueSelecionado = estoqueSelecionado;
		if(estoqueSelecionado != null){
			atualizacaoEstoques = estoqueRepository.findAtualizacaoByEstoque(estoqueSelecionado);
		}
	}

	public List<AtualizacaoEstoque> getAtualizacaoEstoques() {
		return atualizacaoEstoques;
	}

	public AtualizacaoEstoque getAtualizacaoEstoque() {
		return atualizacaoEstoque;
	}

	public void setAtualizacaoEstoque(AtualizacaoEstoque atualizacaoEstoque) {
		this.atualizacaoEstoque = atualizacaoEstoque;
	}
	
	public void setTipoMovimentacaoByOrdinal(int ordinal){
		switch (ordinal) {
		case 0:
			atualizacaoEstoque.setMovimentacaoTipo(MovimentacaoTipo.BAIXA);
			break;
		case 1:
			atualizacaoEstoque.setMovimentacaoTipo(MovimentacaoTipo.ENTRADA);
			break;
		}
	}
}
