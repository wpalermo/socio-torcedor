package com.wpalermo.campanha.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;
import com.wpalermo.campanha.exception.DataVigenciaException;
import com.wpalermo.campanha.response.CampanhaResponse;
import com.wpalermo.campanha.service.ICampanhaService;
import com.wpalermo.campanha.utils.MensagensEnum;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/campanha")
public class CampanhaController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICampanhaService campanhaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public CampanhaResponse create(@RequestBody Campanha campanha) {

		try {
			campanhaService.createCampanha(campanha);
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.SUCESSO.mensagem);

			return response;
		} catch (CampanhaException e) {
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			return response;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public CampanhaResponse update(@RequestBody Campanha campanha) throws CampanhaException {
		try {
			campanhaService.updateCampanha(campanha);
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.SUCESSO.mensagem);

			return response;
		} catch (CampanhaException e) {
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			return response;
		}
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public CampanhaResponse read(@RequestParam Integer campanhaId) throws CampanhaException {
		
		try {
			Campanha campanha = campanhaService.readCampanha(campanhaId);
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.SUCESSO.mensagem);

			return response;
		} catch (CampanhaException | DataVigenciaException e) {
			CampanhaResponse response = new CampanhaResponse(null, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			return response;
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public CampanhaResponse delete(@RequestParam Integer campanhaId) throws CampanhaException {
		try {
			campanhaService.deleteCampanha(campanhaId);
			CampanhaResponse response = new CampanhaResponse(null, MensagensEnum.SUCESSO.mensagem);

			return response;
		} catch (CampanhaException e) {
			CampanhaResponse response = new CampanhaResponse(null, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			return response;
		}
	}
	
	
	@RequestMapping(value = "/buscaPorTime", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ArrayList<Campanha> buscaPorTime(@RequestParam Integer idTimeCoracao) throws CampanhaException, DataVigenciaException {
			ArrayList<Campanha> campanhas = campanhaService.buscaPorTime(idTimeCoracao);
			return campanhas;
	}

}
