package com.wpalermo.socioTorcedor.dao;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;

public interface ISocioTorcedorDAO {
	
	/**
	 * Cadastra um novo socio torcedor na base
	 * @param socio
	 * @throws PersistenceException
	 */
	void cadastrarSocioTorcedor(SocioTorcedor socio) throws PersistenceException;
	
	/**
	 * Busca um socio torcedor pelo seu email
	 * @param email
	 * @return
	 * @throws PersistenceException
	 */
	SocioTorcedor buscarSocioTorcedor(String email) throws PersistenceException;
	
	
	/**
	 * Faz o update do cadastro de um socio torcedor
	 * @param socio
	 * @throws PersistenceException
	 */
	void updateSocioTorcedor(SocioTorcedor socio) throws PersistenceException;

}
