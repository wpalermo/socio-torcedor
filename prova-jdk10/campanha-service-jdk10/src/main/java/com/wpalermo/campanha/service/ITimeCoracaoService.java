package com.wpalermo.campanha.service;

import java.util.List;

import com.wpalermo.campanha.entities.Campanha;

public interface ITimeCoracaoService {

	/**
	 * Busca time do coracao por seu ID
	 * @param id
	 * @return
	 */
	List<Campanha> findById(Integer id);
	
}
