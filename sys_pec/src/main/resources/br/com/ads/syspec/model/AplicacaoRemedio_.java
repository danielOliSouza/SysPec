package br.com.ads.syspec.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.104-0300")
@StaticMetamodel(AplicacaoRemedio.class)
public class AplicacaoRemedio_ {
	public static volatile SingularAttribute<AplicacaoRemedio, Long> id;
	public static volatile SingularAttribute<AplicacaoRemedio, String> obs;
	public static volatile SingularAttribute<AplicacaoRemedio, Integer> qtdDose;
	public static volatile SingularAttribute<AplicacaoRemedio, String> campanha;
	public static volatile SingularAttribute<AplicacaoRemedio, Animal> animal;
	public static volatile SingularAttribute<AplicacaoRemedio, Insumo> remedio;
	public static volatile SingularAttribute<AplicacaoRemedio, Vacinacao> vacinacao;
}
