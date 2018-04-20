package com.wpalermo.campanha.publishers;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.subscribers.CampanhaSubscriber;

public class CampanhaPublisher implements Publisher<Campanha>{

	@Override
	public void subscribe(Subscriber<? super Campanha> subscriber) {
		CampanhaSubscriber subscription = new CampanhaSubscriber();
		subscriber.onSubscribe((Subscription) subscription);
	}

}
