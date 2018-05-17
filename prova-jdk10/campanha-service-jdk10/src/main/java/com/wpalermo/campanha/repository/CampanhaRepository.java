package com.wpalermo.campanha.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wpalermo.campanha.entities.Campanha;

@Repository
public interface CampanhaRepository extends CrudRepository<Campanha, String>{
	
	/**
	 * Busca todas as campanhas de um time do coracao
	 * @param idTimeCoracao
	 * @return
	 */
	List<Campanha> findByIdTimeCoracao(Integer idTimeCoracao);
	
	/**
	 * Verifica se a data de fim de vigencia ja existe no banco
	 * @param dataFimVigencia
	 * @return
	 */
	boolean existsByDataFimVigencia(LocalDate dataFimVigencia);

}
