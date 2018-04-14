package com.wpalermo.socioTorcedor.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TimeCoracao {
	
	@Id
	private Integer idTimeCoracao;
	
	@Column
	private String nomeTimeCoracao;
	
	@OneToMany
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
