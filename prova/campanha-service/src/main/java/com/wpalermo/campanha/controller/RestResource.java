package com.wpalermo.campanha.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.wpalermo.campanha.response.CampanhaResponse;

public interface RestResource<T, K> {

	
	ResponseEntity<T> get();
	
	ResponseEntity<T> put();
	
	ResponseEntity<T> post(RequestEntity<K> request) throws Exception;
	
	void delete(RequestEntity<K> request);
	
	
}
