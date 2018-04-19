package com.wpalermo.campanha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wpalermo.campanha.entities.Pessoa;

@Controller
@RequestMapping("/teste")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Pessoa> home() {
		Pessoa p = new Pessoa();
		p .setNome("Nome");
        return new ResponseEntity<Pessoa>(p, HttpStatus.ACCEPTED);
    }
}
