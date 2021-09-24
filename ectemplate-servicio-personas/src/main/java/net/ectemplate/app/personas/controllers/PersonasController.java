package net.ectemplate.app.personas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonasController {
	
	@GetMapping("/prueba")
	public String prueba() {
		return "OK";
	}

}
