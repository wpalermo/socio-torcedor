package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Campanha implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idCampanha;
	
	@Column
	private String nomeCampanha;
	
	@JsonBackReference
	@ManyToOne
	private TimeCoracao timeCoracao;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataInicioVigencia;
	
	@Column
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

	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}




	
	

}
