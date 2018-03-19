package com.wpalermo.campanha.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wpalermo.campanha.bean.Campanha;

public interface CamapnhaMongoRepository extends MongoRepository<Campanha, Integer>{
	
	public Campanha findByIdTimeCoracao(Integer id);

}
