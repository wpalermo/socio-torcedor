package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


/**
 * Entidade responsavel pela tabela de socio torcedor
 * 
 * tem relacionamento One-to-One com timeCoracao
 * @author william.palermo
 *
 */
public class SocioTorcedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;	
	
	private String nome;
	
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
