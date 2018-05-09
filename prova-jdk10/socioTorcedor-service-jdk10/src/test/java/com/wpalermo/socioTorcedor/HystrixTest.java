package com.wpalermo.socioTorcedor;

import static org.junit.Assert.assertEquals;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wpalermo.socioTorcedor.hystrix.RemoteServerCommand;

import rx.schedulers.Schedulers;

@RunWith(SpringRunner.class)
public class HystrixTest {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Test
	public void testHystrix() throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup2"));
		
		
		RemoteServerCommand serverCommand = new RemoteServerCommand("Aee");
		
		serverCommand.toObservable()
					 .subscribeOn(Schedulers.io())
					 .subscribe(string -> logger.info(string));

		assertEquals("", "Success");

	}
}
