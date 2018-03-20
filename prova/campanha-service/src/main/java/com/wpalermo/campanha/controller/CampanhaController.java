package com.wpalermo.campanha.controller;

import java.util.List;

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
import com.wpalermo.campanha.response.ListaCampanhaResponse;
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
			logger.info("Iniciando cadastro de campanha");
			campanhaService.createCampanha(campanha);
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.SUCESSO.mensagem);

			
			logger.info("Campanha cadastrada com sucesso");
			return response;
		} catch (CampanhaException e) {
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			logger.error("Problema ao cadastrar campanha : " + e.getMessage());
			return response;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public CampanhaResponse update(@RequestBody Campanha campanha) throws CampanhaException {
		try {
			logger.info("Iniciando atualizacao de campanha");

			campanhaService.updateCampanha(campanha);
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.SUCESSO.mensagem);

			logger.info("Campanha atualizada com sucesso - ID:" + campanha.getIdCampanha());

			return response;
		} catch (CampanhaException e) {
			CampanhaResponse response = new CampanhaResponse(campanha, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			
			logger.error("Problema ao realizar update " + campanha.getIdCampanha());
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

			
			logger.info("Busca realizada com sucesso. Campanha encontrada: " + campanha.getNomeCampanha());
			return response;
		} catch (CampanhaException | DataVigenciaException e) {
			CampanhaResponse response = new CampanhaResponse(null, MensagensEnum.ERRO.mensagem);
			response.setErro(e.getLocalizedMessage());
			
			logger.error("Erro ao buscar campanha " + e.getMessage());

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
	public ListaCampanhaResponse buscaPorTime(@RequestParam Integer idTimeCoracao) throws CampanhaException, DataVigenciaException {
		
			logger.info("Iniciando busca de campanha por time do coracao");

			List<Campanha> campanhas = campanhaService.buscaPorTime(idTimeCoracao);
			ListaCampanhaResponse response = new ListaCampanhaResponse();
			response.setCampanhas(campanhas);
			
			
			return response;
	}
	
	@RequestMapping(value = "/popularCampanhas", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void buscaPorTime(@RequestBody List<Campanha> campanhas) throws CampanhaException, DataVigenciaException {
		
			logger.info("Iniciando busca de campanha por time do coracao");

			campanhas.stream().forEach(c -> {
				try {
					campanhaService.createCampanha(c);
				} catch (CampanhaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
	}

}
