package com.wpalermo.campanha.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.repository.CampanhaRepository;

@Component
public class Initializer implements ApplicationRunner {
	
	@Autowired
	private CampanhaRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

	List<Campanha> campanhas = new ArrayList<Campanha>();
		
		
		Campanha campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Natal");
		campanhas.add(campanha);

		
		campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(1);
		campanha.setNomeCampanha("Dia das Maes");
		campanhas.add(campanha);

		
		campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(2);
		campanha.setNomeCampanha("Dia dos namorados");
		campanhas.add(campanha);

		campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(2);
		campanha.setNomeCampanha("Dia dos Pais");
		campanhas.add(campanha);

		campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(3);
		campanha.setNomeCampanha("Black Friday");
		campanhas.add(campanha);

		campanha = new Campanha();
		campanha.setDataFimVigencia(LocalDate.now());
		campanha.setDataInicioVigencia(LocalDate.now());
		campanha.setIdTimeCoracao(4);
		campanha.setNomeCampanha("Natal");
		campanhas.add(campanha);

		
		repository.saveAll(campanhas);
		
		
		
	}

}
