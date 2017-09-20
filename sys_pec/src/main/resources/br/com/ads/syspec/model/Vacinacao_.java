package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.123-0300")
@StaticMetamodel(Vacinacao.class)
public class Vacinacao_ {
	public static volatile SingularAttribute<Vacinacao, Long> id;
	public static volatile SingularAttribute<Vacinacao, Date> dtCadastro;
	public static volatile SingularAttribute<Vacinacao, Date> dtAplicao;
	public static volatile SingularAttribute<Vacinacao, String> tipo;
	public static volatile SingularAttribute<Vacinacao, Remedio> remedio;
	public static volatile SingularAttribute<Vacinacao, String> campanha;
	public static volatile ListAttribute<Vacinacao, AplicacaoRemedio> aplicacaoRemedios;
}
