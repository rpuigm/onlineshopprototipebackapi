package net.ectemplate.app.personas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.ectemplate.app.personas.entities.Persona;

@Repository
public interface PersonasRepository extends CrudRepository<Persona, Long> {

}
