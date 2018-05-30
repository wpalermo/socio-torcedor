package com.wpalermo.campanha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.repository.CampanhaRepository;
import com.wpalermo.campanha.service.ITimeCoracaoService;

@Service
public class TimeCoracaoService implements ITimeCoracaoService {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@Override
	public List<Campanha> findById(Integer id) {
		return campanhaRepository.findByIdTimeCoracao(id);
	}

}
