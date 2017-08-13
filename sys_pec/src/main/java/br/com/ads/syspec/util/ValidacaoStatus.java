package br.com.ads.syspec.util;

public enum ValidacaoStatus {
	VALID("Valido"),
	INVALID("Invalido"),
	WARNING("Alertas"),
	ERRO("Erro");
	
	private String descricao;
	
	ValidacaoStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
