package com.ostemplate.app.clientes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ostemplate.app.clientes.model.entity.Cliente;

@RestController 
public class ClientesController {
	
	@GetMapping("listaclientes")
	public List<Cliente> getListaClientes (){
		
		return null;
		
	}

}
