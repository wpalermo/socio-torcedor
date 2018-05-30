package com.wpalermo.socioTorcedor.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.requests.CampanhaHttpRequest;
import com.wpalermo.socioTorcedor.resources.CampanhaResource;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

import rx.schedulers.Schedulers;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;
	
	@Autowired
	private CampanhaResource campanhaResource;
	
	@Autowired
	private RestServers servers;
	
	private List<Campanha> response;
	
	private Campanha campanhaResponse;

	@Override
	public SocioTorcedor cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {
		
		logger.info("Cadastrando socio torcedor");
		
		final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();
		//List<Campanha> camapanhas = campanhaResource.get();

		
		CampanhaHttpRequest campanhaHttpRequest = new CampanhaHttpRequest(campanhaResource);

		if (socioTorcedorRepository.existsById(socioTorcedor.getEmail())) {

			campanhaHttpRequest.toObservable()
							   .subscribeOn(Schedulers.io())
							   .subscribe(returned -> response = returned, 
							   			  Throwable::printStackTrace, 
							   			  () -> atualizarCampanhas(socioTorcedor, response));

		} else {

			socioTorcedorRepository.save(socioTorcedor);
			campanhaHttpRequest.toObservable()
							   .subscribeOn(Schedulers.io())
							   .subscribe(returned -> response = returned, 
							   		      Throwable::printStackTrace,
							   		      () -> atualizarCampanhas(socioTorcedor, response));
		}
		
		
		return socioTorcedor;
	}

	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) {
		return socioTorcedorRepository.findById(email).get();
	}

	@Override
	public void atualizarCampanhas(SocioTorcedor socio, List<Campanha> reponse) {
				socio.getTimeCoracao().setCampanhasAssociadas(response);			
				socioTorcedorRepository.save(socio);
				logger.info("Novas campanhas adicionadas com sucesso");
		
	}




}
