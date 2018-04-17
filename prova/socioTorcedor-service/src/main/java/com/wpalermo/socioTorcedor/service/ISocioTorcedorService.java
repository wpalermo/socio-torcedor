package com.wpalermo.socioTorcedor.service;

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
	CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor);

	/**
	 * Busca um socio torcedor pelo seu email
	 * @param email
	 * @return
	 * @throws PersistenceException 
	 */
	SocioTorcedor buscarSocioTorcedor(String email);

}
