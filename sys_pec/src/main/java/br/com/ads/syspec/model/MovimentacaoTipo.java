package br.com.ads.syspec.model;

public enum MovimentacaoTipo {
	BAIXA("Baixa"),
	ENTRADA("Entrada");
	
	private String descricao;
	
	private MovimentacaoTipo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
