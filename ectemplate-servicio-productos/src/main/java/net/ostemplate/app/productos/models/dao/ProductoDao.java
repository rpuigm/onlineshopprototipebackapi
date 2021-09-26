package net.ostemplate.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.Producto;


public interface ProductoDao extends CrudRepository<Producto, Long>{

}
