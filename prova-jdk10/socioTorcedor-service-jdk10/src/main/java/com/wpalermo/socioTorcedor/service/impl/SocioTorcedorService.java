package com.wpalermo.socioTorcedor.service.impl;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

import rx.schedulers.Schedulers;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;
	
	@Autowired
	private RestServers servers;
	
	private ResponseEntity<ArrayList<Campanha>> response;

	@Override
	public SocioTorcedor cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {
		
		logger.info("Cadastrando socio torcedor");
		
		final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();

		
		CampanhaHttpRequest campanhaHttpRequest = new CampanhaHttpRequest(URL);

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
	public void atualizarCampanhas(SocioTorcedor socio, ResponseEntity<ArrayList<Campanha>> reponse) {
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			socio.getTimeCoracao().setCampanhasAssociadas(response.getBody());			
			socioTorcedorRepository.save(socio);
		}else
			logger.error(response.getBody());
		
		
		
	}



}
