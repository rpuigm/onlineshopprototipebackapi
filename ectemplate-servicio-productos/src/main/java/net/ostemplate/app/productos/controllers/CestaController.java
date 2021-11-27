package net.ostemplate.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.service.CestaServiceImpl;

@RestController
public class CestaController {

	@Autowired
	private CestaServiceImpl cestaServiceImpl;

	@PostMapping("cesta/incluye-cesta")
	public Cesta incluyeEnCesta(@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("idProducto") Long idProducto) {
		return cestaServiceImpl.incluirEnCesta(idUsuario, idProducto);
	}
	
	@GetMapping("cesta/recupera-cesta/{id}")
	public Cesta recuperaCestaPorIdUsuario (@PathVariable Long idUsuario) {
		return cestaServiceImpl.buscarCestaPorUsuarioId(idUsuario);
	}
	
	@DeleteMapping("cesta/elimina-cesta")
	public Cesta eliminaDeLaCesta(@RequestParam("idUsuario") Long idUsuario,
			@RequestParam("idProducto") Long idProducto) {
		return cestaServiceImpl.eliminarDeLaCesta(idUsuario, idProducto);
	}
	
	@GetMapping("cesta/listacestas")
	public List<Cesta> listaCestas(){
		return cestaServiceImpl.listaCestas();
	}
	
}
