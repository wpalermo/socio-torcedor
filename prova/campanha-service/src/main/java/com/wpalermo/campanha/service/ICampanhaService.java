package com.wpalermo.campanha.service;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;

public interface ICampanhaService {
	
	void createCampanha(Campanha campanha) throws CampanhaException;
	void deleteCampanha(Integer campanha) throws CampanhaException;
	void updateCampanha(Campanha campanha) throws CampanhaException;
	Campanha readCampanha(Integer campanhaId) throws CampanhaException, DataVigenciaException;
	

}
