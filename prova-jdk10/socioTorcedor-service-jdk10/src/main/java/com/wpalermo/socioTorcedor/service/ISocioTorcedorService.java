package com.wpalermo.socioTorcedor.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;

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
	
	
	void atualizarCampanhas(SocioTorcedor socio, ResponseEntity<ArrayList<Campanha>> reponse);


}
