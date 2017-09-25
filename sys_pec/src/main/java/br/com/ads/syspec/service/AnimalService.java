package br.com.ads.syspec.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.hibernate.annotations.PolymorphismType;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.util.DateUtil;
import br.com.ads.syspec.util.Transacional;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

public class AnimalService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AnimalRepository animalRepository;

	@Transacional
	public void salvar(Animal animal, Date dtInicio, Date dtFim, boolean dtEstimada, ValidacaoUtil vUtil) {
		if(dtEstimada){
			if(dtInicio == null || dtFim == null){
				vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
				vUtil.addMensagem("Informe a Data Corretamente");
			}
			else{
				if(dtInicio.getTime() > dtFim.getTime()){
					vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
					vUtil.addMensagem("Informe a Data Corretamente : Data de Inicio Não Pode ser Maior que Fim");
				}
				else{
					Date dt = new Date();
					dt.setTime((dtInicio.getTime() + dtFim.getTime()) / 2);
					animal.setDtNascimento(dt);
					
					System.out.println(dt);
					
					//Dias de margen estimada
					/*double milisegundos =  (double) (dt.getTime() - dtFim.getTime());
					double segundos = milisegundos / (double) 1000;
					double minutos = segundos / (double) 60;
					double horas = minutos / (double) 60;
					
					System.out.println(horas);
					
					double dias = horas / (double) 24;
					
					System.out.println(dias);
					*/
					
					double dias = DateUtil.interval(dtInicio, dtFim).dias();
					
					if(dias < 0)
						dias *= -1D;// Caso valor dado for negativo aqui ele o deixa positivo
					
					System.out.println(dias);
					

				}
			}
		}
		
		if(animal.getIndentificador() == null){
			vUtil.addMensagem("Indentificador não pode ser em branco");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}

		if(animal.getDtNascimento() == null){
			vUtil.addMensagem("Dt. Nascimento não pode ser em branco");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}

		if(animal.getRaca() == null){
			vUtil.addMensagem("Raça não pode ser em branco");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}

		if(animal.getSexo() == null){
			vUtil.addMensagem("Sexo não pode ser em branco");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}

		if(animal.getGestacao() == null){
			vUtil.addMensagem("Erro Interno - Gestação Não Criada");
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
		}
		else{
			if(animal.getGestacao().getInseminacao() != null){
				Inseminacao inseminacao = animal.getGestacao().getInseminacao();
				animal.getGestacao().setAnimal(inseminacao.getAnimal());
				inseminacao.setGestacao(true);
			}

			animal.getGestacao().setPartoSucesso(true);
		}

		if(animal.getGestacao().getProcedencia() == Procedencia.ANIMAL_COMPRADO){
			animal.getGestacao().setAnimal(null);
			animal.getGestacao().setDtInicioGestacao(null);
			animal.getGestacao().setInseminacao(null);
		}
		else
			if(animal.getGestacao().getProcedencia() == Procedencia.NASCIMENTO_INSEMINACAO){
				animal.getGestacao().setPai(null);
				if(animal.getGestacao().getInseminacao() == null){
					vUtil.addMensagem("Selecione Inseminacao");
					vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
				}
			}
			else
				if(animal.getGestacao().getProcedencia() == Procedencia.NASCIMENTO_NATURAL){
					animal.getGestacao().setInseminacao(null);
					if(animal.getGestacao().getAnimal() == null){
						vUtil.addMensagem("Selecione a Mãe do Animal");
						vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
					}
				}
				else{
					vUtil.addMensagem("Selecione a Procedencia do Animal");
					vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
				}



		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID){
			animalRepository.guardar(animal);
			vUtil.addMensagem("Salvo Com Sucesso");
		}

	}

}
