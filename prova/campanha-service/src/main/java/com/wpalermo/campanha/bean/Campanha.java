package com.wpalermo.campanha.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Campanha {
	
	private Integer idCampanha;
	private String nomeCampanha;
	private Integer idTimeCoracao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInicioVigencia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataFimVigencia;
	
	
	
	

	public Integer getIdCampanha() {
		return idCampanha;
	}
	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}
	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public String getNomeCampanha() {
		return nomeCampanha;
	}
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}
	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	
	

}
