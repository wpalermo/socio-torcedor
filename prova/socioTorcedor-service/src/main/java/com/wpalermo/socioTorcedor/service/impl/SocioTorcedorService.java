package com.wpalermo.socioTorcedor.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.socioTorcedor.bean.Campanha;
import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.dao.ISocioTorcedorDAO;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;
import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	@Autowired
	private ISocioTorcedorDAO socioTorcedorDAO;

	@Autowired
	private RestServers restServers;

	@Override
	public CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException {

		Logger logger = Logger.getLogger(this.getClass());

		try {
				socioTorcedorDAO.cadastrarSocioTorcedor(socioTorcedor);
	
				logger.info("Iniciando chamada de servico de campanha - URL: " + restServers.getCampanhaUrl() + "/campanha/buscaPorItme?idTimeCoracao=" + socioTorcedor.getTimeCoracao().getIdTimeCoracao());
				
				try {
					//Chamada de servico
					RestTemplate restTemplate = new RestTemplate();
					ListaCampanhaResponse response = restTemplate.getForObject(restServers.getCampanhaUrl() + "/campanha/buscaPorTime?idTimeCoracao=" + socioTorcedor.getTimeCoracao().getIdTimeCoracao(),
							ListaCampanhaResponse.class);
		
					//Associa as campanhas
					socioTorcedor.getTimeCoracao().setCampanhasAssociadas(response.getCampanhas());
		
					socioTorcedorDAO.updateSocioTorcedor(socioTorcedor);
					
					//gera a response
					CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();
					cadastrarSocioTorcedorResponse.setCampanhas(socioTorcedor.getTimeCoracao().getCampanhasAssociadas());
					cadastrarSocioTorcedorResponse.setMessage("Usuario cadastrado com sucesso - email  " + socioTorcedor.getEmail());
					
					
					return cadastrarSocioTorcedorResponse;
					
				}catch (ResourceAccessException rae) {
					logger.warn("Problema ao tentar acessar servico de CAMPANHAS " + rae.getMessage());
					throw new SocioTorcedorException("Problema ao associar as campanhas servico fora do ar. SocioTorcedor cadastrado sem campanhas, tente novamente mais tarde", rae);
				}

		} catch (PersistenceException e) {
			try {
				if (e.getPersistenceEnum().equals(PersistenceDatailEnum.EMAIL_EXISTENTE)) {

					SocioTorcedor socioEncontrado = socioTorcedorDAO.buscarSocioTorcedor(socioTorcedor.getEmail());
					
					if(socioEncontrado.getTimeCoracao().getCampanhasAssociadas() == null || socioEncontrado.getTimeCoracao().getCampanhasAssociadas().isEmpty()) {
						ListaCampanhaResponse response = new RestTemplate().getForObject(restServers.getCampanhaUrl() + "/campanha/buscaPorTime?idTimeCoracao=" + socioTorcedor.getTimeCoracao().getIdTimeCoracao(), ListaCampanhaResponse.class);

						CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();
						cadastrarSocioTorcedorResponse.setCampanhas(response.getCampanhas());
						cadastrarSocioTorcedorResponse.setMessage("Cadastro ja existente para o email  " + socioEncontrado.getEmail());
						
						return cadastrarSocioTorcedorResponse;

					}
					ListaCampanhaResponse response = new RestTemplate().getForObject(restServers.getCampanhaUrl() + "/campanha/buscaPorTime?idTimeCoracao=" + socioTorcedor.getTimeCoracao().getIdTimeCoracao(), ListaCampanhaResponse.class);

					Set<Integer> ids = socioEncontrado.getTimeCoracao().getCampanhasAssociadas().stream()
																								.map(Campanha::getIdCampanha)
																								.collect(Collectors.toSet());

					List<Campanha> campanhasFaltantes = response.getCampanhas().stream()
																			   .filter(camp -> !ids.contains(camp.getIdCampanha()))
																			   .collect(Collectors.toList());

					socioEncontrado.getTimeCoracao().getCampanhasAssociadas().addAll(campanhasFaltantes);

					
					
					CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();
					cadastrarSocioTorcedorResponse.setCampanhas(response.getCampanhas());
					cadastrarSocioTorcedorResponse.setMessage("Campanhas atualizadas para o email  " + socioEncontrado.getEmail());
					socioTorcedorDAO.updateSocioTorcedor(socioEncontrado);
					
					return cadastrarSocioTorcedorResponse;

				}
			} catch (ResourceAccessException rae) {
				logger.warn("Problema ao tentar acessar servico de CAMPANHAS " + rae.getMessage());
				throw new SocioTorcedorException("Problema ao acossiar as campanhas servico fora do ar. SocioTorcedor sem atualizacao das campanhas, tente novamente mais tarde", rae);
			}
		}
		return null;
	}
	
	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) throws PersistenceException {
		return socioTorcedorDAO.buscarSocioTorcedor(email);
	}

}
