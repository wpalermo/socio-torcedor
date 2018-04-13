package com.wpalermo.campanha.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/campanha/timeCoracao/{idTimeCoracao}")
public class TimeCoracaoRestController implements RestResource<CampanhaResponse, CampanhaRequest> {

	@Override
	public ResponseEntity<CampanhaResponse> get() {
		return null;
	}

	@Override
	public ResponseEntity<CampanhaResponse> put(Integer id, RequestEntity<CampanhaRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CampanhaResponse> post(RequestEntity<CampanhaRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer request) {
		// TODO Auto-generated method stub
		
	}

}
