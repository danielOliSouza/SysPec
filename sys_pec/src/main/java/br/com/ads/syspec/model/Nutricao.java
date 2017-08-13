package br.com.ads.syspec.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="nutricao")
public class Nutricao extends Insumo{
	
}
