package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entidade responsavel pela tabela de time do coracao
 * 
 * tem relacionamento One-to-many com campanhas e One-to-One com socioTorcedor
 * @author william.palermo
 *
 */
public class TimeCoracao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
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
