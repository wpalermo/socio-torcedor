package com.wpalermo.campanha.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entidade responsavel pela tabela de campanhas
 * @author william.palermo
 *
 */

public class Campanha {
	
	@Id
	private Integer idCampanha;
	
	private String nomeCampanha;
	
	private Integer idTimeCoracao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataInicioVigencia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataFimVigencia;
	
	
	public Campanha() {
		
	}

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
	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}
	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}


	
	

}
