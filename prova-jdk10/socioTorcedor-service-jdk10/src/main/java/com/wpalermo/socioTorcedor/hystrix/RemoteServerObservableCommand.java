package com.wpalermo.socioTorcedor.hystrix;

import org.jboss.logging.Logger;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.service.impl.ICampanhaHttpRequest;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RemoteServerObservableCommand extends HystrixObservableCommand<SocioTorcedor> implements ICampanhaHttpRequest{
	
	private SocioTorcedor socioTorcedor;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected RemoteServerObservableCommand(HystrixCommandGroupKey group, SocioTorcedor socioTorcedor) {
		super(group);
		
		this.socioTorcedor = socioTorcedor;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Observable<SocioTorcedor> construct() {
		return 	(Observable<SocioTorcedor>) Observable.just(socioTorcedor)
				  .subscribeOn(Schedulers.io())
				  .doOnCompleted(() -> logger.info("Leitura feita com sucesso "))
				  .subscribe(socio -> this.socioTorcedor = request(socio),
						  	 Throwable::printStackTrace,
						  	 () -> serviceSuccess(socioTorcedor));
	}

	@Override
	public void callBack(SocioTorcedor object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SocioTorcedor request(SocioTorcedor object) {
		try {
			new RemoteServerSimulator(1000).execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void serviceError(SocioTorcedor object, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serviceSuccess(SocioTorcedor object) {
		// TODO Auto-generated method stub
		
	}




	
	

}
