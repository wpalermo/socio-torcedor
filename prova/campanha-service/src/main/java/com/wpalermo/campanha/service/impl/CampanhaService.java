package com.wpalermo.campanha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.dao.ICampanhaDAO;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.service.ICampanhaService;

@Service
public class CampanhaService implements ICampanhaService {

	@Autowired
	private ICampanhaDAO campanhaDAO;

	@Override
	public void createCampanha(Campanha campanha) throws CampanhaException {
		campanhaDAO.insertCampanha(campanha);
	}

	@Override
	public void deleteCampanha(Integer campanhaId) throws CampanhaException {
		campanhaDAO.deleteCampanha(campanhaId);
	}

	@Override
	public void updateCampanha(Campanha campanha) throws CampanhaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Campanha readCampanha(Integer campanhaId) throws CampanhaException {
		return campanhaDAO.readCampanha(campanhaId);
	}

}
