package com.wpalermo.socioTorcedor.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.config.RestServers;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.repository.SocioTorcedorRepository;
import com.wpalermo.socioTorcedor.response.ListaCampanhaResponse;
import com.wpalermo.socioTorcedor.utils.HystrixKeyEnum;
import com.wpalermo.socioTorcedor.utils.SocioTorcedorUtils;


@Service
public class CampanhaHttpRequest extends HystrixCommand<SocioTorcedor> implements ICampanhaHttpRequest{

	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private RestServers servers;
	
	@Autowired
	private SocioTorcedorRepository socioTorcedorRepository;
	
	private ListaCampanhaResponse response;
	
	private RestTemplate restTemplate;
	
	private SocioTorcedor socioTorcedor;
	
	
	
	public CampanhaHttpRequest(SocioTorcedor socioTorcedor) {
		super(HystrixCommandGroupKey.Factory.asKey(HystrixKeyEnum.CAMPANHA.key));
		this.socioTorcedor = socioTorcedor;
		
	}

	
	
	@Override
	protected SocioTorcedor run() throws Exception {
		
		final String URL = servers.getCampanhaUrl() + "/campanha/timeCoracao/" + socioTorcedor.getTimeCoracao().getIdTimeCoracao();
		this.response = restTemplate.getForObject(URL, ListaCampanhaResponse.class);
		
		this.response = new ListaCampanhaResponse();
		response.setMessage("FOII");
		

		socioTorcedor = SocioTorcedorUtils.atualizarCampanhas(socioTorcedor, response.getCampanhas());
		return socioTorcedor;
	}
	
	
	

	@Override
	protected SocioTorcedor getFallback() {
		return null;
	}
	
	

	public void serviceSuccess(SocioTorcedor socioTorcedor) {
		logger.info("insere " + this.response.getMessage());		
		
		socioTorcedorRepository.save(socioTorcedor);
	}
	


//	@Override
//	public void callBack(SocioTorcedor socioTorcedor) {
//		
//		st = new SocioTorcedor();
//		
//		
//				
////		Observable.just(socioTorcedor)
////		  .subscribeOn(Schedulers.io())
////		  .doOnCompleted(() -> logger.info("Leitura feita com sucesso "))
////		  .subscribe(socio -> st = request(socio),
////				  	 Throwable::printStackTrace,
////				  	 () -> serviceSuccess(st));
//		
//	}





	

}
