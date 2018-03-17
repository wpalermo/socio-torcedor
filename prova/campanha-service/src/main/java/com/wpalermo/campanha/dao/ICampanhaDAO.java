package com.wpalermo.campanha.dao;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;

public interface ICampanhaDAO {

	
	void insertCampanha(Campanha campanha) throws CampanhaException;
	
	void deleteCampanha(Integer campanha) throws CampanhaException;
	
	void updateCampanha(Campanha campanha) throws CampanhaException;
	
	Campanha readCampanha(Integer campanhaId) throws CampanhaException;
	
}
