package com.wpalermo.campanha.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.dao.ICampanhaDAO;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;
import com.wpalermo.campanha.service.ICampanhaService;

@Service
public class CampanhaService implements ICampanhaService {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ICampanhaDAO campanhaDAO;

	@Override
	public void createCampanha(Campanha campanha) throws CampanhaException {

		
		if (!campanhaDAO.getAll().isEmpty()) {
			logger.info("Iniciando verificacao de data de vigencia");
			while (true)
				if (campanhaDAO.getAll().stream()
						.anyMatch(c -> c.getDataFimVigencia().equals(campanha.getDataFimVigencia())))
					campanha.setDataFimVigencia(campanha.getDataFimVigencia().plusDays(1));
				else
					break;
		}

		campanhaDAO.insertCampanha(campanha);
	}

	@Override
	public void deleteCampanha(Integer campanhaId) throws CampanhaException {
		campanhaDAO.deleteCampanha(campanhaId);
	}

	@Override
	public void updateCampanha(Campanha campanha)  throws CampanhaException {
		campanhaDAO.updateCampanha(campanha);
	}

	@Override
	public Campanha readCampanha(Integer campanhaId) throws CampanhaException, DataVigenciaException {
		Campanha c = campanhaDAO.readCampanha(campanhaId);

		
		if(c == null)
			throw new CampanhaException("Campanha nao encontrada - ID: " + campanhaId);
		
		 if(c.getDataFimVigencia().isBefore(LocalDate.now()))
			 throw new DataVigenciaException("Campanha com data vigencia vencida");

		return c;
	}

	@Override
	public List<Campanha> buscaPorTime(Integer idTimeCoracao) throws CampanhaException, DataVigenciaException {
		
		ArrayList<Campanha> todasCampanhas = campanhaDAO.buscaPorTime(idTimeCoracao);
		
		List<Campanha> campanhasPorData = todasCampanhas.stream().filter(camp -> camp.getDataFimVigencia().isAfter(LocalDate.now())).collect(Collectors.toList());
		
		return  campanhasPorData;
	
	}

}
