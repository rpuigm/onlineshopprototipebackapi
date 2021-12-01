package net.ectemplate.app.personas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ectemplate.app.personas.dao.UsuariosRepository;
import net.ectemplate.app.personas.entities.Role;
import net.ectemplate.app.personas.entities.Usuario;

@Service
public class PersonasServicesImpl implements PersonasServicesI {

	@Autowired
	private BCryptPasswordEncoder bCryp;

	@Autowired
	private UsuariosRepository personasRepository;

	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) personasRepository.findAll();
	}

	@Override
	@Transactional
	public Usuario actualizaUsuario(Usuario usuario) {
		Optional<Usuario> usuarioAnt = personasRepository.findById(usuario.getId());
		if (!usuario.getPassword().equals(usuarioAnt.get().getPassword()))
			usuario.setPassword(bCryp.encode(usuario.getPassword()));
		usuario = personasRepository.save(usuario);
		return usuario;
	}

	@Override
	@Transactional
	public Usuario altaCliente(Usuario usuario) {

			Role role = new Role();
			role.setId(1L);
			role.setNombre("ROLE_USER");
			List<Role> listaRoles = new ArrayList<Role>();
			listaRoles.add(role);
			usuario.setRoles(listaRoles);
			usuario.setPassword(bCryp.encode(usuario.getPassword()));
			usuario = personasRepository.save(usuario);
//		}
		return usuario;

	}

	private String encripta(String string) {
		return bCryp.encode(string);
	}
}
