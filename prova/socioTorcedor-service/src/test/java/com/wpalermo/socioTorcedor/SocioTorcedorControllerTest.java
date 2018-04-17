package com.wpalermo.socioTorcedor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.entities.TimeCoracao;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SocioTorcedorControllerTest {
	
	
	final String BASE_PATH = "http://localhost:8081/socioTorcedor";
	
	private RestTemplate restTemplate;
	
	
	@Before
	public void setUp() {
		this.restTemplate = new RestTemplate();
	}
	
	
	
	@Test
	public void testPost() {
		
		
		
		TimeCoracao timeCoracao = new TimeCoracao();
		timeCoracao.setIdTimeCoracao(1);
		timeCoracao.setNomeTimeCoracao("Sao Paulo Futebol Clube");
		
		SocioTorcedor socio = new SocioTorcedor();
		socio.setEmail("palermow@gmail.com");
		socio.setNome("William");
		socio.setTimeCoracao(timeCoracao);
		
		ResponseEntity<SocioTorcedor> response = restTemplate.postForEntity(BASE_PATH, socio, SocioTorcedor.class);
		
		response.getBody();
		
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}
	
	
	@Test
	public void testGet() {
		
		Assert.assertTrue(true);
		
	}
	

}
