package com.wpalermo.socioTorcedor.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	 private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;

	@Autowired
	private ICampanhaHttpRequest campanhaHttpRequest;



	@Override
	public CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {
		
		logger.info("Cadastrando socio torcedor");

		if (socioTorcedorRepository.existsById(socioTorcedor.getEmail())) {
			campanhaHttpRequest.callBack(socioTorcedor);
		} else {
			socioTorcedorRepository.save(socioTorcedor);
			campanhaHttpRequest.callBack(socioTorcedor);
		}
		return null;
	}

	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) {
		return socioTorcedorRepository.findById(email).get();
	}

	public void atualizarCampanhas(SocioTorcedor socio) {
		socioTorcedorRepository.save(socio);
	}


	
	


}
