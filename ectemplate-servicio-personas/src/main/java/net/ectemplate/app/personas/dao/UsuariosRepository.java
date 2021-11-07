package net.ectemplate.app.personas.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import net.ectemplate.app.personas.entities.Usuario;

@RepositoryRestResource(path="usuarios")
public interface UsuariosRepository extends PagingAndSortingRepository<Usuario, Long> {

	@RestResource(path="buscar-username")
	public List<Usuario> findByUsername(@Param("nombreUsuario") String username);
	
	
}
