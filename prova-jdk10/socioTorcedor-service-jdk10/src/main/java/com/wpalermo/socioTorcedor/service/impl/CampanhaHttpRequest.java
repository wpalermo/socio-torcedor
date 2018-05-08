package com.wpalermo.socioTorcedor.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.utils.SocioTorcedorUtils;

import rx.Observable;
import rx.schedulers.Schedulers;


@Service
public class CampanhaHttpRequest implements ICampanhaHttpRequest{

	
	@Autowired
	private RestServers servers;
	
	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;
	
	private ListaCampanhaResponse response;
	
	private RestTemplate restTemplate;
	
	private SocioTorcedor st;
	

	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	@HystrixCommand(fallbackMethod="serviceError")
	public void callBack(SocioTorcedor socioTorcedor) {
		
		st = new SocioTorcedor();
				
		Observable.just(socioTorcedor)
		  .subscribeOn(Schedulers.io())
		  .doOnCompleted(() -> logger.info("Leitura feita com sucesso "))
		  .subscribe(socio -> st = request(socio),
				  	 Throwable::printStackTrace,
				  	 () -> serviceSuccess(st));
		
	}
	
	@Override
	public SocioTorcedor request(SocioTorcedor socioTorcedor) {
		
		final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();
		this.response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);
		
		this.response = new ListaCampanhaResponse();
		response.setMessage("FOII");
		

		socioTorcedor = SocioTorcedorUtils.atualizarCampanhas(socioTorcedor, response.getCampanhas());
		return socioTorcedor;
		
	}


	@Override
	public void serviceSuccess(SocioTorcedor socioTorcedor) {
		logger.info("insere " + this.response.getMessage());		
		
		socioTorcedorRepository.save(socioTorcedor);
	}
	
	@Override
	public void serviceError(SocioTorcedor socioTorcedor, Throwable throwable) {
		logger.error("Erro ao chamar servico de campanha" + throwable.getMessage());
	}








	

}
