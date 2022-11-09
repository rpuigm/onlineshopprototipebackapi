package net.ostemplate.app.productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.entity.Tienda;
import net.ostemplate.app.productos.models.entity.TiendaEntity;
import net.ostemplate.app.productos.models.service.TiendaServiceI;

@RestController
public class TiendaController {

	@Autowired
	private TiendaServiceI tiendaServiceI;

	@GetMapping("/tienda/nombre")
	public Tienda getNombreTienda() {
		return tiendaServiceI.getNombreDeTienda();
	}

	@PostMapping("/tienda/cambia-nombre/{nombre}")
	public String cambiaNombre(@PathVariable String nombre) {
		return tiendaServiceI.actualizaTienda(nombre);
	}

	@PostMapping("/tienda/cambia-tienda")
	public Tienda cambiaNombre(@RequestBody Tienda tienda) {
		TiendaEntity tiendaEntity = new TiendaEntity();
		tiendaEntity.setId(tienda.getId());
		tiendaEntity.setNombreTienda(tienda.getNombreTienda());
		return tiendaServiceI.guardaTienda(tiendaEntity);
	}

}
