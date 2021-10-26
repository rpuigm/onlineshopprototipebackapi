package net.ostemplate.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.Producto;


public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	List<Producto> findByNombre (String nombre);
}
