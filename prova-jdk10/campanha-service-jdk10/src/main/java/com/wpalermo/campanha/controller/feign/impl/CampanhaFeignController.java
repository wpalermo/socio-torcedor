package com.wpalermo.campanha.controller.feign.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.campanha.controller.feign.ICampanhaFeignController;
import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ICampanhaService;

@RestController
public class CampanhaFeignController implements ICampanhaFeignController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICampanhaService campanhaService;
	
	
	@Override
	public ResponseEntity<List<Campanha>> get() {
		CampanhaResponse campanha = new CampanhaResponse();
		campanha.setCampanhas(campanhaService.getAll());

		return new ResponseEntity<>(campanha.getCampanhas(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CampanhaResponse> put(Integer id, RequestEntity<CampanhaRequest> request) {
		Campanha c = request.getBody().getCampanha();
		c.setIdCampanha(id);

		
		campanhaService.createCampanha(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
