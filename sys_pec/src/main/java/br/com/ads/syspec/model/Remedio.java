package br.com.ads.syspec.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="remedio")
public class Remedio extends Insumo{
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
}
