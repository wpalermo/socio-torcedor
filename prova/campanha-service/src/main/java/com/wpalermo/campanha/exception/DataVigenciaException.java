package com.wpalermo.campanha.exception;

public class DataVigenciaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String message;
	public String detail;
	
	
	public DataVigenciaException() {
		super();
	}
	
	public DataVigenciaException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}
	
	public DataVigenciaException(String message) {
		super(message);
		this.message = message;
	}
	
	public DataVigenciaException(String message, String detail) {
		super(message);
		this.message = message;
		this.detail = detail;
	}
	
	public DataVigenciaException(Throwable cause) {
		super(cause);
	}
	
	@Override
	public String getMessage() {
		if(this.message != null)
			return this.message;
		
		return super.getMessage();
	}
	
}
