package com.wpalermo.campanha.dao.impl;

import org.springframework.stereotype.Repository;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.dao.ICampanhaDAO;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.persistence.CampanhaPersistence;

@Repository
public class CampanhaDAO implements ICampanhaDAO{

	@Override
	public void insertCampanha(Campanha campanha) throws CampanhaException {
		CampanhaPersistence.getInstance();
		
		CampanhaPersistence.addCampanha(campanha);
	}

	@Override
	public void deleteCampanha(Integer campanhaId) throws CampanhaException {
		CampanhaPersistence.getInstance();
		
		CampanhaPersistence.deleteCampanha(campanhaId);		
	}

	@Override
	public void updateCampanha(Campanha campanha) throws CampanhaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Campanha readCampanha(Integer campanhaId) throws CampanhaException {
		CampanhaPersistence.getInstance();
		
		return CampanhaPersistence.readCampanha(campanhaId);	
	}

}
