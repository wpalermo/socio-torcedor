package com.wpalermo.socioTorcedor.response;

import java.util.List;

import com.wpalermo.socioTorcedor.entities.Campanha;

public class CadastrarSocioTorcedorResponse {
	
	private String message;
	
	private List<Campanha> campanhas;
	
	private String erro;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
	
	

}
