package com.wpalermo.socioTorcedor.exception;

import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

public class PersistenceException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String message;
	public String detail;
	public PersistenceDatailEnum persistenceEnum;
	
	
	public PersistenceException() {
		super();
	}
	
	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public PersistenceException(String message) {
		super(message);
		this.message = message;
	}
	
	public PersistenceException(String message, PersistenceDatailEnum persistenceDatailEnum) {
		super(message);
		this.message = message;
		this.persistenceEnum = persistenceDatailEnum;
	}
	
	public PersistenceException(String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public PersistenceException(Throwable cause) {
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
