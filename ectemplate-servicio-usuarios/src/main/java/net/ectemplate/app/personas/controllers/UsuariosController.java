package net.ectemplate.app.personas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ectemplate.app.personas.entities.Persona;
import net.ectemplate.app.personas.services.PersonasServicesI;

@RestController
public class PersonasController {
	
	@Autowired
	private PersonasServicesI personasServicesI;
	
	@GetMapping("/listapersonas")
	public List<Persona> prueba() {
		return personasServicesI.findAll();
	}

}
