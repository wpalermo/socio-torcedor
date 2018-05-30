package com.wpalermo.socioTorcedor.requests;

import java.util.List;

import org.jboss.logging.Logger;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.resources.CampanhaResource;
import com.wpalermo.socioTorcedor.utils.HystrixKeyEnum;

public class CampanhaHttpRequest extends HystrixCommand<List<Campanha>> {

	private Logger logger = Logger.getLogger(this.getClass());
	


	private CampanhaResource campanhaResource;

	public CampanhaHttpRequest(CampanhaResource campanhaResource ) {
		super(HystrixCommandGroupKey.Factory.asKey(HystrixKeyEnum.CAMPANHA.key));
		this.campanhaResource = campanhaResource;
	}

	@Override
	protected List<Campanha> run() throws Exception {
		logger.info("Fazendo requisicao para CAMPANHA-SERVICE");
		return campanhaResource.get();
	}

	@Override
	protected List<Campanha> getFallback() {
		logger.info("Problema ao acessar servico de campanhas CAMPANHA-SERVICE");
		return null;
	}

}
