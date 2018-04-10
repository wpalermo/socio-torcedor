package com.wpalermo.campanha.dao;

import java.util.ArrayList;
import java.util.LinkedList;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;

public interface ICampanhaDAO {

	/**
	 * Insere uma nova campanha no banco de dados
	 * @param campanha
	 * @throws CampanhaException
	 */
	void insertCampanha(Campanha campanha) throws CampanhaException;
	
	
	/**
	 * Deleta uma campanha a partir do seu ID. 
	 * @param campanha
	 * @throws CampanhaException
	 */
	void deleteCampanha(Integer campanha) throws CampanhaException;
	
	
	/**
	 * Atualiza uma campanha
	 * @param campanha
	 * @throws CampanhaException
	 */
	void updateCampanha(Campanha campanha) throws CampanhaException;
	
	
	/**
	 * Busca uma campanha atraves do ID
	 * @param campanhaId
	 * @return
	 * @throws CampanhaException
	 */
	Campanha readCampanha(Integer campanhaId) throws CampanhaException;
	
	/**
	 * Busca todas as campanhas cadastradas
	 * @return
	 */
	LinkedList<Campanha> getAll();

	
	/**
	 * Busca uma campanha pelo ID do time do coracao
	 * @param idTimeCoracao
	 * @return
	 * @throws CampanhaException
	 * @throws DataVigenciaException
	 */
	ArrayList<Campanha> buscaPorTime(Integer idTimeCoracao) throws CampanhaException, DataVigenciaException;


	Campanha readCampanhaMongo(Integer id);
	
	void insertCampanhaMongo(Campanha campanha);
	
}
