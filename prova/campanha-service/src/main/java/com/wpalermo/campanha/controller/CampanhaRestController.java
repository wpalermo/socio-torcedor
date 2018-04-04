package com.wpalermo.campanha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ICampanhaService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/campanha")
public class CampanhaRestController implements RestResource<CampanhaResponse, CampanhaRequest> {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICampanhaService campanhaService;

	@Override
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> get() {
		
		return new ResponseEntity<CampanhaResponse>(new CampanhaResponse(campanhaService.getAll()), HttpStatus.OK);
		 
	}


	@Override
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> put() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(CampanhaException.class)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> post(RequestEntity<CampanhaRequest> request) {
		
		CampanhaRequest resource = request.getBody();
		
		if(resource.getCampanha() == null || resource.getCampanha().size() == 0)
			return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);
		
		
		if(resource.getCampanha().size() > 1)
			logger.info("implementar metodo para receber lista");
		else if(resource.getCampanha().size() == 1)
			campanhaService.createCampanha(resource.getCampanha().get(0));
		
		return null;

		
		
		
	}

	@Override
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public void delete(RequestEntity<CampanhaRequest> request) {
		// TODO Auto-generated method stub
		
	}




}
