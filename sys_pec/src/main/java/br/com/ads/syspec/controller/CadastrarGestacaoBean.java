package br.com.ads.syspec.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.ads.syspec.model.Animal;
import br.com.ads.syspec.model.Gestacao;
import br.com.ads.syspec.model.Inseminacao;
import br.com.ads.syspec.model.Procedencia;
import br.com.ads.syspec.repository.AnimalRepository;
import br.com.ads.syspec.repository.InseminacaoRepository;
import br.com.ads.syspec.service.AnimalService;
import br.com.ads.syspec.service.GestacaoService;
import br.com.ads.syspec.util.FacesMessages;
import br.com.ads.syspec.util.ValidacaoStatus;
import br.com.ads.syspec.util.ValidacaoUtil;

@Named
@ViewScoped
public class CadastrarGestacaoBean implements Serializable{
	private List<Animal> animalsFemeas = new ArrayList<>();
	private List<Animal> animalsMachos = new ArrayList<>();
	private Gestacao gestacao = new Gestacao();
	@Inject
	private AnimalRepository animalRepository;
	@Inject
	private InseminacaoRepository inseminacaoRepository;
	@Inject
	private GestacaoService gestacaoService;
	@Inject
	private FacesMessages msgs;


	public void initialize() {



		try {
			Map<String, String> params =FacesContext.getCurrentInstance().
					getExternalContext().getRequestParameterMap();
			String parameterOne = params.get("idinsem");

			if(!parameterOne.isEmpty()) {
				Long id = new Long (Integer.valueOf(parameterOne));
				Inseminacao insem = inseminacaoRepository.findById(id);
				insem.setGestacao(true);
				gestacao.setAnimal(insem.getAnimal());
				gestacao.setProcedencia(Procedencia.NASCIMENTO_INSEMINACAO);
				gestacao.setInseminacao(insem);
			}
		}catch(Exception e) {}


		animalsMachos = animalRepository.findPorSexo("M");

		animalsFemeas = animalRepository.findPorSexo("F");
	}

	public String salvar() {
		String loadPage = null;
		boolean redirect = gestacao.getPartoSucesso();
		ValidacaoUtil vUtil = new ValidacaoUtil();
		
		gestacaoService.salvar(gestacao, vUtil);

		if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID){
			if(redirect)
				loadPage = "/Animal/CadastroNovoAnimalIndividual.xhtml?faces-redirect=true&idGestacao=" + gestacao.getId();
			msgs.info(vUtil.getMensagemToString());
		}
		else
			msgs.error(vUtil.getMensagemToString());
		
		return loadPage;
	}

	public List<Animal> getAnimalsFemeas() {
		return animalsFemeas;
	}

	public void setAnimalsFemeas(List<Animal> animals) {
		this.animalsFemeas = animals;
	}

	public Gestacao getGestacao() {
		return gestacao;
	}

	public void setGestacao(Gestacao gestacao) {
		this.gestacao = gestacao;
	}

	public String getPaiORInseminacao() {
		String response = "";
		if(gestacao.getProcedencia() == Procedencia.NASCIMENTO_INSEMINACAO) {
			if(gestacao.getInseminacao() != null)
				response = String.valueOf(gestacao.getInseminacao().getId());
		}
		else if(gestacao.getProcedencia() == Procedencia.NASCIMENTO_NATURAL)
			if(gestacao.getPai() != null)
				response = String.valueOf(gestacao.getPai().getIndentificador());

		return response;
	}
	public void setPaiORInseminacao(String value) {

	}

	public int getOrdinalTipoGestacao() {
		if(gestacao.getProcedencia() != null)
			return gestacao.getProcedencia().ordinal() ;
		else
			return 0;
	}

	public void setOrdinalTipoGestacao(int ordinal) {
		Procedencia p = null;
		switch(ordinal) {
		case 0: p = Procedencia.ANIMAL_COMPRADO; break;
		case 1: p = Procedencia.NASCIMENTO_INSEMINACAO; break;
		case 2: p = Procedencia.NASCIMENTO_NATURAL; break;
		}
		gestacao.setProcedencia(p);
	}

	public List<Animal> getAnimalsMachos() {
		return animalsMachos;
	}

	public void setAnimalsMachos(List<Animal> animalsMachos) {
		this.animalsMachos = animalsMachos;
	}

	public void inserePai(SelectEvent event) {
		Animal pai = (Animal) event.getObject();
		gestacao.setPai(pai);
	}

	public void insereInseminacao(SelectEvent event) {
		Inseminacao in = (Inseminacao) event.getObject();
		gestacao.setInseminacao(in);	
	}
	public List<Inseminacao> getInseminacaoPorAnimal() {
		System.out.println(inseminacaoRepository.findPorAnimal(gestacao.getAnimal().getId()).size());
		return inseminacaoRepository.findPorAnimal(gestacao.getAnimal().getId());
	}

	public void openCadastroAnimal() throws IOException{
		ValidacaoUtil vUtil = new ValidacaoUtil();

		if(gestacao.getPartoSucesso()){
			gestacaoService.verificaRedirecionamento(gestacao, vUtil);

			if(vUtil.getValidacaoStatus() == ValidacaoStatus.VALID){
				//É necessario para requisições ajax para redirecionar para uma pagina
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect(ec.getRequestContextPath() 
						+ "/Animal/CadastroNovoAnimalIndividual.xhtml?faces-redirect=true&idGestacao="+gestacao.getId());
			}
			else if(vUtil.getValidacaoStatus() == ValidacaoStatus.INVALID)
				msgs.info(vUtil.getMensagemToString());
			else
				msgs.error(vUtil.getMensagemToString());
		}
	}
}
