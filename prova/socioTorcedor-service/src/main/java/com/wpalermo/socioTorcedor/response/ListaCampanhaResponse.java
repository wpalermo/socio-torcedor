package com.wpalermo.socioTorcedor.response;

import java.io.Serializable;
import java.util.List;

import com.wpalermo.socioTorcedor.bean.Campanha;

public class ListaCampanhaResponse implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private List<Campanha> campanhas;
	private String message;
	private String erro;
	
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
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
