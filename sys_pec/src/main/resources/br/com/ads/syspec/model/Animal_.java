package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.034-0300")
@StaticMetamodel(Animal.class)
public class Animal_ {
	public static volatile SingularAttribute<Animal, Long> id;
	public static volatile SingularAttribute<Animal, String> indentificador;
	public static volatile SingularAttribute<Animal, Date> dtCadastro;
	public static volatile SingularAttribute<Animal, Date> dtNascimento;
	public static volatile SingularAttribute<Animal, String> sexo;
	public static volatile SingularAttribute<Animal, String> descricao;
	public static volatile SingularAttribute<Animal, Raca> raca;
	public static volatile SingularAttribute<Animal, Procedencia> procedencia;
	public static volatile SingularAttribute<Animal, Animal> mae;
	public static volatile SingularAttribute<Animal, Animal> pai;
	public static volatile SingularAttribute<Animal, String> dtEstimadaInicio;
	public static volatile SingularAttribute<Animal, String> dtEstimadaFim;
}
