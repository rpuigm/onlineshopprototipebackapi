package net.ectemplate.app.personas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ectemplate.app.personas.dao.PersonasRepository;
import net.ectemplate.app.personas.entities.Persona;

@Service
public class PersonasServicesImpl implements PersonasServicesI{
	
	@Autowired
	private PersonasRepository personasRepository;

	@Override
	@Transactional
	public List<Persona> findAll() {
		return (List<Persona>)personasRepository.findAll();
	}

}
