package net.ectemplate.app.clientes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ClientesController {
	
	@GetMapping("/prueba")
	public String prueba() {
		
		return "OK";
	}
	

}
