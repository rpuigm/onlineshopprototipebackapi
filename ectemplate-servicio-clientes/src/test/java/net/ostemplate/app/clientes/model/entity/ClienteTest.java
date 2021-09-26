package net.ostemplate.app.clientes.model.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.ectemplate.app.clientes.model.entity.Cliente;
import net.ectemplate.app.clientes.model.mappers.ClienteMapper;

public class ClienteTest {
	
	@Test
	public void nuevoClienteTest() {
		Cliente cliente = new Cliente(1L,"nombre", "apellidos");
		Cliente cliente2 = new Cliente();
		ClienteMapper.mapToCliente(cliente2, 1L, "nombre", "apellidos");
		Assertions.assertEquals(cliente.getId(), cliente2.getId());
		Assertions.assertEquals(cliente.getNombre(), cliente2.getNombre());
		Assertions.assertEquals(cliente.getApellidos(), cliente2.getApellidos());
		
	}
}
