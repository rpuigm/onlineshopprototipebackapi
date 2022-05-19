package net.ostemplate.app.productos.models.service;

import net.ostemplate.app.productos.models.entity.TiendaEntity;

public interface TiendaServiceI {


	String actualizaTienda(String nombreTienda);

	TiendaEntity getNombreDeTienda();

	TiendaEntity guardaTienda(TiendaEntity tiendaEntity);

}
