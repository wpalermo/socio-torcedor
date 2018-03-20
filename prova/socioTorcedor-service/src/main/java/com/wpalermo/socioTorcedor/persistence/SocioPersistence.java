package com.wpalermo.socioTorcedor.persistence;

import java.util.LinkedList;

import com.wpalermo.socioTorcedor.bean.SocioTorcedor;
import com.wpalermo.socioTorcedor.exception.PersistenceException;
import com.wpalermo.socioTorcedor.utils.PersistenceDatailEnum;

public class SocioPersistence {

	private static LinkedList<SocioTorcedor> socios;
	private static Integer id;

	private static SocioPersistence instance = null;

	public static SocioPersistence getInstance() {
		if (instance == null)
			instance = new SocioPersistence();

		return instance;
	}

	public SocioPersistence() {
		socios = new LinkedList<SocioTorcedor>();
		id = 1;
	}

	public static void insertSocio(SocioTorcedor socio) throws PersistenceException {

		if (socio.getEmail() != null) {
			try {
				SocioTorcedor s = socios.stream().filter(st -> st.getEmail().equals(socio.getEmail()))
						.findFirst().orElse(null);
				if (s != null)
					throw new PersistenceException(
							"Nao foi possivel adicionar - Email ja exitente " + s.getEmail(), PersistenceDatailEnum.EMAIL_EXISTENTE);
				else
					socios.add(socio);

			} catch (IndexOutOfBoundsException e) {
				socios.add(socio);
			}
		} else {
			socios.add(socio);
			id++;
		}
	}

	public static void updateSocio(SocioTorcedor socioTorcedor) throws PersistenceException {

		if (socioTorcedor.getEmail() != null) {
			try {
				SocioTorcedor c = socios.stream().filter(camp -> camp.getEmail().equalsIgnoreCase(socioTorcedor.getEmail()))
						.findFirst().orElseGet(null);

				if (c != null)
					socios.set(socios.indexOf(c), socioTorcedor);

			} catch (IndexOutOfBoundsException e) {
				throw new PersistenceException("Nao foi possivel realizar o update - Socio nao encontrado - Email: " + socioTorcedor.getEmail());
			}
		} else {
			throw new PersistenceException("Email nulo");
		}
	}

	public static void deleteSocio(String email) throws PersistenceException {

		if (email != null) {
			SocioTorcedor socio = socios.stream().filter(st -> st.getEmail().equals(email)).findFirst()
					.orElse(null);

			if (socio != null) {
				socios.remove(socio);
			} else
				throw new PersistenceException("Nao foi possivel deletar socio - Email nao encontrado - Email: " + email);

		} else {
			throw new PersistenceException("Email nulo");
		}
	}

	public static SocioTorcedor readSocio(String email) throws PersistenceException {

		if (email != null) {
			SocioTorcedor s = socios.stream().filter(st -> st.getEmail().equals(email)).findFirst()
					.orElse(null);
			if(s == null)
				throw new PersistenceException("Email nao encontrado - Email: " + email);
			
			return s;

		} else
			throw new PersistenceException("Email nao encontrado - Email: " + email);

	}
	
	
	public static LinkedList<SocioTorcedor> getAll(){
		return socios;
	}
	


}
