package net.ectemplate.app.personas.services;

import java.util.List;

import net.ectemplate.app.personas.dto.UsuarioDTO;
import net.ectemplate.app.personas.entities.Usuario;

public interface PersonasServicesI {
	
	public List<Usuario> findAll();
	
	public Usuario actualizaUsuario (UsuarioDTO usuarioDTO);

	Usuario altaCliente(UsuarioDTO usuarioDTO);

}
