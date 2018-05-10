package com.wpalermo.socioTorcedor.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private ListaCampanhaResponse response;


	@Override
	public SocioTorcedor cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {
		
		logger.info("Cadastrando socio torcedor");
		
		CampanhaHttpRequest campanhaHttpRequest = new CampanhaHttpRequest("");

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
	public void atualizarCampanhas(SocioTorcedor socio, ListaCampanhaResponse reponse) {
		socio.getTimeCoracao().setCampanhasAssociadas(response.getCampanhas());
		socioTorcedorRepository.save(socio);
	}



}
