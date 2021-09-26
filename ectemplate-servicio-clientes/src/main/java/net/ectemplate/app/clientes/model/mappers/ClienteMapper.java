package net.ectemplate.app.clientes.model.mappers;

import net.ectemplate.app.clientes.model.entity.Cliente;

public class ClienteMapper {
	
	public static void mapToCliente(Cliente cliente, Long id, String nombre, String apellidos){
		cliente.setId(id);
		cliente.setApellidos(apellidos);
		cliente.setNombre(nombre);
		
	}

}
