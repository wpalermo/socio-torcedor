package com.wpalermo.socioTorcedor.service;

public interface IRestRequest<T> {
	
	void callBack(T object);
	
	T request(T object);
	
	void serviceError(T object, Throwable throwable);

	void serviceSuccess(T object);

	
	
	
}
