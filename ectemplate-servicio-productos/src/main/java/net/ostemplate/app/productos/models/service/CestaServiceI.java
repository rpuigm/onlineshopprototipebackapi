package net.ostemplate.app.productos.models.service;

import java.util.List;

import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.entity.CestaDTO;

public interface CestaServiceI {
	
	Cesta guardaCesta(CestaDTO cestaDTO);
	
	Cesta guardaCesta(Cesta cesta);

	Cesta buscarCestaPorUsuarioId(Long idUsuario);

	Cesta eliminarDeLaCesta(Long idUsuario, Long idProducto);

	List<Cesta> listaCestas();

	Cesta actualizaCesta(CestaDTO cestaDTO);


	void eliminaCesta(CestaDTO cestaDTO);


	void eliminarUnProductoDeLasCestas(Long idProducto);

}
