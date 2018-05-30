package com.wpalermo.socioTorcedor.resources.fallback;

import java.util.List;

import org.jboss.logging.Logger;

import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.resources.CampanhaResource;

public class CampanhaResourceFallback implements CampanhaResource {

	
	private Logger LOGGER = Logger.getLogger(this.getClass());
	
	@Override
	public List<Campanha> get() {
		
		LOGGER.error("PROBLEMA AO ACESSAR CAMPANHA-SERVICE");
		
		return null;
	}

}
