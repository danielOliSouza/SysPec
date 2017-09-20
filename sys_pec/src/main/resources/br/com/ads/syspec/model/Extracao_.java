package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.106-0300")
@StaticMetamodel(Extracao.class)
public class Extracao_ {
	public static volatile SingularAttribute<Extracao, Long> id;
	public static volatile SingularAttribute<Extracao, Date> dtCadastro;
	public static volatile SingularAttribute<Extracao, Date> dtExtracaoInicio;
	public static volatile SingularAttribute<Extracao, Date> dtExtracaoFim;
	public static volatile ListAttribute<Extracao, Ordenha> ordenhas;
	public static volatile SingularAttribute<Extracao, String> obs;
}
