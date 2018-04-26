package com.wpalermo.socioTorcedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;

public interface SocioTorcedorRepository extends MongoRepository<SocioTorcedor, String>{

}
