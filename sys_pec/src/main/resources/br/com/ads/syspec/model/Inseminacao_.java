package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.110-0300")
@StaticMetamodel(Inseminacao.class)
public class Inseminacao_ {
	public static volatile SingularAttribute<Inseminacao, Long> id;
	public static volatile SingularAttribute<Inseminacao, Semen> semen;
	public static volatile SingularAttribute<Inseminacao, Animal> animal;
	public static volatile SingularAttribute<Inseminacao, Date> dtInsemincao;
	public static volatile SingularAttribute<Inseminacao, String> obs;
}
