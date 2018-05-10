package com.wpalermo.socioTorcedor.service;

import java.util.List;

import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;

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
	
	
	void atualizarCampanhas(SocioTorcedor socio);


}
