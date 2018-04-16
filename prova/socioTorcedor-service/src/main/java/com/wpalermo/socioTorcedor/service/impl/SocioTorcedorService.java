package com.wpalermo.socioTorcedor.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.reposiroty.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;

	@Autowired
	private RestServers restServers;

	@Override
	public CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor)
			throws SocioTorcedorException, PersistenceException {

		RestTemplate restTemplate = new RestTemplate();

		final String URL = restServers.getCampanhaUrl() + "/campanha/socioTorcedor/"
				+ socioTorcedor.getTimeCoracao().getIdTimeCoracao();

		if (socioTorcedorRepository.existsById(socioTorcedor.getEmail())) {

			ListaCampanhaResponse response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);

			CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();

			if (socioTorcedor.getTimeCoracao().getCampanhasAssociadas() == null
					|| socioTorcedor.getTimeCoracao().getCampanhasAssociadas().isEmpty()) {

				cadastrarSocioTorcedorResponse.setCampanhas(response.getCampanhas());
				cadastrarSocioTorcedorResponse.setMessage(
						"Cadastro ja existente para o email  " + socioTorcedor.getEmail() + " atualizando campanhas");

				return cadastrarSocioTorcedorResponse;

			} else {

				socioTorcedor = atualizarCampanhas(socioTorcedor, response.getCampanhas());

				cadastrarSocioTorcedorResponse.setCampanhas(response.getCampanhas());
				cadastrarSocioTorcedorResponse.setMessage(
						"Cadastro ja existente para o email  " + socioTorcedor.getEmail() + " atualizando campanhas");

				return cadastrarSocioTorcedorResponse;

			}

		} else {

			socioTorcedorRepository.save(socioTorcedor);

			logger.info("Iniciando chamada de servico de campanha - URL: " + URL);

			// Chamada de servico

			ListaCampanhaResponse response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);

			// Associa as campanhas
			socioTorcedor.getTimeCoracao().setCampanhasAssociadas(response.getCampanhas());

			socioTorcedorRepository.save(socioTorcedor);

			// gera a response
			CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();
			cadastrarSocioTorcedorResponse.setCampanhas(socioTorcedor.getTimeCoracao().getCampanhasAssociadas());
			cadastrarSocioTorcedorResponse
					.setMessage("Usuario cadastrado com sucesso - email  " + socioTorcedor.getEmail());

			return cadastrarSocioTorcedorResponse;

		}
	}

	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) throws PersistenceException {
		return socioTorcedorRepository.findById(email).get();
	}

	
	
	private SocioTorcedor atualizarCampanhas(SocioTorcedor socio, List<Campanha> campanhas) {

		Set<Integer> ids = socio.getTimeCoracao().getCampanhasAssociadas().stream().map(Campanha::getIdCampanha)
				.collect(Collectors.toSet());

		List<Campanha> campanhasFaltantes = campanhas.stream().filter(camp -> !ids.contains(camp.getIdCampanha()))
				.collect(Collectors.toList());

		socio.getTimeCoracao().getCampanhasAssociadas().addAll(campanhasFaltantes);

		return socio;
	}

}
