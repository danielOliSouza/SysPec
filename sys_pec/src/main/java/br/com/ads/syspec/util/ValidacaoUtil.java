package br.com.ads.syspec.util;

import java.io.Serializable;

public class ValidacaoUtil implements Serializable{
	private ValidacaoStatus validacaoStatus = ValidacaoStatus.VALID;
	private StringBuilder mensagem = new StringBuilder();
	
	
	public ValidacaoStatus getValidacaoStatus() {
		return validacaoStatus;
	}
	public void setValidacaoStatus(ValidacaoStatus validacaoStatus) {
		this.validacaoStatus = validacaoStatus;
	}
	public StringBuilder getMensagem() {
		return mensagem;
	}
	
	public String getMensagemToString(){
		return mensagem.toString();
	}
	
	public void setMensagem(StringBuilder mensagem) {
		this.mensagem = mensagem;
	}
	
	public void addMensagem(String msg){
		mensagem.append(msg + "\n ");
	}
}
