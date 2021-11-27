package net.ostemplate.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.Cesta;

public interface ComprasRepository extends CrudRepository<Cesta, Long> {
	
	Cesta findByIdUsuarioAndActiva(Long idUsuario, boolean activa);

}
