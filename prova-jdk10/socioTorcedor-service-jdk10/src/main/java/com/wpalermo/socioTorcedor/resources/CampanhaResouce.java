package com.wpalermo.socioTorcedor.resources;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wpalermo.socioTorcedor.entities.Campanha;

@FeignClient(name = "campanha-service")
public interface CampanhaResouce{

	@RequestMapping(method = RequestMethod.GET, value = "campanha")
	List<Campanha> get();

}
