package net.ectemplate.app.personas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.ectemplate.app.personas.entities.Persona;

@Repository
public interface PersonasRepository extends PagingAndSortingRepository<Persona, Long> {

	
}
