package com.wpalermo.socioTorcedor.dao.impl;

import org.springframework.stereotype.Repository;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.dao.ISocioTorcedorDAO;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.persistence.SocioPersistence;


@Repository
public class SocioTorcedorDAO implements ISocioTorcedorDAO{

	@Override
	public void cadastrarSocioTorcedor(SocioTorcedor socio) throws PersistenceException {
		SocioPersistence.getInstance();
		SocioPersistence.insertSocio(socio);
	}

	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) throws PersistenceException {
		SocioPersistence.getInstance();
		return SocioPersistence.readSocio(email);
	}

}
