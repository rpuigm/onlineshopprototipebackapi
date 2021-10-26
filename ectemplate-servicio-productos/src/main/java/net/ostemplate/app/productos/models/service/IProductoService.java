package net.ostemplate.app.productos.models.service;

import java.util.List;

import net.ostemplate.app.productos.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	public void insertProducto(Producto producto);
	public void borrarProducto(Long id);
	public Producto buscarPorNombre(String nombre);
}
