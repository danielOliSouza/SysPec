package br.com.ads.syspec.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-09-20T14:31:21.111-0300")
@StaticMetamodel(Insumo.class)
public class Insumo_ {
	public static volatile SingularAttribute<Insumo, Long> id;
	public static volatile SingularAttribute<Insumo, String> descricao;
	public static volatile SingularAttribute<Insumo, String> fornecedor;
	public static volatile SingularAttribute<Insumo, Date> dtCadastro;
}
