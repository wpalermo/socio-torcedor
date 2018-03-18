package com.wpalermo.socioTorcedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.socioTorcedor.bean.Campanha;
import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.exception.SocioTorcedorException;
import com.wpalermo.socioTorcedor.service.ISocioTorcedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/socioTorcedor")
public class SocioTorcedorController {

	
	@Autowired
	private ISocioTorcedorService socioTorcedorService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Campanha> cadastrarSocioTorcedor(@RequestBody SocioTorcedor socioTorcedor) throws SocioTorcedorException, PersistenceException {
		
		return socioTorcedorService.cadastrarSocioTorcedor(socioTorcedor);
		
	}
	
}
