package com.ostemplate.app.clientes.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.ostemplate.app.clientes.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
