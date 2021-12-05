package net.ostemplate.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.ProductoCantidad;

public interface ProductoCantidadRepository extends CrudRepository<ProductoCantidad, Long> {
	
	void deleteAllByIdProducto (Long idProducto);
	
	List<ProductoCantidad> findAllByIdProducto(Long idProducto);

}
