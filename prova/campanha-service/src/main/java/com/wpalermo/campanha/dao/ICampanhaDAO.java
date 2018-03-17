package com.wpalermo.campanha.dao;

import java.util.ArrayList;
import java.util.LinkedList;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;

public interface ICampanhaDAO {

	
	void insertCampanha(Campanha campanha) throws CampanhaException;
	
	void deleteCampanha(Integer campanha) throws CampanhaException;
	
	void updateCampanha(Campanha campanha) throws CampanhaException;
	
	Campanha readCampanha(Integer campanhaId) throws CampanhaException;
	
	LinkedList<Campanha> getAll();

	ArrayList<Campanha> buscaPorTime(Integer idTimeCoracao) throws CampanhaException, DataVigenciaException;
	
}
