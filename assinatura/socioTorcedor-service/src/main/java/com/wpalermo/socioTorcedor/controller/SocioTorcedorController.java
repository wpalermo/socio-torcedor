package com.wpalermo.socioTorcedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/socioTorcedor")
public class SocioTorcedorController {

	@Autowired
	private ISocioTorcedorService socioTorcedorService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<SocioTorcedor> post(RequestEntity<SocioTorcedor> request){
		return new ResponseEntity<>(socioTorcedorService.cadastrarSocioTorcedor(request.getBody()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{email}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<SocioTorcedor> get(@PathVariable String email){
		return new ResponseEntity<>(socioTorcedorService.buscarSocioTorcedor(email), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{email}")
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public void put() {
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{email}")
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public void delete() {
	}
	
}
