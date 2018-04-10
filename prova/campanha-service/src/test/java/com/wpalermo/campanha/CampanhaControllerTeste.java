package com.wpalermo.campanha;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CampanhaControllerTeste {
	
	
	final String BASE_PATH = "http://localhost:8080/campanha";
	
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		this.restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGet() {
		
		
		
		ResponseEntity<Object> response = restTemplate.getForObject(BASE_PATH, ResponseEntity.class);
		
		Assert.assertEquals(null, response);
		
	}
	
	

}
