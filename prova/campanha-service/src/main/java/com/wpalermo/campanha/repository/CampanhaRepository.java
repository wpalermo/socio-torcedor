package com.wpalermo.campanha.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wpalermo.campanha.entities.Campanha;

public interface CampanhaRepository extends CrudRepository<Campanha, Integer>{
	
	List<Campanha> findByIdTimeCoracao(Integer idTimeCoracao);

}
