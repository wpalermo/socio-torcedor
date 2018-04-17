package com.wpalermo.socioTorcedor.exception;

import java.io.IOException;
import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
public class SocioTorcedorServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Falha no servico de socio torcedor")
	@ExceptionHandler(value=SocioTorcedorException.class)
	public String socioTorcedorException(Exception e) {
		return "Erro generico com servico de socio torcedor " + e.getMessage() ;
	}
	
	
	
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Problema com data de vigencia")
	@ExceptionHandler(value=IOException.class) 
	public String ioException(Exception e) {
		return "Erro generico com data de vigencia " + e.getMessage() ;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Chamada de servico externo")
	@ExceptionHandler(value= {ResourceAccessException.class, ConnectException.class}) 
	public String httpException(Exception e) {
		return "Erro ao acessar servico externo " + e.getMessage() ;
	}
	
	

}
