package com.wpalermo.socioTorcedor.service.impl;

import java.net.URI;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

import rx.schedulers.Schedulers;

@Service
public class SocioTorcedorService implements ISocioTorcedorService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;

	@Autowired
	private ICampanhaHttpRequest campanhaHttpRequest;
	
	private SocioTorcedor returnable;

	@Override
	public SocioTorcedor cadastrarSocioTorcedor(SocioTorcedor socioTorcedor) {
		
		logger.info("Cadastrando socio torcedor");
		
		
		campanhaHttpRequest = new CampanhaHttpRequest(socioTorcedor);
		
		ClientHttpRequestFactory request;
		
		request.createRequest(new URI(""), HttpMethod.POST);
		
		new RestTemplate(request);

		if (socioTorcedorRepository.existsById(socioTorcedor.getEmail())) {
			campanhaHttpRequest.toObservable()
 							   .subscribeOn(Schedulers.io())
 							   .subscribe(returned -> returnable = returned);

		} else {
			socioTorcedorRepository.save(socioTorcedor);
			
			campanhaHttpRequest.toObservable()
			   .subscribeOn(Schedulers.io())
			   .subscribe(returned -> returnable = returned,
					   	  Throwable::printStackTrace,
					   	  () -> atualizarCampanhas(returnable));		
		}
		
		
		
		return returnable;
	}

	@Override
	public SocioTorcedor buscarSocioTorcedor(String email) {
		return socioTorcedorRepository.findById(email).get();
	}

	public void atualizarCampanhas(SocioTorcedor socio) {
		socioTorcedorRepository.save(socio);
	}

}
