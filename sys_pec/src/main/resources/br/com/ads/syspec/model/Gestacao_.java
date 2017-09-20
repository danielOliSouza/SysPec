package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.108-0300")
@StaticMetamodel(Gestacao.class)
public class Gestacao_ {
	public static volatile SingularAttribute<Gestacao, Long> id;
	public static volatile SingularAttribute<Gestacao, Date> dtInicioGestacao;
	public static volatile SingularAttribute<Gestacao, Date> dtParto;
	public static volatile SingularAttribute<Gestacao, String> obs;
	public static volatile SingularAttribute<Gestacao, Procedencia> procedencia;
	public static volatile SingularAttribute<Gestacao, Inseminacao> inseminacao;
}
