package com.wpalermo.socioTorcedor.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;

public interface ISocioTorcedorService {
	
	/**
	 * Cadastra um socio torcedor
	 * @param socioTorcedor
	 * @return
	 * @throws SocioTorcedorException
	 * @throws PersistenceException
	 */
	SocioTorcedor cadastrarSocioTorcedor(SocioTorcedor socioTorcedor);

	/**
	 * Busca um socio torcedor pelo seu email
	 * @param email
	 * @return
	 * @throws PersistenceException 
	 */
	SocioTorcedor buscarSocioTorcedor(String email);
	
	
	void atualizarCampanhas(SocioTorcedor socio, ResponseEntity<ListaCampanhaResponse> reponse);


}
