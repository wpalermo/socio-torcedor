package com.wpalermo.socioTorcedor.dao;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;

public interface ISocioTorcedorDAO {
	
	void cadastrarSocioTorcedor(SocioTorcedor socio) throws PersistenceException;
	
	SocioTorcedor buscarSocioTorcedor(String email) throws PersistenceException;
	
	void updateSocioTorcedor(SocioTorcedor socio) throws PersistenceException;

}
