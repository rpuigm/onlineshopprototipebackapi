package net.ectemplate.app.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ectemplate.app.compras.entities.Cesta;
import net.ectemplate.app.compras.services.CestaServiceImpl;

@RestController
public class CestaController {

	@Autowired
	private CestaServiceImpl cestaServiceImpl;

	@PostMapping("/incluye-cesta")
	public Cesta incluyeEnCesta(@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("idProducto") Long idProducto) {
		return cestaServiceImpl.incluirEnCesta(idUsuario, idProducto);
	}
	
	@GetMapping("/recupera-cesta/{id}")
	public Cesta recuperaCestaPorIdUsuario (@PathVariable Long idUsuario) {
		return cestaServiceImpl.buscarCestaPorUsuarioId(idUsuario);
	}
	
	@DeleteMapping("/elimina-cesta")
	public Cesta eliminaDeLaCesta(@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("idProducto") Long idProducto) {
		return cestaServiceImpl.eliminarDeLaCesta(idUsuario, idProducto);
	}
	
}
