package com.wpalermo.campanha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ICampanhaService;


@Controller
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
	public ResponseEntity<CampanhaResponse> get()  {
		
		CampanhaResponse campanha = new CampanhaResponse();
		campanha.setMessage("Testes ok");
		
		
		//throw new CampanhaException("Eita");
		return new ResponseEntity<CampanhaResponse>(campanha, HttpStatus.OK);
		 
	}


	@Override
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> put() {
		return null;
	}

	
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<CampanhaResponse> post(RequestEntity<CampanhaRequest> request) {
		
		CampanhaRequest resource = request.getBody();
		
		if(resource.getCampanha() == null || resource.getCampanha().size() == 0)
			return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);
		
		
//		if(resource.getCampanha().size() > 1)
//			throw new CampanhaException("Nenhum registro encontrado");
//		else if(resource.getCampanha().size() == 1)
//			campanhaService.createCampanha(resource.getCampanha().get(0));
		
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
