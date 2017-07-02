package br.com.ads.syspec.model;

public enum Procedencia {
	ANIMAL_COMPRADO("Animal Comprado"),
	NASCIMENTO_INSEMINACAO("Animal Nascido Por Inserminação"),
	NASCIMENTO_NATURAL("Animal Nascido Naturalmente");
	
	private String descricao;

	Procedencia(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
