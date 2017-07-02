package br.com.ads.syspec.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.util.Transacional;

public class AnimalService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AnimalRepository animalRepository;
	
	@Transacional
	public void salvar(Animal animal, Animal mae, Animal pai, boolean isDataEstimada, String txtDtEstimada) throws Exception {
		validarAnimal(animal, mae, pai);
		if(isDataEstimada)
			animal = textoDataParaObjData(txtDtEstimada, animal);
		else{
			animal.setDtEstimadaFim(null);
			animal.setDtEstimadaInicio(null);
		}
		animalRepository.guardar(animal);
	}
	
	public void validarAnimal(Animal animal, Animal mae, Animal pai) throws Exception{
		if(animal.getProcedencia() == Procedencia.NASCIMENTO_NATURAL){
			mae = validaProgenitor(mae, false);
			pai = validaProgenitor(pai, true);
		}
		else
			if(animal.getProcedencia() == Procedencia.NASCIMENTO_INSEMINACAO){
				mae = validaProgenitor(mae, false);
				pai = null;
			}
			else{
				mae = null;
				pai = null;
			}
		animal.setMae(mae);
		animal.setPai(pai);
	}
	
	public Animal validaProgenitor(Animal progenitor, boolean isMacho) throws Exception{
		String progenitorNome = (isMacho) ? "Pai" : "Mãe";
		String progenitoSexo = (isMacho) ? "M" : "F";
		
		if(progenitor == null)
			throw new Exception(progenitorNome + " deve ser informado");
		if(progenitor.getIndentificador() == null)
			throw new Exception(progenitorNome + " deve ser informado");
		if(progenitor.getIndentificador().isEmpty())
			throw new Exception(progenitorNome + " deve ser informado");
		if(progenitor.getId() == 0){
			progenitor = animalRepository.findPorIndentificador(progenitor.getIndentificador());
			if(progenitor == null)
				throw new Exception(progenitorNome + " : invalido(a)");
			if(!progenitor.getSexo().equals(progenitoSexo))
				throw new Exception(progenitorNome + " : invalido(a)");
		}
		return progenitor;
	}

	public Animal textoDataParaObjData(String txtData, Animal animal) throws Exception {
		String[] datas, dataInicio, dataFim;
		int mesInicio, anoInicio, mesFim, anoFim;
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		try{	
			datas = txtData.split(" à ");
			dataInicio = datas[0].split("/");
			dataFim = datas[1].split("/");
			
			mesInicio = Integer.valueOf(dataInicio[0]);
			anoInicio = Integer.valueOf(dataInicio[1]);
			
			mesFim = Integer.valueOf(dataFim[0]);
			anoFim = Integer.valueOf(dataFim[1]);
		}catch (Exception e) {
			System.out.println(e.getMessage() + " - " + txtData);
			throw new Exception("Não foi possivel Converter Data de Nascimento Estimada");
		}
		
		if(mesInicio > 12 || mesFim > 12)
			throw new Exception("Data de Nascimento Estimado : Mês invalido");
		
		if(anoFim > c.get(Calendar.YEAR) || anoInicio > c.get(Calendar.YEAR))
			throw new Exception("Data de Nascimento Estimado : Ano invalido");
		
		if(anoInicio > anoFim)
			throw new Exception("Data de Nacimento 'Inicial' Não Pode Ser Maior que a 'Final'");
		
		if(anoInicio == anoFim){
			if(mesInicio > mesFim)
				throw new Exception("Data de Nacimento 'Inicial' Não Pode Ser Maior que a 'Final'");
		}
		
			animal.setDtNascimento(null);
			
			animal.setDtEstimadaInicio(datas[0]);
			animal.setDtEstimadaFim(datas[1]);
			
			
		return animal;
	}
}
