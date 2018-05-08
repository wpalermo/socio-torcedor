package com.wpalermo.socioTorcedor.service;

import com.wpalermo.socioTorcedor.entities.SocioTorcedor;

public interface ICampanhaHttpRequest {
	
	void requestCampanhas(SocioTorcedor socioTorcedor);
	
	void serviceError();

}
