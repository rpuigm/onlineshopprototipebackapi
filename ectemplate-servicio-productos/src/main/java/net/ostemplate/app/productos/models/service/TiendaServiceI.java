package net.ostemplate.app.productos.models.service;

import net.ostemplate.app.productos.models.entity.Tienda;

public interface TiendaServiceI {


	String actualizaTienda(String nombreTienda);

	Tienda getNombreDeTienda();

	Tienda guardaTienda(Tienda tienda);

}
