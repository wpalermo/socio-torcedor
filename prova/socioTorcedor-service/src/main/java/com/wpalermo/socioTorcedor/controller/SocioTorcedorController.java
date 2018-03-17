package com.wpalermo.socioTorcedor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/socioTorcedor")
public class SocioTorcedorController {

	
	
	private ISocioTorcedorService socioTorcedorService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void cadastrarSocioTorcedor(@RequestBody SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException {
		
		socioTorcedorService.cadastrarSocioTorcedor(socioTorcedor);
		
	}
	
}
