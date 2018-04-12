package com.wpalermo.campanha.service;

import java.util.List;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;

public interface ICampanhaService {
	
	
	/**
	 * Cadastra uma nova campanha
	 * @param campanha
	 * @throws CampanhaException
	 */
	void createCampanha(Campanha campanha) throws CampanhaException;
	
	/**
	 * delete uma campanha pelo seu ID
	 * @param campanha
	 * @throws CampanhaException
	 */
	void deleteCampanha(Integer campanha) throws CampanhaException;
	
	/**
	 * Atualiza os dados de uma campanha
	 * @param campanha
	 * @throws CampanhaException
	 */
	void updateCampanha(Integer id, Campanha campanha) throws CampanhaException;
	
	/**
	 * Busca uma campanha cadastrada pelo seu ID
	 * @param campanhaId
	 * @return
	 * @throws CampanhaException
	 * @throws DataVigenciaException
	 */
	Campanha readCampanha(Integer campanhaId) throws CampanhaException, DataVigenciaException;
	
	/**
	 * Busca uma campanha pelo ID do time do coracao
	 * @param idTimeCoracao
	 * @return
	 * @throws CampanhaException
	 * @throws DataVigenciaException
	 */
	List<Campanha> getAll();
	

}
