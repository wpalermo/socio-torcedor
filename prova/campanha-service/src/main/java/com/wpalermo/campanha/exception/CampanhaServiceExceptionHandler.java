package com.wpalermo.campanha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CampanhaServiceExceptionHandler {
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Falha no servico de campanha")
	@ExceptionHandler(CampanhaException.class)
	public String campanhaException(Exception e) {
		return "Erro generico com servico de campanha " + e.getMessage() ;
	}
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Problema com data de vigencia")
	@ExceptionHandler(CampanhaException.class)
	public String dataVigenciaException(Exception e) {
		return "Erro generico com data de vigencia " + e.getMessage() ;
	}

}
