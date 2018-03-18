package com.wpalermo.campanha.persistence;

import java.util.LinkedList;

import com.wpalermo.campanha.bean.Campanha;
import com.wpalermo.campanha.exception.CampanhaException;


/**
 * Classe de persistencia simula um banco de dados em memoria. 
 * @author paler
 *
 */
public class CampanhaPersistence {

	private static LinkedList<Campanha> campanhas;
	private static Integer id;

	private static CampanhaPersistence instance = null;

	public static CampanhaPersistence getInstance() {
		if (instance == null)
			instance = new CampanhaPersistence();

		return instance;
	}

	public CampanhaPersistence() {
		campanhas = new LinkedList<Campanha>();
		id = 1;
	}

	public static void addCampanha(Campanha campanha) throws CampanhaException {

		if (campanha.getIdCampanha() != null) {
			try {
				Campanha c = campanhas.stream().filter(camp -> camp.getIdCampanha() == campanha.getIdCampanha())
						.findFirst().orElseGet(null);
				if (c != null)
					throw new CampanhaException(
							"Nao foi possivel adicionar - Campanha ja exitente " + c.getIdCampanha());

			} catch (IndexOutOfBoundsException e) {
				campanha.setIdCampanha(id);
				campanhas.add(campanha);
				id++;
			}
		} else {
			campanha.setIdCampanha(id);
			campanhas.add(campanha);
			id++;
		}
	}

	public static void updateCampanha(Campanha campanha) throws CampanhaException {

		if (campanha.getIdCampanha() != null) {
			try {
				Campanha c = campanhas.stream().filter(camp -> camp.getIdCampanha() == campanha.getIdCampanha())
						.findFirst().orElseGet(null);

				if (c != null)
					campanhas.set(campanhas.indexOf(c), campanha);

			} catch (IndexOutOfBoundsException e) {
				throw new CampanhaException("Nao foi possivel realizar o update - ID da campanha nao encontrado - ID: " + campanha.getIdCampanha());
			}
		} else {
			throw new CampanhaException("ID da campanha nulo");
		}
	}

	public static void deleteCampanha(Integer campanhaId) throws CampanhaException {

		if (campanhaId != null) {
			Campanha c = campanhas.stream().filter(camp -> camp.getIdCampanha() == campanhaId).findFirst()
					.orElse(null);

			if (c != null) {
				campanhas.remove(c);
			} else
				throw new CampanhaException("Nao foi possivel deletar campanha - ID da campanha nao encontrado - ID: " + campanhaId);

		} else {
			throw new CampanhaException("ID da campanha nulo");
		}
	}

	public static Campanha readCampanha(Integer campanhaId) throws CampanhaException {

		if (campanhaId != null) {
			return campanhas.stream().filter(camp -> camp.getIdCampanha() == campanhaId).findFirst()
					.orElse(null);

		} else
			throw new CampanhaException("ID da campanha nao encontrado - ID: " + campanhaId);

	}
	
	
	public static LinkedList<Campanha> getAll(){
		return campanhas;
	}

}
