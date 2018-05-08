package com.wpalermo.socioTorcedor.service.impl;

import java.util.List;
import java.util.Set;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.CadastrarSocioTorcedorResponse;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;
import com.wpalermo.socioTorcedor.subscribers.RequestCampanhaSubscriber;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	 private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;




	@Override
	@HystrixCommand(fallbackMethod = "")
	public CadastrarSocioTorcedorResponse cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {

		if (socioTorcedorRepository.existsById(socioTorcedor.getEmail())) {

			//final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();
			//ListaCampanhaResponse response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);


 
		} else {

			socioTorcedorRepository.save(socioTorcedor);
			servers.getCampanhaUrl();

			// Chamada de servico

			SubmissionPublisher<SocioTorcedor> publisher = new SubmissionPublisher<>();
			RequestCampanhaSubscriber subscriber = new RequestCampanhaSubscriber();
			publisher.subscribe(subscriber);

			publisher.submit(socioTorcedor);

			publisher.close();
			// gera a response
			CadastrarSocioTorcedorResponse cadastrarSocioTorcedorResponse = new CadastrarSocioTorcedorResponse();
			cadastrarSocioTorcedorResponse.setCampanhas(socioTorcedor.getTimeCoracao().getCampanhasAssociadas());

			cadastrarSocioTorcedorResponse.setMessage("Usuario cadastrado com sucesso - email  " + socioTorcedor.getEmail());

			return cadastrarSocioTorcedorResponse;

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

	@Override
	public SocioTorcedor atualizarCampanhas(SocioTorcedor socio, List<Campanha> campanhas) {

		Set<Integer> ids = socio.getTimeCoracao().getCampanhasAssociadas().stream().map(Campanha::getIdCampanha).collect(Collectors.toSet());

		List<Campanha> campanhasFaltantes = campanhas.stream().filter(camp -> !ids.contains(camp.getIdCampanha())).collect(Collectors.toList());

		socio.getTimeCoracao().getCampanhasAssociadas().addAll(campanhasFaltantes);

		return socio;
	}
	
	


}
