package com.wpalermo.campanha.controller.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wpalermo.campanha.entities.Campanha;
import com.wpalermo.campanha.request.CampanhaRequest;
import com.wpalermo.campanha.response.CampanhaResponse;

@FeignClient("campanhaFeign")
public interface ICampanhaFeignController {

	
	@RequestMapping(method = RequestMethod.GET,  value = "/campanhaFeign")
	ResponseEntity<List<Campanha>> get();
	
	@RequestMapping(method = RequestMethod.PUT, value = "/campanhaFeign/{id}")
	ResponseEntity<CampanhaResponse> put(@PathVariable Integer id, RequestEntity<CampanhaRequest> request);
	
}
