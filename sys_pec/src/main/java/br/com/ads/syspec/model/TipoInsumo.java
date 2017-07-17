package br.com.ads.syspec.model;

public enum TipoInsumo {
	REMEDIO("Remedio"),
	SEMEN("Semen"),
	NUTRICAO("Nutrição");
	
	private String descricao;

	TipoInsumo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
