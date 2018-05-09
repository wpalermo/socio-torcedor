package com.wpalermo.socioTorcedor.hystrix;

import org.jboss.logging.Logger;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class RemoteServerCommand extends HystrixCommand<String> {

	private String string;

	private Logger logger = Logger.getLogger(this.getClass());

	public RemoteServerCommand(String string) {
		super(HystrixCommandGroupKey.Factory.asKey("commandServer"));

		this.string = string;
	}

	@Override
	protected String run() throws Exception {
		logger.info("foi");
		Thread.sleep(9000);
		logger.info("foi2");
		return "Rodou";
	}

	@Override
	protected String getFallback() {
		logger.info("fallbackou");
		return "fallback return";
	}

}
