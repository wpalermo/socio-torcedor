package com.wpalermo.socioTorcedor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.dao.ISocioTorcedorDAO;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;
import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

@Service
public class SocioTorcedorService implements ISocioTorcedorService{

	
	@Autowired
	private ISocioTorcedorDAO socioTorcedorDAO;
	
	@Override
	public void cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException  {
		
		
		
		try {
			socioTorcedorDAO.cadastrarSocioTorcedor(socioTorcedor);
			
		} catch (PersistenceException e) {
			if(e.getPersistenceEnum().equals(PersistenceDatailEnum.EMAIL_EXISTENTE)) {
				
				SocioTorcedor socioEncontrado = socioTorcedorDAO.buscarSocioTorcedor(socioTorcedor.getEmail());
				
				
			}
			throw new SocioTorcedorException();
		}
	}

}
