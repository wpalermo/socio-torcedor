package com.wpalermo.campanha.service;

import java.util.List;

import com.wpalermo.campanha.entities.Campanha;

public interface ITimeCoracaoService {

	
	List<Campanha> findById(Integer id);
	
}
