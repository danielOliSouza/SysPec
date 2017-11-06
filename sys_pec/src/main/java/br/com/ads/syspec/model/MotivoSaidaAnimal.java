package br.com.ads.syspec.model;

public enum MotivoSaidaAnimal {
	ANIMAL_VENDIDO("Animal Vendido"),
	MORTE("Morte");
	
	private String descricao;
	
	private MotivoSaidaAnimal(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}
