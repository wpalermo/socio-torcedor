package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entidade responsavel pela tabela de time do coracao
 * 
 * tem relacionamento One-to-many com campanhas e One-to-One com socioTorcedor
 * @author william.palermo
 *
 */
@Entity
public class TimeCoracao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idTimeCoracao;
	
	@Column
	private String nomeTimeCoracao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "timeCoracao", cascade = CascadeType.ALL)
	private List<Campanha> campanhasAssociadas;
	
	@OneToOne
	@JsonBackReference
	private SocioTorcedor socioTorcedor;
	
	
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
	public SocioTorcedor getSocioTorcedor() {
		return socioTorcedor;
	}
	public void setSocioTorcedor(SocioTorcedor socioTorcedor) {
		this.socioTorcedor = socioTorcedor;
	}
	
	
	
}
