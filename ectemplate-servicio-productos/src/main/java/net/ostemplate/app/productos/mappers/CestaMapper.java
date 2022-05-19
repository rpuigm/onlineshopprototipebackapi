package net.ostemplate.app.productos.mappers;

import net.ostemplate.app.productos.models.entity.Cesta;

public class CestaMapper {

	public static Cesta mapToCesta() {
		Cesta cesta = new Cesta();
		cesta.setId(1L);
		cesta.setIdUsuario(1L);
		cesta.setProductoCesta(null);
		return cesta;

	}

}
