package net.ostemplate.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.Producto;


public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	/**
	 * Devuelve una lista de productos por nombre
	 * @param nombre
	 * @return List<Producto>
	 */
	List<Producto> findByNombre (String nombre);
	
	List<Producto> findByNombreLike (String nombre);
}
