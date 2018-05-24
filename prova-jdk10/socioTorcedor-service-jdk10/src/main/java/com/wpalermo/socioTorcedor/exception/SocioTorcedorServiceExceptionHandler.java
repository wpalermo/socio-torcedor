package com.wpalermo.socioTorcedor.exception;

import java.io.IOException;
import java.net.ConnectException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
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
	
	@ExceptionHandler(value = { HttpClientErrorException.class, ConnectException.class })
    protected ResponseEntity<Object>  handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Problema ao acessar servico de campanha";
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	
	
	@ExceptionHandler(value = { NoSuchElementException.class})
    protected ResponseEntity<Object>  socioNaoEncontrado(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "SocioTorcedor nao encontrado \n" + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	

	
	

}
