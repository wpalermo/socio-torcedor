package com.wpalermo.campanha.request;

import java.util.List;

import com.wpalermo.campanha.entities.Campanha;

/**
 * Encapsula o request de uma campanha
 * @author william.palermo
 *
 */
public class CampanhaRequest {
	
	
	private Campanha campanha;
	private List<Campanha> campanhas;

	public Campanha getCampanha() {
		return campanha;
	}
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}


	
	

}
