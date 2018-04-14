package com.wpalermo.socioTorcedor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocioTorcedor {

	@Id
	private String email;
	
	@Column
	private String nome;
	
	@Column
	private TimeCoracao timeCoracao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}
	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}
	
	
	
	
}
