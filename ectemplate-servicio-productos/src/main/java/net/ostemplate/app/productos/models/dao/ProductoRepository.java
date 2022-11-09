package net.ostemplate.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.ProductoEntity;

public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {

	/**
	 * Devuelve una lista de productos por nombre
	 * @param nombre
	 * @return List<Producto>
	 */
	List<ProductoEntity> findByNombre(String nombre);

	List<ProductoEntity> findByNombreLike(String nombre);
}
