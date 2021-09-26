package net.ectemplate.app.empleados.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosControllers {

	@GetMapping("prueba")
	public String prueba() {
		
		return "OK";
	}
	
}
