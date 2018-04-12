package com.wpalermo.campanha.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wpalermo.campanha.entities.Campanha;

public interface CampanhaRepository extends CrudRepository<Campanha, Integer>{
	
	@Modifying
	@Query("update Campanha c set c = ?2 where c.id = ?1 ")
	void update(Integer id, Campanha c);

}
