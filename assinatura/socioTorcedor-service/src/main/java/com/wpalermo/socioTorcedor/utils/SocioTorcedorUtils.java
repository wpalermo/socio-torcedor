package com.wpalermo.socioTorcedor.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.wpalermo.socioTorcedor.entities.Campanha;
import com.wpalermo.socioTorcedor.entities.SocioTorcedor;

public class SocioTorcedorUtils {
	
	
	public static SocioTorcedor atualizarCampanhas(SocioTorcedor socio, List<Campanha> campanhas) {

		Set<Integer> ids = socio.getTimeCoracao().getCampanhasAssociadas().stream().map(Campanha::getIdCampanha).collect(Collectors.toSet());

		List<Campanha> campanhasFaltantes = campanhas.stream().filter(camp -> !ids.contains(camp.getIdCampanha())).collect(Collectors.toList());

		socio.getTimeCoracao().getCampanhasAssociadas().addAll(campanhasFaltantes);

		return socio;
	}

}
