package com.wpalermo.socioTorcedor.requests;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.utils.HystrixKeyEnum;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CampanhaHttpRequest extends HystrixCommand<ResponseEntity<List<Campanha>>> {

	private Logger logger = Logger.getLogger(this.getClass());

	private RestTemplate restTemplate;

	private String URL;

	public CampanhaHttpRequest(String URL) {
		super(HystrixCommandGroupKey.Factory.asKey(HystrixKeyEnum.CAMPANHA.key));
		this.restTemplate = new RestTemplate();
		this.URL = URL;
	}

	@Override
	protected ResponseEntity<List<Campanha>> run() throws Exception {
		logger.info("Fazendo requisicao para " + URL);
		return new ResponseEntity(restTemplate.getForObject(URL, List.class),  HttpStatus.OK);
	}

	@Override
	protected ResponseEntity getFallback() {
		logger.info("Problema ao acessar servico de campanhas " + URL);
		ResponseEntity returnable = new ResponseEntity("Erro ao acessar campanha", HttpStatus.EXPECTATION_FAILED);
		return returnable;
	}

}
