package com.wpalermo.socioTorcedor.subscribers;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@Component
public class RequestCampanhaSubscriber implements Subscriber<SocioTorcedor>{

	Logger logger = Logger.getLogger(this.getClass());

	
	private RestTemplate restTemplate;
	
	private Subscription subscription;
		
	private ListaCampanhaResponse response;
	
	private SocioTorcedor socio;
	
	@Autowired
	private RestServers restServers;
	
	@Autowired
	private ISocioTorcedorService socioTorcedorService;
	
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
		
	}


	@Override
	public void onNext(SocioTorcedor item) {
		final String URL = restServers.getCampanhaUrl() + "/campanha/timeCoracao/" + item.getTimeCoracao().getIdTimeCoracao();
		this.socio = item;
		response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);
		
		
		 
		
	}

	@Override
	public void onError(Throwable throwable) {
		logger.error("Erro ao acessar servico" + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		
		socio = socioTorcedorService.atualizarCampanhas(socio, response.getCampanhas());
		
		socioTorcedorService.atualizarCampanhas(socio);
		
		logger.info("Registro adicionado");
		
		
		
		
		
	}




}
