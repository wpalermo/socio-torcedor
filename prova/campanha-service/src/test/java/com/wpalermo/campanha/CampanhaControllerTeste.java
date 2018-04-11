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
import org.springframework.http.MediaType;
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
	public void setUp() {
		this.restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGet() {
		
		ResponseEntity<CampanhaResponse> response = restTemplate.getForEntity(BASE_PATH, CampanhaResponse.class);
		Assert.assertEquals("Testes ok", response.getBody().getMessage());
		
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
		campanhaRequest.setCampanha(campanhas);
		
		
		
		RequestEntity<CampanhaRequest> request = new RequestEntity<CampanhaRequest>(campanhaRequest, HttpMethod.POST, new URI(BASE_PATH));
		
		
		ResponseEntity<CampanhaResponse> response = restTemplate.postForEntity(BASE_PATH, request, CampanhaResponse.class);
		
		//ResponseEntity<CampanhaResponse> responseGet = restTemplate.getForEntity(BASE_PATH, CampanhaResponse.class);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	

}
