package com.wpalermo.campanha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.subscribers.CampanhaSubscriber;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SubscriberTest {

	
	@Test
	public void testSubscriber() {
		
		CampanhaRequest campanhaRequest = new CampanhaRequest();
		Campanha campanha = new Campanha();
		List<Campanha> campanhas = new ArrayList<Campanha>();
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Natal");
		
		SubmissionPublisher<Campanha> publisher = new SubmissionPublisher<>();
		CampanhaSubscriber subscriber = new CampanhaSubscriber();
		publisher.subscribe(subscriber);
		
		publisher.submit(campanha);
		
		System.out.println("foi");
		
		publisher.close();
		
		
	}
	
}
