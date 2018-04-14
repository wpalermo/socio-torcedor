package com.wpalermo.campanha.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wpalermo.campanha.entities.Campanha;

@Repository
public interface CampanhaRepository extends CrudRepository<Campanha, Integer>{
	
	List<Campanha> findByIdTimeCoracao(Integer idTimeCoracao);

}
