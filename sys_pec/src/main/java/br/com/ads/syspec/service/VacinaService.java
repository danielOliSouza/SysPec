package br.com.ads.syspec.service;

import java.io.Serializable;

import javax.inject.Inject;import org.omg.PortableInterceptor.ORBInitInfoPackage.InvalidNameHelper;

import br.com.ads.syspec.model.AplicacaoRemedio;
import br.com.ads.syspec.model.Vacinacao;
import br.com.ads.syspec.repository.VacinacaoRepository;
import br.com.ads.syspec.util.Transacional;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

public class VacinaService implements Serializable{
	@Inject
	private VacinacaoRepository vacinacaoRepository;
	
	
	public boolean salvar (Vacinacao vacinacao, ValidacaoUtil vUtil){
		Boolean result = true;
		
		vUtil.setValidacaoStatus(ValidacaoStatus.VALID);
		
		if(vacinacao.getAplicacaoRemedios().isEmpty()){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Sem aplicações cadastradas");
		}
		if(vacinacao.getDtAplicao() == null){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Sem data de aplicação registrada");
		}
		if(vacinacao.getRemedio() == null){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Sem remedio registrado");
		}
		
		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID){
			vacinacaoRepository.guardar(vacinacao);
			vUtil.setValidacaoStatus(ValidacaoStatus.VALID);
			vUtil.addMensagem("Cadastrado com Sucesso");
		}
		else{
			result = false;
		}
		
		return result;
	}

	public boolean addAplicacaoRemedio(AplicacaoRemedio novaAplicacao, Vacinacao vacinacao, ValidacaoUtil vUtil) {
		boolean result = true;
		
		if(novaAplicacao.getAnimal() == null){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Sem animal inserido");
		}
		if(novaAplicacao.getQtdDose() <= 0){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Dose infomada invalida");
		}
		
		int count = (int) vacinacao.getAplicacaoRemedios()
			.stream()
			.filter(p -> p.getAnimal().getId() == novaAplicacao.getAnimal().getId()).count();
			
		if(count > 0){
			vUtil.setValidacaoStatus(ValidacaoStatus.INVALID);
			vUtil.addMensagem("Animal já INSERIDO");
		}
		
		if(vUtil.getValidacaoStatus() != ValidacaoStatus.INVALID 
				&& vUtil.getValidacaoStatus() != ValidacaoStatus.ERRO){
			vacinacao.addAplicacaoRemedios(novaAplicacao);
			vUtil.setValidacaoStatus(ValidacaoStatus.VALID);
			vUtil.addMensagem("Inserido com Sucesso");
		}
		else
			result = false;
		
		return result;
	}
}
