package com.wpalermo.campanha.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
public class CampanhaServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Falha no servico de campanha")
	@ExceptionHandler(value=CampanhaException.class)
	public String campanhaException(Exception e) {
		return "Erro generico com servico de campanha " + e.getMessage() ;
	}
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Problema com data de vigencia")
	@ExceptionHandler(value=DataVigenciaException.class) 
	public String dataVigenciaException(Exception e) {
		return "Erro generico com data de vigencia " + e.getMessage() ;
	}
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Problema com data de vigencia")
	@ExceptionHandler(value=IOException.class) 
	public String ioException(Exception e) {
		return "Erro generico com data de vigencia " + e.getMessage() ;
	}

}
