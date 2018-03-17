package com.wpalermo.campanha.response;

import com.wpalermo.campanha.bean.Campanha;

public class CampanhaResponse {
	
	private Campanha campanha;
	private String message;
	private String erro;
	
	public CampanhaResponse() {
		
	}
	
	public CampanhaResponse(Campanha campanha, String message) {
		this.campanha = campanha;
		this.message = message;
	}

	public Campanha getCampanha() {
		return campanha;
	}
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}



	
	
}
