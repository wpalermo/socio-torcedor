package com.wpalermo.socioTorcedor.service.impl;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.utils.HystrixKeyEnum;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CampanhaHttpRequest extends HystrixCommand<ResponseEntity<ArrayList<Campanha>>> {

	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private RestTemplate restTemplate;
	
	private String URL;
	
	
	public CampanhaHttpRequest(String URL) {
		super(HystrixCommandGroupKey.Factory.asKey(HystrixKeyEnum.CAMPANHA.key));
		this.URL = URL;
	}

	
	
	@Override
	protected ResponseEntity run() throws Exception {
		logger.info("Fazendo requisicao para " + URL);
		return restTemplate.getForObject(URL, ResponseEntity.class);
	}
	

	@Override
	protected ResponseEntity getFallback() {
		logger.info("Problema ao acessar servico de campanhas " + URL);
		ResponseEntity returnable = new ResponseEntity("Erro ao acessar campanha", HttpStatus.EXPECTATION_FAILED);
		return returnable;
	}
	
	


}
