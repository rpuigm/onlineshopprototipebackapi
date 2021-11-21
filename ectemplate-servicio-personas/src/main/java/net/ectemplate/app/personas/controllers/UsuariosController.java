package net.ectemplate.app.personas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ectemplate.app.personas.entities.Usuario;
import net.ectemplate.app.personas.services.PersonasServicesI;

@RestController
public class UsuariosController {
	
	@Autowired
	private PersonasServicesI personasServicesI;
	
	@GetMapping("/listapersonas")
	public List<Usuario> prueba() {
		return personasServicesI.findAll();
	}
	
	@PutMapping("/actualiza-usuario")
	public Usuario actualizaUsuario(@RequestBody Usuario usuario) {
		return personasServicesI.actualizaUsuario(usuario);
	}

}
