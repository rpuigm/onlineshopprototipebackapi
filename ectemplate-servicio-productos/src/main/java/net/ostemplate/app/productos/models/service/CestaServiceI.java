package net.ostemplate.app.productos.models.service;

import java.util.List;

import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.entity.CestaDTO;

public interface CestaServiceI {
	
	Cesta guardaCesta(Cesta cesta);


	Cesta buscarCestaPorUsuarioId(Long idUsuario);

	Cesta eliminarDeLaCesta(Long idUsuario, Long idProducto);

	List<Cesta> listaCestas();

	Cesta actualizaCesta(CestaDTO cesta);


	void eliminaCesta(Cesta cesta);


	void eliminarUnProductoDeLasCestas(Long idProducto);

}
