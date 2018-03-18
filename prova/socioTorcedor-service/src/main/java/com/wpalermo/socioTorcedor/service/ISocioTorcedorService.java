package com.wpalermo.socioTorcedor.service;

import java.util.List;

import com.wpalermo.socioTorcedor.bean.Campanha;
import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;

public interface ISocioTorcedorService {
	
	CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException;

}
