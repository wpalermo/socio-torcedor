package com.wpalermo.socioTorcedor.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestServers implements Serializable {

	private static final long serialVersionUID = 1L;


	@Value("${campanha.ip}")
	private String campanhaIp;
	
	
	@Value("${campanha.port}")
	private String campanhaPort;


	public String getCampanhaIp() {
		return campanhaIp;
	}


	public void setCampanhaIp(String campanhaIp) {
		this.campanhaIp = campanhaIp;
	}


	public String getCampanhaPort() {
		return campanhaPort;
	}


	public void setCampanhaPort(String campanhaPort) {
		this.campanhaPort = campanhaPort;
	}
	
	public String getCampanhaUrl() {
		return this.campanhaIp + ":" + this.campanhaPort;
	}
	
}
