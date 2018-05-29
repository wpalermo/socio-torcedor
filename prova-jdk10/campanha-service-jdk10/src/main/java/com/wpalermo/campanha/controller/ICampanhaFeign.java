package com.wpalermo.campanha.controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("campanha")
public interface ICampanhaFeign {

}
