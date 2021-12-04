package net.ostemplate.app.productos.models.service;

import java.util.List;

import net.ostemplate.app.productos.models.entity.Producto;

public interface ProductoServiceI {

	/**
	 * Devuelve la lista de todos los productos
	 * @return List<Producto>
	 */
	public List<Producto> findAll();
	
	/**
	 * Devuelve un producto por su identificador
	 * @param id
	 * @return Producto
	 */
	public Producto findById(Long id);
	
	/**
	 * Guarda un nuevo producto
	 * @param producto
	 */
	public Producto insertProducto(Producto producto);
	
	/**
	 * Borra un producto por su identificador
	 * @param id
	 */
	public void borrarProducto(Long id);
	
	/**
	 * Devuelve una lista de productos por nombre
	 * @param nombre
	 * @return List<Producto>
	 */
	public List<Producto> buscarPorNombre(String nombre);
	
	/**
	 * Devuelve una lista de productos cuyo nombre contiene una cadena
	 * @param nombre
	 * @return
	 */
	public List<Producto> buscarPorContieneEnNombre(String nombre);
	
	/**
	 * Devuelve el producto modificado
	 * @param producto
	 * @return producto
	 */
	public Producto modificarProducto(Producto producto);

	void borrarUnProducto(Producto producto);
	
	
}
