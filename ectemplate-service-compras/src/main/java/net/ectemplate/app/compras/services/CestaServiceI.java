package net.ectemplate.app.compras.services;

import net.ectemplate.app.compras.entities.Cesta;

public interface CestaServiceI {
	
	Cesta guardaCesta(Cesta cesta);

	Cesta incluirEnCesta(Long idUsuario, Long idProducto);

	Cesta buscarCestaPorUsuarioId(Long idUsuario);

	Cesta eliminarDeLaCesta(Long idUsuario, Long idProducto);

}
