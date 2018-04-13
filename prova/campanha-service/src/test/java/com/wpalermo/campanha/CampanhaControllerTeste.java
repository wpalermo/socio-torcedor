package com.wpalermo.campanha;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CampanhaControllerTeste {
	
	
	final String BASE_PATH = "http://localhost:8082/campanha";
	
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() throws URISyntaxException {
		this.restTemplate = new RestTemplate();
		
		
		CampanhaRequest campanhaRequest = new CampanhaRequest();
		Campanha campanha = new Campanha();
		List<Campanha> campanhas = new ArrayList<Campanha>();
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Natal");
		campanhas.add(campanha);

		
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Dia das Maes");
		campanhas.add(campanha);

		
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(2);
		campanha.setNomeCampanha("Dia dos namorados");
		campanhas.add(campanha);

		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(2);
		campanha.setNomeCampanha("Dia dos Pais");
		campanhas.add(campanha);

		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(3);
		campanha.setNomeCampanha("Black Friday");
		campanhas.add(campanha);

		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(4);
		campanha.setNomeCampanha("Natal");
		campanhas.add(campanha);

		campanhaRequest.setCampanhas(campanhas);
		
		RequestEntity<CampanhaRequest> request = new RequestEntity<CampanhaRequest>(campanhaRequest, HttpMethod.POST, new URI(BASE_PATH));
		restTemplate.postForEntity(BASE_PATH, request, CampanhaResponse.class);
		
		
	}
	
	@Test
	public void testGet() {
		ResponseEntity<CampanhaResponse> response = restTemplate.getForEntity(BASE_PATH, CampanhaResponse.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testPost() throws URISyntaxException {
		
		CampanhaRequest campanhaRequest = new CampanhaRequest();
		Campanha campanha = new Campanha();
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Mundial");
		
		List<Campanha> campanhas = new ArrayList<Campanha>();
		campanhas.add(campanha);
		campanhaRequest.setCampanhas(campanhas);
		
		
		
		RequestEntity<CampanhaRequest> request = new RequestEntity<CampanhaRequest>(campanhaRequest, HttpMethod.POST, new URI(BASE_PATH));
		ResponseEntity<CampanhaResponse> response = restTemplate.postForEntity(BASE_PATH, request, CampanhaResponse.class);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	public void testPut() throws URISyntaxException{
		
		Integer id = 1;
		
		CampanhaRequest campanhaRequest = new CampanhaRequest();
		Campanha campanha = new Campanha();
		
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Teste PUT (UPDATE)");
		
		campanhaRequest.setCampanha(campanha);
		
		RequestEntity<CampanhaRequest> request = new RequestEntity<CampanhaRequest>(campanhaRequest, HttpMethod.PUT, new URI(BASE_PATH));
		restTemplate.put(BASE_PATH + "//" + id, request);
		
		Assert.assertTrue(true);
		
	}
	
	
	@Test
	public void testDelete() {
		restTemplate.delete(BASE_PATH + "/1");
		Assert.assertTrue(true);
	}
	

}
