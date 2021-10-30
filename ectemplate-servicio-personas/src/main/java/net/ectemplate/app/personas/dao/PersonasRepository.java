package net.ectemplate.app.personas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.ectemplate.app.personas.entities.Persona;

@RepositoryRestResource(path="personas")
public interface PersonasRepository extends PagingAndSortingRepository<Persona, Long> {

	
}
