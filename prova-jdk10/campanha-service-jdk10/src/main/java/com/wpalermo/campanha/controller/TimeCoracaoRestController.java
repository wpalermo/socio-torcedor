package com.wpalermo.campanha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ITimeCoracaoService;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/campanha/timeCoracao/{idTimeCoracao}")
public class TimeCoracaoRestController {
	
	@Autowired
	private ITimeCoracaoService timeCoracaoService;
	

	@RequestMapping(method = RequestMethod.GET, produces= {"application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<Campanha>> getByTimeCoracao(@PathVariable Integer idTimeCoracao){
		
		CampanhaResponse response = new CampanhaResponse();
		response.setCampanhas(timeCoracaoService.findById(idTimeCoracao));
		
		return new ResponseEntity<>(response.getCampanhas(), HttpStatus.OK);
	}

	public ResponseEntity<CampanhaResponse> get() {
		return null;
	}

	public ResponseEntity<CampanhaResponse> put(Integer id, RequestEntity<CampanhaRequest> request) {
		return null;
	}

	public ResponseEntity<CampanhaResponse> post(RequestEntity<CampanhaRequest> request) {
		return null;
	}

	public void delete(String request) {
		
	}

	

	
	

}
