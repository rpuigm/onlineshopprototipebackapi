package net.ostemplate.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.entity.CestaDTO;
import net.ostemplate.app.productos.models.service.CestaServiceImpl;

@RestController
public class CestaController {

	@Autowired
	private CestaServiceImpl cestaServiceImpl;
	


	
	@GetMapping("/cesta/recupera-cesta/{idUsuario}")
	public Cesta recuperaCestaPorIdUsuario (@PathVariable Long idUsuario) {
		return cestaServiceImpl.buscarCestaPorUsuarioId(idUsuario);
	}
	
	
	@PostMapping("/cesta/actualiza-cesta")
	public Cesta actualizaCesta(@RequestBody CestaDTO cesta) {
		System.out.println("numero productos en cesta"+cesta.getProductoCantidad().size());
		return cestaServiceImpl.actualizaCesta(cesta);
	}
	
	@GetMapping("/cesta/listacestas")
	public List<Cesta> listaCestas(){
		return cestaServiceImpl.listaCestas();
	}
	
	@DeleteMapping("/cesta/elimina-cesta")
	public void recuperaCestaPorIdUsuario (@RequestBody CestaDTO cesta) {
		cestaServiceImpl.eliminaCesta(cesta);
	}
	
}
