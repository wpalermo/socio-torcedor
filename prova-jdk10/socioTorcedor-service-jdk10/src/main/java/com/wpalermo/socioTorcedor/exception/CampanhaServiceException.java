package com.wpalermo.socioTorcedor.exception;

import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

public class CampanhaServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String message;
	public String detail;
	public PersistenceDatailEnum persistenceEnum;
	
	
	public CampanhaServiceException() {
		super();
	}
	
	public CampanhaServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public CampanhaServiceException(String message) {
		super(message);
		this.message = message;
	}
	
	public CampanhaServiceException(String message, PersistenceDatailEnum persistenceDatailEnum) {
		super(message);
		this.message = message;
		this.persistenceEnum = persistenceDatailEnum;
	}
	
	public CampanhaServiceException(String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public CampanhaServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
