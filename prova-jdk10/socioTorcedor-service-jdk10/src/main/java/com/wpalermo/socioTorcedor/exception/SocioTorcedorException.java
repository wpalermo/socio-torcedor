package com.wpalermo.socioTorcedor.exception;

import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

public class SocioTorcedorException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String message;
	public String detail;
	public PersistenceDatailEnum persistenceEnum;
	
	
	public SocioTorcedorException() {
		super();
	}
	
	public SocioTorcedorException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public SocioTorcedorException(String message) {
		super(message);
		this.message = message;
	}
	
	public SocioTorcedorException(String message, PersistenceDatailEnum persistenceDatailEnum) {
		super(message);
		this.message = message;
		this.persistenceEnum = persistenceDatailEnum;
	}
	
	public SocioTorcedorException(String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public SocioTorcedorException(Throwable cause) {
		super(cause);
	}
	
	
	
	public PersistenceDatailEnum getPersistenceEnum() {
		return persistenceEnum;
	}

	@Override
	public String getMessage() {
		if(this.message != null)
			return this.message;
		
		return super.getMessage();
	}
	

}
