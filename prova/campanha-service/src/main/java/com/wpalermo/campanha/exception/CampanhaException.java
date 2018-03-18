package com.wpalermo.campanha.exception;

public class CampanhaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String message;
	public String detail;
	
	
	public CampanhaException() {
		super();
	}
	
	public CampanhaException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public CampanhaException(String message) {
		super(message);
		this.message = message;
	}
	
	public CampanhaException(String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public CampanhaException(Throwable cause) {
		super(cause);
	}
	
	@Override
	public String getMessage() {
		if(this.message != null)
			return this.message;
		
		return super.getMessage();
	}
	

}
