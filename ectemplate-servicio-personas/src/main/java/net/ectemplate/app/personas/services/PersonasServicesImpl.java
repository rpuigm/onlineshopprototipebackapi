package net.ectemplate.app.personas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ectemplate.app.personas.dao.UsuariosRepository;
import net.ectemplate.app.personas.entities.Usuario;

@Service
public class PersonasServicesImpl implements PersonasServicesI{
	
	@Autowired
	private UsuariosRepository personasRepository;

	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>)personasRepository.findAll();
	}

	@Override
	public Usuario actualizaUsuario(Usuario usuario) {
		return personasRepository.save(usuario);
	}

	
}
