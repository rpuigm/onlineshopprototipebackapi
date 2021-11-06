package net.ectemplate.app.personas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.ectemplate.app.personas.entities.Usuario;

@RepositoryRestResource(path="usuarios")
public interface UsuariosRepository extends PagingAndSortingRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
}
