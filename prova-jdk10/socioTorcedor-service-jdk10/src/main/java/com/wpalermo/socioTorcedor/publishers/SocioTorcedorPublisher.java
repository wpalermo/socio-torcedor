package com.wpalermo.socioTorcedor.publishers;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.wpalermo.socioTorcedor.subscribers.RequestCampanhaSubscriber;

public class SocioTorcedorPublisher implements Publisher<RequestCampanhaSubscriber>{

	@Override
	public void subscribe(Subscriber<? super RequestCampanhaSubscriber> subscriber) {
		RequestCampanhaSubscriber subscription = new RequestCampanhaSubscriber();
		subscriber.onSubscribe((Subscription) subscription);
	}

}
