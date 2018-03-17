package com.wpalermo.socioTorcedor.service;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;

public interface ISocioTorcedorService {
	
	void cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException;

}
