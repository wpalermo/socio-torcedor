package com.wpalermo.campanha.subscribers;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.service.ICampanhaService;

@Service
public class CampanhaSubscriber implements Subscriber<Campanha>{

	Logger logger = Logger.getLogger(this.getClass());
	
	private Subscription subscription;
	
	@Autowired
	private ICampanhaService campanhaService;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(Campanha item) {
		campanhaService.createCampanha(item);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		logger.error("Erro ao adicionar registro");
	}

	@Override
	public void onComplete() {
		logger.info("Registro adicionado");
	}

}
