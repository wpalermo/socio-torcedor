package com.wpalermo.campanha.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;
import com.wpalermo.campanha.repository.CampanhaRepository;
import com.wpalermo.campanha.service.ICampanhaService;

@Service
public class CampanhaService implements ICampanhaService {

	private Logger logger = Logger.getLogger(this.getClass());
	

	
	private CampanhaRepository campanhaRepository;

	@Override
	public void createCampanha(List<Campanha> campanhas)  {
		logger.debug("Saving " + campanhas.size());
		campanhas.forEach(c -> createCampanha(c));
		
	}
	
	@Override
	public void createCampanha(Campanha campanha) {
		logger.debug("Saving: " + campanha.getNomeCampanha());
		
		while(campanhaRepository.existsByDataFimVigencia(campanha.getDataFimVigencia()))
			campanha.setDataFimVigencia(campanha.getDataFimVigencia().plusDays(1));
		
		campanhaRepository.save(campanha);
	}

	@Override
	public void deleteCampanha(Integer campanhaId) throws CampanhaException {
		logger.debug("Deleting id: " + campanhaId);
		campanhaRepository.deleteById(campanhaId);;
	}

	@Override
	public void updateCampanha(Integer id, Campanha campanha)  throws CampanhaException {
	
	}

	@Override
	public Campanha readCampanha(Integer campanhaId) throws CampanhaException, DataVigenciaException {
		return null;
		
	}

	@Override
	public List<Campanha> getAll() {
		List<Campanha> returnable = new ArrayList<Campanha>();
		campanhaRepository.findAll().forEach(returnable::add);
		return returnable;
	}





}
