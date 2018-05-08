package com.wpalermo.socioTorcedor.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.CampanhaServiceException;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ICampanhaHttpRequest;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CampanhaHttpRequest implements ICampanhaHttpRequest {

	
	@Autowired
	private RestServers servers;
	
	private ListaCampanhaResponse response;
	
	private RestTemplate restTemplate;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	@HystrixCommand(fallbackMethod="serviceError")
	public void requestCampanhas(SocioTorcedor socioTorcedor) {
		
		Observable.just(socioTorcedor)
		  .subscribeOn(Schedulers.io())
		  .doOnComplete(() -> {logger.info("URL lida com sucesso ");})
		  .subscribe(socio -> callCampanha(socio),
				  	 Throwable::printStackTrace,
				  	 () -> insereCampanhas());
		
		
	}
	
	
	
	
	private ListaCampanhaResponse callCampanha(SocioTorcedor socioTorcedor) {
		
		final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();
		//ListaCampanhaResponse response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);
		
		ListaCampanhaResponse response = new ListaCampanhaResponse();
		response.setMessage("FOII");
		this.response = response;
		return response;
		
		
	}
	
	private void insereCampanhas() {
		logger.info("insere " + this.response.getMessage());
	}




	@Override
	public void serviceError() {
		logger.error("Erro ao chamar servico de campanha");
	}
	

}
