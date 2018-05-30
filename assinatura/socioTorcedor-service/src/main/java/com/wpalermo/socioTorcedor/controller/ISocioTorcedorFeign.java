//package com.wpalermo.socioTorcedor.controller;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import com.wpalermo.socioTorcedor.entities.SocioTorcedor;
//
//@FeignClient("socioTorcerdorF")
//public interface ISocioTorcedorFeign {
//
//	
//	@RequestMapping(method = RequestMethod.POST,  value = "/socioTorcerdorF/")
//	ResponseEntity<SocioTorcedor> post(@RequestParam("request") RequestEntity<SocioTorcedor> request);
//
//	@RequestMapping(method = RequestMethod.GET,  value = "/socioTorcerdorF/{email}")
//	ResponseEntity<SocioTorcedor> get(@PathVariable("email") String email);
//
//	@RequestMapping(method = RequestMethod.GET,  value = "/socioTorcerdorF/{email}")
//	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
//	void put();
//
//	
//	@RequestMapping(method = RequestMethod.GET,  value = "/socioTorcerdorF/{email}")
//	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
//	void delete();
//
//}
