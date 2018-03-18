package com.wpalermo.socioTorcedor.bean;

import java.util.List;

public class TimeCoracao {
	
	private Integer idTimeCoracao;
	private String nomeTimeCoracao;
	private List<Campanha> campanhasAssociadas;
	
	
	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public String getNomeTimeCoracao() {
		return nomeTimeCoracao;
	}
	public void setNomeTimeCoracao(String nomeTimeCoracao) {
		this.nomeTimeCoracao = nomeTimeCoracao;
	}
	public List<Campanha> getCampanhasAssociadas() {
		return campanhasAssociadas;
	}
	public void setCampanhasAssociadas(List<Campanha> campanhasAssociadas) {
		this.campanhasAssociadas = campanhasAssociadas;
	}
	
	
	
}
