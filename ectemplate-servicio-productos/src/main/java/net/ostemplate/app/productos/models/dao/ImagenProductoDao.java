package net.ostemplate.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.ImagenProducto;

public interface ImagenProductoDao extends CrudRepository<ImagenProducto, Long> {

	void deleteByImagen(String imagen);

}
