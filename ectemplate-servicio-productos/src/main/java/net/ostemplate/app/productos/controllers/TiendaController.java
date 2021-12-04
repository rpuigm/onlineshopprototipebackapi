package net.ostemplate.app.productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.service.TiendaServiceI;

@RestController
public class TiendaController {
	
	@Autowired
	private TiendaServiceI tiendaServiceI;
	
	@GetMapping("/tienda/nombre")
	public String getNombreTienda() {
		return tiendaServiceI.getNombreDeTienda();
	}
	
	@PutMapping("/tienda/cambia-nombre/{nombre}")
	public String cambiaNombre(@PathVariable String nombre) {
		return tiendaServiceI.actualizaTienda(nombre);
	}

}
