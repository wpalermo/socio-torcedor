package com.wpalermo.socioTorcedor.service.impl;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.utils.HystrixKeyEnum;


@Service
public class CampanhaHttpRequest extends HystrixCommand<ListaCampanhaResponse> implements ICampanhaHttpRequest{

	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private RestTemplate restTemplate;
	
	private String URL;
	
	
	public CampanhaHttpRequest(String URL) {
		super(HystrixCommandGroupKey.Factory.asKey(HystrixKeyEnum.CAMPANHA.key));
		this.URL = URL;
	}

	
	
	@Override
	protected ListaCampanhaResponse run() throws Exception {
		logger.info("Fazendo requisicao para " + URL);
		return restTemplate.getForObject(URL, ListaCampanhaResponse.class);
	}
	
	
	

	@Override
	protected ListaCampanhaResponse getFallback() {
		logger.info("Problema ao acessar servico de campanhas " + URL);
		ListaCampanhaResponse returnable = new ListaCampanhaResponse();
		returnable.setErro("Problema ao acessar servico de campanhas");
		
		return returnable;
	}
	
	


}
